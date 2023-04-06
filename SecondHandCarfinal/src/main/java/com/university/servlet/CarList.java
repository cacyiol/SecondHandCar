package com.university.servlet;

import com.university.impl.*;
import com.university.object.Car;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarList
 */
@WebServlet("/CarList")
public class CarList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1-get the list of the car
		CarDatabaseDao carlist =  new CarDatabaseDao();
		List<Car> resu = carlist.listAllCar();
		
		//2-set attribute
		ServletContext sc = getServletContext();
		sc.setAttribute("carlist", resu);
		
		//3-turn to the next page
		response.sendRedirect("admin/CarList.jsp");
		
	}

}
