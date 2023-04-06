package com.university.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.impl.BuyerDatabaseDao;
import com.university.impl.OwnerDatabaseDao;
import com.university.object.Buyer;
import com.university.object.Owner;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println(request.getParameter("status"));
		Integer info_type = Integer.parseInt(request.getParameter("status"));	
		
		// 1 - Collect the data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		// TODO 2 - Verification of the parameters
		
		// 3 - Processing to the authentication
		
		
		
		// 3 - Save the user status
		if(info_type==1) {
			Buyer buyer=new Buyer();
			buyer.setName(username);
			buyer.setPassword(password);
			System.out.println(buyer.getPassword());
			BuyerDatabaseDao buyerDao=new BuyerDatabaseDao();
			buyerDao.addBuyer(buyer);
		}
		else {
			Owner owner=new Owner();
			owner.setName(username);
			owner.setPassword(password);
			OwnerDatabaseDao ownerDao=new OwnerDatabaseDao();
			ownerDao.addOwner(owner);
			}
		response.sendRedirect("index/Login.jsp");
		
		
	}

}
