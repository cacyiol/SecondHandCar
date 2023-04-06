package com.university.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.university.api.BuyerDao;
import com.university.api.db_conn;
import com.university.object.Buyer;

public class BuyerDatabaseDao implements BuyerDao {

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println(username);
		System.out.println(password);
		db_conn conn=new db_conn();
		String sql = null;
		sql="select id from users where name = '"+username+"'and password = '"+password+"' ";
		ResultSet res=conn.executeQuery(sql);
		int ifTure = 0;
		try {
			if(res.next())
			{
				ifTure = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ifTure==0)
		{
			System.out.println("登录失败");
			return false;
		}
		else {
			 return true;
		}
	}

	@Override
	public List<Buyer> listAllBuyer() {
		List<Buyer> buyerlist = new ArrayList<Buyer>();
		db_conn conn=new db_conn();
		String sql="select * from users where status=1";
		ResultSet res=conn.executeQuery(sql);
		
		try {
			while(res.next())
			{
					Integer id = res.getInt(1);
					String name = res.getString(2);
					Buyer buyer = new Buyer();
					buyer.setId(id);
					buyer.setName(name);
					buyerlist.add(buyer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyerlist;
	}

	@Override
	public boolean removeBuyer(Buyer buyer) {
		db_conn conn=new db_conn();
		
		String sql = null;
		
		sql="delete from users where status=1 and id='"+buyer.getId()+"'";
		
		if(conn.executeDelete(sql)==0)
		{
			return false;
		}
		return true;
	}

	@Override
	public Buyer editBuyer(Buyer buyer) {
		db_conn conn=new db_conn();
		String sql = null;

		
		 if(buyer.getName()!="")
		{
			sql="UPDATE users SET name='"+buyer.getName()+"' where id='"+buyer.getId()+"'";
		}
		
		if(conn.Update(sql)==0)
		{
			System.out.println("修改用户名失败");
		}
		else {
			System.out.println("修改用户名成功");
		}
		
		return null;
	}

	@Override
	public Buyer findBuyerById (int id) {
		Buyer buyer = new Buyer();
		db_conn conn=new db_conn();
		String sql="select * from users where status=1 and id='"+id+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				buyer.setId(id);
				buyer.setName(res.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buyer;
	}

	@Override
	public Buyer findBuyerByName(String name) {
		Buyer buyer = new Buyer();
		db_conn conn=new db_conn();
		String sql="select * from users where status=1 and name='"+name+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				buyer.setId(Integer.parseInt(res.getString(1)));
				buyer.setName(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buyer;
	}

	@Override
	public boolean addBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		db_conn conn=new db_conn();
		
		String sql_1="select id from users";
		ResultSet res=conn.executeQuery(sql_1);
		int id=0;
		try {
			while(res.next())
			{
				id=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id=id+1;
		String sql="insert into users values("+id+",'"+buyer.getName()+"','"+buyer.getPassword()+"',null,0);";
		conn.executeInsert(sql);
		
		return true;
	}
	

}
