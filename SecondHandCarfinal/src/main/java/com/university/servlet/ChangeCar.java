package com.university.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.CarDatabaseDao;
import com.university.object.Car;

/**
 * Servlet implementation class ChangeCar
 */
@WebServlet("/ChangeCar")
public class ChangeCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1-get the the type of the information  
		Integer info_type = Integer.parseInt(request.getParameter("select_type"));
		
		//2-get the id of the car which your want to change 
		
		Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(request.getParameter("change_id"));
        if (!m.matches()) {
        	response.sendRedirect("admin/nothing.jsp");
        }else
        {
        	Integer change_id = Integer.parseInt(request.getParameter("change_id"));
        	CarDatabaseDao carlist =  new CarDatabaseDao();
    		Car car = new Car();
    		car.setIdCar(change_id);
    		
    		//change the brand
    		if(info_type==1)
    		{
    			String brand = request.getParameter("change_info");
    			if(brand==null)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			car.setBrand(brand);
    			
    		}
    		//change the model
    		else if(info_type==2)
    		{
    			String model = request.getParameter("change_info");	
    			if(model==null)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			car.setModel(model);
    			
    		}
    		//change the licensePlateNumber
    		else if(info_type==3)
    		{
    			String lpn=request.getParameter("change_info");
    			if(lpn==null)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			car.setLicensePlateNumber(lpn);
    		}
    		carlist.editCar(car);
    		response.sendRedirect("index/frame.jsp");
        }      
	}

}
