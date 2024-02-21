package com.cms.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.in.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	
}
