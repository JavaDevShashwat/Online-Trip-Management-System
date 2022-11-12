package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.TravelException;
import com.tripmaker.model.Travels;
import com.tripmaker.model.User;

public interface TravelService {

	public Travels addTravels(Travels travel , String key) throws TravelException;
	public Travels updateTravel(Travels travel , String key) throws TravelException;
	public String removeTravel(Travels travel , String key) throws TravelException;
	public Travels searchTravels(Integer travelId, String key) throws TravelException;
}
