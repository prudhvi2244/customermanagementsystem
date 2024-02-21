package com.cms.in.service;

import java.util.List;
import java.util.Optional;

import com.cms.in.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Optional<Customer> getCustomerById(Integer cid);
	void deleteCustomer(Integer cid);
	Customer updateCustomer(Integer cid,Customer customer);
}
