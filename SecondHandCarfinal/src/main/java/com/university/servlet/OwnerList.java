package com.university.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.OwnerDatabaseDao;
import com.university.object.Owner;

/**
 * Servlet implementation class OwnerList
 */
@WebServlet("/OwnerList")
public class OwnerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerList() {
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
		
		OwnerDatabaseDao carlist =  new OwnerDatabaseDao();
		List<Owner> resu = carlist.listAllOwner();
		
		ServletContext sc = getServletContext();

		sc.setAttribute("ownerlist", resu);

		response.sendRedirect("admin/OwnerList.jsp");
		
	}

}
