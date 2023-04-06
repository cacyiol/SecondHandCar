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

import com.university.impl.	OwnerDatabaseDao;
import com.university.object.Owner;

/**
 * Servlet implementation class ListOwnerByInfo
 */
@WebServlet("/ListOwnerByInfo")
public class ListOwnerByInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOwnerByInfo() {
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
		OwnerDatabaseDao ownerlist = new OwnerDatabaseDao();
		List<Owner> owners=new ArrayList<Owner>() ;
		
		//list owner by id
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
    			Owner owner=ownerlist.findOwnerById(id);
    			owners.add(owner);
    			sc.setAttribute("ownerlist", owners);
    			
    			if(owner.getIdOwner()==0)
    			{
    				response.sendRedirect("admin/nothing.jsp");
    			}
    			else {
    				response.sendRedirect("admin/OwnerList.jsp");
    			}
            }
		}
		//list owner by name
		else if(info_type==2)
		{
			String name=(String)request.getParameter("info");
			Owner owner=ownerlist.findOwnerByName(name);
			owners.add(owner);
			sc.setAttribute("ownerlist", owners);
			
			if(owner.getIdOwner()==0)
			{
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				response.sendRedirect("admin/OwnerList.jsp");
			}
		}
		//list owner by driveLisenceNumber
		else if(info_type==3)
		{
			String dln=(String)request.getParameter("info");
			
			Owner owner=ownerlist.findOwnerBydrivingLicenseNumber(dln);
			owners.add(owner);
			sc.setAttribute("ownerlist", owners);
			
			if(owner.getIdOwner()==0)
			{
				response.sendRedirect("admin/nothing.jsp");
			}
			else {
				response.sendRedirect("admin/OwnerList.jsp");
			}
		}
		
	}

}
