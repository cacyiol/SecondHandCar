package com.university.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.CarDatabaseDao;
import com.university.object.Car;
import com.university.object.Owner;

/**
 * Servlet implementation class ListCarByInfo
 */
@WebServlet("/ListCarByInfo")
public class ListCarByInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCarByInfo() {
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
		Integer info_type = Integer.parseInt(request.getParameter("type"));
		
		CarDatabaseDao carlist =  new CarDatabaseDao();
		List<Car> cars=new ArrayList<Car>();
		//list car by id
		if(info_type==1)
		{
			
			Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(request.getParameter("info"));
            if (!m.matches()) {
            	response.sendRedirect("admin/nothing.jsp");
            }
            else 
            {
            	Integer idCar=Integer.parseInt(request.getParameter("info"));
    			
    			Car car=carlist.findCarById(idCar);
    			cars.add(car);
    			ServletContext sc=getServletContext();
    			sc.setAttribute("carlist", cars);
    			
    			if(car.getIdCar()==0)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				response.sendRedirect("admin/CarList.jsp");
    			}
            }
		}
		//list car by name
		else if(info_type==2)
		{
			List<Car> resu = new ArrayList<Car>();
			String name = request.getParameter("info");
			Owner owner = new Owner();
			owner.setName(name);
			resu = carlist.listCarByOwner(owner);
			
			ServletContext sc=getServletContext();
			sc.setAttribute("carlist", resu);
			sc.setAttribute("type",2);

			if(resu.size()==0)
			{
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				response.sendRedirect("admin/CarList.jsp");
			}
		}
		//list car by licensePlateNumber
		else if(info_type==3)
		{
			
			Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(request.getParameter("info"));
            if (!m.matches()) {
            	response.sendRedirect("admin/nothing.jsp");
            }
            else 
            {
            	String lpn=request.getParameter("info");
    			
    			Car car=carlist.findCarByLicensePlateNumber(lpn);
    			cars.add(car);
    			ServletContext sc=getServletContext();
    			sc.setAttribute("carlist", cars);
    			
    			if(car.getIdCar()==0)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				response.sendRedirect("admin/CarList.jsp");
    			}
            }
		}	
		
	}

}
