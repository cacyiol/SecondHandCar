package com.university.api;

import java.util.List;

import com.university.object.Owner;

public interface OwnerDao {
	
	public List<Owner> listAllOwner();
	
	public boolean removeOwner (Owner owner);
	
	public Owner editOwner (Owner owner,int i);
	
	public Owner findOwnerById (int idOwner);
	
	public Owner findOwnerByName (String name);
	
	public Owner findOwnerBydrivingLicenseNumber (String drivingLicenseNumber);

	public boolean addOwner(Owner owner);
	
}
