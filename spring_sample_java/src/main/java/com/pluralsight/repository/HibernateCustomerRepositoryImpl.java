package com.pluralsight.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import com.pluralsight.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${dbUsername}")
	private String dbUsername;
	
	@Override
	public List<Customer> findAll(){
		
		System.out.println(dbUsername);
		List<Customer> customers  = new ArrayList<>();
		Customer customer = new Customer();
		
		customer.setFirstName("Edwin");
		customer.setLastName("Thomas");
	    
		customers.add(customer);
		return customers;
	}

}
