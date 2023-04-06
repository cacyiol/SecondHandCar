package com.university.api;

import java.sql.*;

public class db_conn {
	public Connection conn = null;
	public ResultSet res = null;
	public Statement st = null;
	
 	public  db_conn() {

  		String URL="jdbc:mysql://localhost:3306/second_car?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
 		String USER="root";
 		String PWD="123456";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}try{
			conn = DriverManager.getConnection(URL,USER,PWD);
			st=conn.createStatement();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
 	public int executeInsert(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
 		}
		if(num!=0)
			System.out.println(num);
		return num;
	}
	
	public ResultSet executeQuery(String sql){
		res=null;
		try{
			res=st.executeQuery(sql);
		}
		catch(SQLException e){e.printStackTrace();
 		}
		return res;
	}
	
	public int Update(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return num;
	}
	
	public int executeDelete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
	
	public void closeDB(){
		try{
			st.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

