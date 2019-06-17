package com.pluralsight.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import com.pluralsight.model.Customer;


//the below annotation declares the below class as a repository bean.
@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	@Override
	public List<Customer> findAll(){
		List<Customer> customers  = new ArrayList<>();
		Customer customer = new Customer();
		
		customer.setFirstName("Edwin");
		customer.setLastName("Thomas");
	    
		customers.add(customer);
		return customers;
	}

}
