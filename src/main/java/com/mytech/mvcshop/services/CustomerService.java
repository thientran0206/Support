package com.mytech.mvcshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.mvcshop.entities.Customer;
import com.mytech.mvcshop.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getCustomers() {

		List<Customer> customers = customerRepository.findAll();
		return customers;
	}
	
	public List<Customer> search(String searchText) {
		return customerRepository.search(searchText);
	}

	public Customer save(Customer customer) {

		return customerRepository.save(customer);
	}

	public Customer update(Customer customer) {

		Customer updateCustomer = customerRepository.findById(customer.getId()).get();
		
		updateCustomer.setFirstName(customer.getFirstName());
		updateCustomer.setLastName(customer.getLastName());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setAddress(customer.getAddress());
		
		return customerRepository.save(updateCustomer);
	}

	public Customer getById(long id) {

		return customerRepository.findById(id).get();
	}

	public void deleteById(long id) {

		customerRepository.deleteById(id);
	}
}
