package com.cms.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
	private String city;
	private String pincode;
	private String state;
	private String country;
	

}
