package com.tripmaker.service;



import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;


public interface TravelService {

	public Travels addTravels(Travels travel , String key) throws TravelsException;
	public Travels updateTravel(Travels travel , String key) throws TravelsException;
	public String removeTravel(Travels travel , String key) throws TravelsException;
	public Travels searchTravels(Integer travelId, String key) throws TravelsException;
}
