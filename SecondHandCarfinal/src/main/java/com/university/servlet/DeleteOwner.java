package com.university.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.impl.OwnerDatabaseDao;
import com.university.object.Owner;

/**
 * Servlet implementation class DeleteOwner
 */
@WebServlet("/DeleteOwner")
public class DeleteOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOwner() {
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
		OwnerDatabaseDao ownerlist=new OwnerDatabaseDao();
		Owner owner=new Owner();
		if(request.getParameter("delete_info")=="")
		{
			response.sendRedirect("admin/nothing.jsp");
		}
		//2- choose id to search and delete the owner
		else if(info_type==1)
		{
			Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(request.getParameter("delete_info"));
            if (!m.matches()) {
            	response.sendRedirect("admin/nothing.jsp");
            }
            else 
            {
            	Integer id=Integer.parseInt(request.getParameter("delete_info"));
    			owner=ownerlist.findOwnerById(id);
    			
    			if(owner.getIdOwner()==0)
    			{
                	response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				ownerlist.removeOwner(owner);
    				response.sendRedirect("admin/success.jsp");
    			}
            }
		}
		//3-choose name to search and delete the owner
		else if(info_type==2)
		{
			String name = request.getParameter("delete_info");
			owner=ownerlist.findOwnerByName(name);
			
			if(owner.getIdOwner()==0)
			{
            	response.sendRedirect("admin/nothing.jsp");
			}
			else {
				ownerlist.removeOwner(owner);
				response.sendRedirect("admin/success.jsp");
			}
		}
		//4-choose driveLicenseNumber to search and delete the owner
		else if(info_type==3)
		{
			String dln=request.getParameter("delete_info");
			owner=ownerlist.findOwnerBydrivingLicenseNumber(dln);
			
			if(owner.getIdOwner()==0)
			{
            	response.sendRedirect("admin/nothing.jsp");
			}
			else {
				ownerlist.removeOwner(owner);
				response.sendRedirect("admin/success.jsp");
			}
		}

	}

}
