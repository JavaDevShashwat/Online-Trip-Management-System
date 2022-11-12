package com.tripmaker.services;

import java.util.List;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;


public interface TravelsServices {

	public Travels addTravels(Travels travels, String Key)throws TravelsException ,LoginException;
	public Travels updateTravels(Travels travels, String Key)throws TravelsException,LoginException;
	public Travels removeTravels(Integer travelId,String Key)throws TravelsException,LoginException;
	public Travels searchTravels(Integer travelId,String Key)throws TravelsException,LoginException;
	public List<Travels> viewTravels(String Key)throws TravelsException,LoginException;
	
}