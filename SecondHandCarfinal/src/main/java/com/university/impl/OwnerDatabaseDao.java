package com.university.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.university.api.OwnerDao;
import com.university.api.db_conn;
import com.university.object.Owner;

public class OwnerDatabaseDao implements OwnerDao {

	@Override
	public List<Owner> listAllOwner() {
		List<Owner> ownerlist = new ArrayList<Owner>();
		db_conn conn=new db_conn();
		String sql="select * from users where status=0";
		ResultSet res=conn.executeQuery(sql);
		
		try {
			while(res.next())
			{
					Integer id = res.getInt(1);
					String name = res.getString(2);
					String dln = res.getString(4);
					Owner owner = new Owner();
					owner.setIdOwner(id);
					owner.setName(name);
					owner.setDrivingLicenseNumber(dln);
					ownerlist.add(owner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ownerlist;	
	}

	@Override
	public boolean removeOwner(Owner owner) {
		db_conn conn=new db_conn();
		
		String sql = null;
		sql="delete from users where status=0 and id='"+owner.getIdOwner()+"'";
		
		if(conn.executeDelete(sql)==0)
		{
			return false;
		}
		return true;
	}

	@Override
	public Owner editOwner(Owner owner,int i) {
		db_conn conn=new db_conn();
		String sql = null;
		String sql_1 = null;
		
		 if(owner.getName()!="")
		{
			sql="UPDATE users SET name='"+owner.getName()+"' where id='"+owner.getIdOwner()+"'";
			sql_1="UPDATE car SET owner='"+owner.getName()+"' where id='"+i+"'";
		}
		
		if(conn.Update(sql)==0 || conn.Update(sql_1)==0)
		{
			System.out.println("修改用户名失败");
		}
		else {
			System.out.println("修改用户名成功");
		}
		
		return null;

	}

	@Override
	public Owner findOwnerById(int idOwner) {
		Owner owner = new Owner();
		db_conn conn=new db_conn();
		String sql="select * from users where status=0 and id='"+idOwner+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				owner.setIdOwner(idOwner);
				owner.setName(res.getString(2));
				owner.setDrivingLicenseNumber(res.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return owner;
	}

	@Override
	public Owner findOwnerByName(String name) {
		Owner owner = new Owner();
		db_conn conn=new db_conn();
		String sql="select * from users where status=0 and name='"+name+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				owner.setIdOwner(Integer.parseInt(res.getString(1)));
				owner.setName(name);
				owner.setDrivingLicenseNumber(res.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return owner;
	}

	@Override
	public Owner findOwnerBydrivingLicenseNumber(String drivingLicenseNumber) {
		Owner owner = new Owner();
		db_conn conn=new db_conn();
		String sql="select * from users where status=0 and drivingLicenseNumber='"+drivingLicenseNumber+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				owner.setIdOwner(Integer.parseInt(res.getString(1)));
				owner.setName(res.getString(2));
				owner.setDrivingLicenseNumber(drivingLicenseNumber);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return owner;
	}
	

	@Override
	public boolean addOwner(Owner owner) {
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
		String sql="insert into users values("+id+",'"+owner.getName()+"','"+owner.getPassword()+"',null,1);";
		conn.executeInsert(sql);
		System.out.println(sql);
		return true;
	}

}
