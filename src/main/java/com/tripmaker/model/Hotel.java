package com.tripmaker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer hotelId;
	private String hotelName;
	private String hotelType;
	private String description;
	private String address;
	private double rent;
	private String status;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Package> packages;
}
