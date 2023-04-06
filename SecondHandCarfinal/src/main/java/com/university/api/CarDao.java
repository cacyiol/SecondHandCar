package com.university.api;

import java.util.List;

import com.university.object.Car;
import com.university.object.Owner;

public interface CarDao {
	
	public List<Car> listAllCar();
	
	public List<Car> listCarByOwner (Owner owner);
	
	public boolean removeCar (Car car);
	
	public Car editCar (Car car);
	
	public Car findCarById (int idCar);
	
	public Car findCarByLicensePlateNumber (String carLicensePlateNumber);

	public String sold_num();
	
	public List<Car> ListCarByModel(String model);
	
	public List<Car> ListCarByBrand(String brand);
	
	public boolean addCar(double price,Owner owner,String brand,String model,String licensePlateNumber);

}
