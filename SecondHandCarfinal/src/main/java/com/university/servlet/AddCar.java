package com.university.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.CarDatabaseDao;
import com.university.object.Owner;

/**
 * Servlet implementation class AddCar
 */
@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
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
		
		//1-get the parameter and add the car according to the parameter
		CarDatabaseDao carDao=new CarDatabaseDao();
		Owner owner=new Owner();
		owner.setName(request.getParameter("owner"));
		double price=Double.parseDouble(request.getParameter("price"));
		carDao.addCar(price, owner, request.getParameter("brand"), request.getParameter("model"),request.getParameter("lpn"));
		
		//2-go to the next page
		response.sendRedirect("admin/success.jsp");
	}

}
