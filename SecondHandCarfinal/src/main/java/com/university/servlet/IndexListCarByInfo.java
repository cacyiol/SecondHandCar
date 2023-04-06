package com.university.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.CarDatabaseDao;
import com.university.object.Car;


/**
 * Servlet implementation class IndexListCarByInfo
 */
@WebServlet("/IndexListCarByInfo")
public class IndexListCarByInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexListCarByInfo() {
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
		
		//1-get the type that you choose 
		Integer info_type = Integer.parseInt(request.getParameter("index_type"));
		ServletContext sc=getServletContext();
		CarDatabaseDao carlist =  new CarDatabaseDao();
		List<Car> cars=new ArrayList<Car>();
		
		//list car by brand (User System)
		if(info_type==1)
		{
			String brand=request.getParameter("info");
			cars = carlist.ListCarByBrand(brand);
			sc.setAttribute("carlist", cars);
			
			if(cars.size()==0)
			{
				sc.setAttribute("carlist", null);
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				response.sendRedirect("index/welcome.jsp");			}	
			
		}
		//list car by model(User System)
		else if(info_type==2)
		{
			
			String model = request.getParameter("info");
			cars=carlist.ListCarByModel(model);
			sc.setAttribute("carlist", cars);

			if(cars.size()==0)
			{
				sc.setAttribute("carlist", null);
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				response.sendRedirect("index/welcome.jsp");
			}
		}
			
	}

}
