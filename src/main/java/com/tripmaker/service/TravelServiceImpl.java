package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.TravelException;
import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Travels;
import com.tripmaker.model.User;
import com.tripmaker.repository.CustomerSessionDAO;
import com.tripmaker.repository.TravelsDAO;
import com.tripmaker.repository.UserDao;

@Service
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;
	
	@Autowired
	private TravelsDAO travelDAO;
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public Travels addTravels(Travels travel, String key) throws TravelException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			Optional<User> loggedInUser = userDao.findById(currUser1.getId());
			
			
			travel.getUsers().add(loggedInUser.get());
			
			Travels addedtravel = travelDAO.save(travel);
			return addedtravel;
		}
		else {
			throw new LoginException("Please login to your account");
		}
		
	}

	@Override
	public Travels updateTravel(Travels travel, String key) throws TravelException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			Optional<User> loggedInUser = userDao.findById(currUser1.getId());
			
			travel.getUsers().add(loggedInUser.get());
			Travels addedtravel = travelDAO.save(travel);
			return addedtravel;
			
		}
		else {
			throw new LoginException("Please login to your account");
		}
	}

	@Override
	public String removeTravel(Travels travel, String key) throws TravelException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			Optional<User> loggedInUser = userDao.findById(currUser1.getId());
			
			
			travel.getUsers().add(loggedInUser.get());
			
			travelDAO.delete(travel);
			return "Travel is remove successfully";
		}
		else {
			throw new LoginException("Please login to your account");
		}
	}

	@Override
	public Travels searchTravels(Integer travelId, String key) throws TravelException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			
			
			Optional<Travels> travels = travelDAO.findById(travelId);
			
			return travels.get();
		}
		throw new LoginException("Please login to your account");
	}

}
