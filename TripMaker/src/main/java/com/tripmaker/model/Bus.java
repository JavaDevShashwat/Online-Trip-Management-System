package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer busId;
	@NotNull
	private String busType;
	@NotNull
	private String busNumber;
	@NotNull
	private Integer capacity; 
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	List<Travels> travels=new ArrayList<>();
//	
//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "buses")
//	List<Route> routes=new ArrayList<>();
	
}
