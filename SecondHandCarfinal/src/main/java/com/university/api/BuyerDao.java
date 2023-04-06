package com.university.api;

import java.util.List;

import com.university.object.Buyer;

public interface BuyerDao {
	
	public boolean authenticate (String username, String password);
	
	public List<Buyer> listAllBuyer();
	
	public boolean removeBuyer (Buyer buyer);
	
	public Buyer editBuyer (Buyer buyer);
	
	public Buyer findBuyerById (int id);
	
	public Buyer findBuyerByName (String name);
	
	public boolean addBuyer(Buyer buyer);

}
