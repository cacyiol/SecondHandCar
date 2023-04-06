package com.university.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
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
 * Servlet implementation class UserChange
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int status = (int) session.getAttribute("BO");
		if(status==1) {
		BuyerDatabaseDao buyerlist = new BuyerDatabaseDao();
		Buyer buyer=buyerlist.findBuyerByName(username);
		
		ServletContext sc=getServletContext();
		sc.setAttribute("buyer", buyer);}
		
		else {
			OwnerDatabaseDao ownerlist = new OwnerDatabaseDao();
			Owner owner=ownerlist.findOwnerByName(username);
			ServletContext sc=getServletContext();
			sc.setAttribute("owner", owner);
		}
		
		response.sendRedirect("index/UserList.jsp");
		
	}

}
