package com.university.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.impl.BuyerDatabaseDao;
import com.university.impl.CarDatabaseDao;
import com.university.impl.OwnerDatabaseDao;
import com.university.object.Buyer;
import com.university.object.Car;
import com.university.object.Owner;

/**
 * Servlet implementation class ChangeUser
 */
@WebServlet("/ChangeUser")
public class ChangeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUser() {
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
		HttpSession session = request.getSession();
		int status = (int) session.getAttribute("BO");//获取当前用户身份状态
		String oldname = (String) session.getAttribute("username");
		String name = request.getParameter("newname");
		
		if(status==1) {
		
		BuyerDatabaseDao ownerlist=new BuyerDatabaseDao();
		
		Buyer buyer1=ownerlist.findBuyerByName(oldname);//通过session取到的名字去找买家
		int id=buyer1.getId();//获取到当前登录买家的ID
		Buyer buyer2=new Buyer();
		buyer2.setId(id);//赋值给buyer2
		buyer2.setName(name);//把新名字给buyer2 通过两个新旧的buyer对象达到改名字的目的
		ownerlist.editBuyer(buyer2);
		}
		
		else {
			OwnerDatabaseDao ownerlist = new OwnerDatabaseDao();
			Owner owner1=ownerlist.findOwnerByName(oldname);//通过session取到的名字去找卖家
			int id=owner1.getIdOwner();//获取到当前登录卖家的ID
			Owner owner2=new Owner();
			owner2.setIdOwner(id);//赋值给owner2
			owner2.setName(name);//把新名字给owner2 通过两个新旧的owner对象达到改名字的目的
			List<Car> carlist=new ArrayList<Car>();
			CarDatabaseDao cardao=new CarDatabaseDao();
			carlist=cardao.listCarByOwner(owner1);
			
			int i=0;
			while(i<carlist.size())
			{
				ownerlist.editOwner(owner2,carlist.get(i).getIdCar());
				i++;
			}
			
		}
		session.setAttribute("username", name);
		response.sendRedirect("index/frame.jsp");
	}

}

