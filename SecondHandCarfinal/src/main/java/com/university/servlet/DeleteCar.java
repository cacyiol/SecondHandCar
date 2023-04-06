package com.university.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.CarDatabaseDao;
import com.university.object.Car;
import com.university.object.Owner;

/**
 * Servlet implementation class DeleteCar
 */
@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		////1-get the type that you choose
		Integer info_type = Integer.parseInt(request.getParameter("delete_type"));
		CarDatabaseDao carlist =  new CarDatabaseDao();
		Car car = new Car();
		
		//2-if you don't input the information which is used to search the car
		if(request.getParameter("delete_info")=="")
		{
			response.sendRedirect("admin/nothing.jsp");
		}
		//3-if you choose id to search and delete the car
		else if(info_type==1)
		{
			Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(request.getParameter("delete_info"));
            if (!m.matches()) {
            	response.sendRedirect("admin/nothing.jsp");
            }
            else 
            {
            	Integer idCar=Integer.parseInt(request.getParameter("delete_info"));
    			car=carlist.findCarById(idCar);
    			if(car.getIdCar()==0)
    			{
                	response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				carlist.removeCar(car);
    				response.sendRedirect("admin/success.jsp");
    			}
            }
		}
		// choose owner to delete the buyer
		else if(info_type==2)
		{
			String name = request.getParameter("delete_info");
			Owner owner = new Owner();
			owner.setName(name);
			List<Car> cars=carlist.listCarByOwner(owner);
			if(cars.get(0).getIdCar()==0)
			{
            	response.sendRedirect("admin/nothing.jsp");
			}
			else {
				for(Car car1:cars)
				{
					carlist.removeCar(car1);
				}
				response.sendRedirect("admin/success.jsp");
			}
			
		}
		// choose licensePlateNumber to delete the buyer
		else if(info_type==3)
		{
			String lpn=request.getParameter("delete_info");
			car=carlist.findCarByLicensePlateNumber(lpn);
			if(car.getIdCar()==0)
			{
            	response.sendRedirect("admin/nothing.jsp");
			}
			else {
				carlist.removeCar(car);
				response.sendRedirect("admin/success.jsp");
			}
		}
	}

}
