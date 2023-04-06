package com.university.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.BuyerDatabaseDao;
import com.university.object.Buyer;


/**
 * Servlet implementation class DeleteBuyer
 */
@WebServlet("/DeleteBuyer")
public class DeleteBuyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBuyer() {
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
		Integer info_type = Integer.parseInt(request.getParameter("delete_type"));
		BuyerDatabaseDao buyerlist=new BuyerDatabaseDao();
		Buyer buyer=new Buyer();
		
		//2-if you don't input the information which is used to search the buyer
		if(request.getParameter("delete_info")=="") {
			response.sendRedirect("admin/nothing.jsp");
		}
		//3-if you choose id to search and delete the buyer
		else if(info_type==1)
		{
			// Check whether the entered information conforms to the id format
			Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(request.getParameter("delete_info"));
            if (!m.matches()) {
            	// not conform to the id format 
            	response.sendRedirect("admin/nothing.jsp");
            }
            else 
            {
            	//conform to the id format and find the buyer by id
            	Integer id=Integer.parseInt(request.getParameter("delete_info"));
    			buyer=buyerlist.findBuyerById(id);
    			
    			//the id isn't exist
    			if(buyer.getId()==0)
    			{
                	response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				//remove the buyer by id
    				buyerlist.removeBuyer(buyer);
    				response.sendRedirect("admin/success.jsp");
    			}
            }
            
		}
		// choose name to delete the buyer
		else if(info_type==2)
		{
			//find the buer by name
			String name = request.getParameter("delete_info");
			buyer=buyerlist.findBuyerByName(name);
			
			//the name isn't exist
			if(buyer.getId()==0)
			{
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				//remove the buyer by name
				buyerlist.removeBuyer(buyer);
				response.sendRedirect("admin/success.jsp");
			}
			
		}
		
	}

}
