package com.university.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.BuyerDatabaseDao;
import com.university.object.Buyer;


/**
 * Servlet implementation class ListBuyerByInfo
 */
@WebServlet("/ListBuyerByInfo")
public class ListBuyerByInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBuyerByInfo() {
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
		Integer info_type = Integer.parseInt(request.getParameter("type"));
		ServletContext sc=getServletContext();
		BuyerDatabaseDao buyerlist = new BuyerDatabaseDao();
		List<Buyer> buyers=new ArrayList<Buyer>();
		
		//list buyer by id
		if(info_type==1)
		{
			Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(request.getParameter("info"));
            if (!m.matches()) {
            	response.sendRedirect("admin/nothing.jsp");
            }
            else 
            {
            	Integer id=Integer.parseInt(request.getParameter("info"));
    			Buyer buyer=buyerlist.findBuyerById(id);
    			
    			if(buyer.getId()==0)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				buyers.add(buyer);
        			sc.setAttribute("buyerlist", buyers);
    				response.sendRedirect("admin/BuyerList.jsp");
    			}
            }
		}
		//list buyer by name
		else if(info_type==2)
		{
			String name=(String)request.getParameter("info");
			
			Buyer buyer=buyerlist.findBuyerByName(name);
			
			
			if(buyer.getName()==null)
			{
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				buyers.add(buyer);
				sc.setAttribute("buyerlist", buyers);
				response.sendRedirect("admin/BuyerList.jsp");
			}
		}
	}

}
