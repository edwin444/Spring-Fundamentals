package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.model.Customer;


//we can autoWire at three places
//at constructor, member variables, constructor,setter.

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	//member variable level injection
	//@Autowired
	private CustomerRepository customerRepository;// = new HibernateCustomerRepositoryImpl();
	
	//constructor level injection
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("Using constructor injection");
		this.customerRepository = customerRepository;
	}
    
	//method level injection
	//@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using setter injection");
    	this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
