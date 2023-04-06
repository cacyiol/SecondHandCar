package com.university.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.BuyerDatabaseDao;
import com.university.object.Buyer;

/**
 * Servlet implementation class BuyerList
 */
@WebServlet("/BuyerList")
public class BuyerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerList() {
        super();
        // TODO Auto-generated constructor stub
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
		//1-get the car list
		BuyerDatabaseDao carlist =  new BuyerDatabaseDao();
		List<Buyer> resu = carlist.listAllBuyer();
		
		//2-set the attribute
		ServletContext sc = getServletContext();
		sc.setAttribute("buyerlist", resu);
		
		//3-turn to the next page
		response.sendRedirect("admin/BuyerList.jsp");
	}

}
