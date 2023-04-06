package com.university.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.impl.CarDatabaseDao;
import com.university.object.Car;
import com.university.object.Owner;

/**
 * Servlet implementation class UserCarList
 */
@WebServlet("/UserCarList")
public class UserCarList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCarList() {
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
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Owner owner = new Owner();
		owner.setName(username);
		CarDatabaseDao carlist =  new CarDatabaseDao();
		
		//list car by onwer
		List<Car> resu = carlist.listCarByOwner(owner);
		ServletContext sc = getServletContext();

		sc.setAttribute("carlist", resu);

		response.sendRedirect("index/CarList.jsp");
	}

}
