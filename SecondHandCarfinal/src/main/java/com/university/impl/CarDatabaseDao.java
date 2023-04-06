package com.university.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.university.api.CarDao;
import com.university.api.db_conn;
import com.university.object.Car;
import com.university.object.Owner;


public class CarDatabaseDao implements CarDao {

	@Override
	public List<Car> listAllCar() {
		List<Car> carlist = new ArrayList<Car>();
		db_conn conn=new db_conn();
		String sql="select * from car where status=1";
		ResultSet res=conn.executeQuery(sql);
		
		try {
			while(res.next())
			{
					Integer id = res.getInt(1);
					double price = res.getDouble(2);
					String owner_name = res.getString(3);
					Owner owner = new Owner();
					owner.setName(owner_name);
					String brand = res.getString(4);
					String model = res.getString(5);
					String lpn = res.getString(6);
					Car car = new Car();
					car.setIdCar(id);
					car.setPrice(price);
					car.setBrand(brand);
					car.setOwner(owner);
					car.setModel(model);
					car.setLicensePlateNumber(lpn);
					carlist.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carlist;	
	}	

	@Override
	public List<Car> listCarByOwner(Owner owner) {
		
		List<Car> carlist = new ArrayList<Car>();
		db_conn conn=new db_conn();
		String sql="select * from car where status=1 and owner='"+owner.getName()+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {
			while(res.next())
			{
					Integer id = res.getInt(1);
					double price = res.getDouble(2);
					owner.setName(owner.getName());
					String brand = res.getString(4);
					String model = res.getString(5);
					String lpn = res.getString(6);
					
					Car car = new Car();
					car.setIdCar(id);
					car.setPrice(price);
					car.setBrand(brand);
					car.setOwner(owner);
					car.setModel(model);
					car.setLicensePlateNumber(lpn);
					carlist.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carlist;
		
	}

	@Override
	public boolean removeCar(Car car) {
		db_conn conn=new db_conn();
		
		int idCar = car.getIdCar();
		String sql = null;
		
		if(car.getIdCar()!=0)
		{
			sql="delete from car where id='"+idCar+"'";
		}
		else if(car.getOwner()!=null)
		{
			sql="delete from car where owner='"+car.getOwner().getName()+"'";
		}
		else if(car.getLicensePlateNumber()!=null)
		{
			sql="delete from car where licensePlateNumber='"+car.getLicensePlateNumber()+"'";
		}
		
		conn.executeDelete(sql);
		
		return true;
	}

	@Override
	public Car editCar(Car car) {
		db_conn conn=new db_conn();
		int idCar = car.getIdCar();
		String sql = null;
		if(car.getIdCar()!=0)
		{
			
			if(car.getBrand()!=null) {
				sql="UPDATE car SET brand='"+car.getBrand()+"' where id='"+idCar+"'";
			}
			else if(car.getModel()!=null) {
				sql="UPDATE car SET model='"+car.getModel()+"' where id='"+idCar+"'";
			}
			else if(car.getLicensePlateNumber()!=null) {
				sql="UPDATE car SET licensePlateNumber='"+car.getLicensePlateNumber()+"' where id='"+idCar+"'";
			}
		}
		if(conn.Update(sql)==0)
		{
			System.out.println("修改车辆信息失败");
		}
		else {
			System.out.println("修改车辆信息成功");
		}
		return null;
	}

	@Override
	public Car findCarById(int idCar) {
		Car car = new Car();
		db_conn conn=new db_conn();
		String sql="select * from car where status=1 and id='"+idCar+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				double price = res.getDouble(2);
				Owner owner = new Owner();
				owner.setName(res.getString(3));
				String brand = res.getString(4);
				String model = res.getString(5);
				String lpn = res.getString(6);
				
				car.setIdCar(idCar);
				car.setPrice(price);
				car.setBrand(brand);
				car.setOwner(owner);
				car.setModel(model);
				car.setLicensePlateNumber(lpn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
		
	}

	@Override
	public Car findCarByLicensePlateNumber(String carLicensePlateNumber) {
		Car car = new Car();
		db_conn conn=new db_conn();
		String sql="select * from car where status=1 and licensePlateNumber='"+carLicensePlateNumber+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {

			if(res.next())
			{
				double price = res.getDouble(2);
				Owner owner = new Owner();
				String id = res.getString(1);
				owner.setName(res.getString(3));
				String brand = res.getString(4);
				String model = res.getString(5);
				
				car.setIdCar(Integer.parseInt(id));
				car.setPrice(price);
				car.setBrand(brand);
				car.setOwner(owner);
				car.setModel(model);
				car.setLicensePlateNumber(carLicensePlateNumber);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
	
	@Override
	public String sold_num()
	{
		db_conn conn=new db_conn();
		String sql="select count(id) from car where status=0;";
		ResultSet res=conn.executeQuery(sql);
		String count=null;
		try {
			if(res.next())
			{
				count=res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Car> ListCarByModel(String model) {
		List<Car> carlist = new ArrayList<Car>();
		db_conn conn=new db_conn();
		String sql="select * from car where status=1 and model='"+model+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {
			while(res.next())
			{
					Integer id = res.getInt(1);
					double price = res.getDouble(2);
					Owner owner=new Owner();
					owner.setName(res.getString(3));
					String brand = res.getString(4);
					String lpn = res.getString(6);
					
					Car car = new Car();
					car.setIdCar(id);
					car.setPrice(price);
					car.setBrand(brand);
					car.setOwner(owner);
					car.setModel(model);
					car.setLicensePlateNumber(lpn);
					carlist.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carlist;
	}

	@Override
	public List<Car> ListCarByBrand(String brand) {
		List<Car> carlist = new ArrayList<Car>();
		db_conn conn=new db_conn();
		String sql="select * from car where status=1 and brand='"+brand+"'";
		
		ResultSet res=conn.executeQuery(sql);
		
		try {
			while(res.next())
			{
					Integer id = res.getInt(1);
					double price = res.getDouble(2);
					Owner owner=new Owner();
					owner.setName(res.getString(3));
					String model = res.getString(5);
					String lpn = res.getString(6);
					
					Car car = new Car();
					car.setIdCar(id);
					car.setPrice(price);
					car.setBrand(brand);
					car.setOwner(owner);
					car.setModel(model);
					car.setLicensePlateNumber(lpn);
					carlist.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carlist;
	}
	
	@Override
	public boolean addCar(double price,Owner owner,String brand,String model,String licensePlateNumber)
	{
		db_conn conn=new db_conn();
		String sql="select id from car";
		ResultSet res=conn.executeQuery(sql);
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
		sql="insert into car values("+id+","+price+",'"+owner.getName()+"','"+brand+"','"+model+"','"+licensePlateNumber+"',"+1+");";
		conn.executeInsert(sql);
		sql="UPDATE users SET status=0 where name='"+owner.getName()+"'";
		conn.Update(sql);
		return true;
	}

}
