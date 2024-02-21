package com.cms.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.in.entity.Customer;
import com.cms.in.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {

		this.customerService = customerService;
	}

	/*
	 * URL : http://localhost:9999/customer/saveCustomer Sample Input : { "cid":1,
	 * "name":"Prudhvi", "city":"Goa", "gender":"MALE", "email":"prudhvi@gmail.com"
	 * }
	 */

	/*
	 * Customer customer=new Customer(); customer.setCid(1);
	 * customer.setName("Prudhvi"); customer.setCity("Goa");
	 * customer.setGender("MALE"); customer.setEmail("prudhvi@gmail.com");
	 * 
	 */
	@PostMapping(value = "/saveCustomer")
	public ResponseEntity<Customer> saveCustomerDetails(@RequestBody Customer customer) {

		Customer savedCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);

	}

	@GetMapping(value = "/allCustomers")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> allCustomers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
	}
	
	/*
	 * http://localhost:9999/customer/2
	 */
	@GetMapping(value = "/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer cid){
		Optional<Customer> opt=customerService.getCustomerById(cid);
		return new ResponseEntity<Customer>(opt.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{cid}")
	public String deleteCustomer(@PathVariable Integer cid) {
		customerService.deleteCustomer(cid);
		return "Customer With ID :"+cid+" Deleted !";
	}
	
	
	@PutMapping(value = "/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer cid,@RequestBody Customer customer){
		Customer existingCustomer=customerService.getCustomerById(cid).get();
		existingCustomer.setCity(customer.getCity());
		Customer updatedCustomer=customerService.updateCustomer(cid, existingCustomer);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	

}
