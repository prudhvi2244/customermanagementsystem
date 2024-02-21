package com.cms.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.in.entity.Customer;
import com.cms.in.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Integer cid) {
		return customerRepository.findById(cid);
	}

	@Override
	public void deleteCustomer(Integer cid) {
		customerRepository.deleteById(cid);
	}

	@Override
	public Customer updateCustomer(Integer cid, Customer customer) {
		Optional<Customer> opt = getCustomerById(cid);
		if (opt.isEmpty()) {
			System.out.println("Customer with ID:" + cid + " not available");
		}

		return customerRepository.save(customer);

	}

}
