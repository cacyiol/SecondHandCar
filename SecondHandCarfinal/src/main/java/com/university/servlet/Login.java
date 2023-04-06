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

import com.university.impl.BuyerDatabaseDao;
import com.university.impl.CarDatabaseDao;
import com.university.object.Buyer;
import com.university.object.Car;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 - Collect the data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// TODO 2 - Verification of the parameters

		// 3 - Processing to the authentication
		BuyerDatabaseDao buyerDatabaseDao = new BuyerDatabaseDao();
		boolean authenticated = buyerDatabaseDao.authenticate(username, password);
		String login=null;
		if(authenticated)
		{
			login="true";
		}
		else {
			login="false";
		}
		// 3 - Save the user status
		HttpSession session = request.getSession();
		session.setAttribute("authenticated", login);		
		session.setAttribute("username", username);
		
		BuyerDatabaseDao buyerlist = new BuyerDatabaseDao();
		Buyer buyer=buyerlist.findBuyerByName(username);
						
		if(buyer.getId()==0) {
			session.setAttribute("BO",0);
		}
		else {
			session.setAttribute("BO",1);
		}
		CarDatabaseDao carlist =  new CarDatabaseDao();
		List<Car> resu = carlist.listAllCar();
				
		ServletContext sc = getServletContext();
		sc.setAttribute("carlist", resu);
			
		if(authenticated) {
			response.sendRedirect("index/frame.jsp");
		}
		else {	
			response.getWriter().write("There are something wrong!Please return back to login!");			
		}
		
	}

}
