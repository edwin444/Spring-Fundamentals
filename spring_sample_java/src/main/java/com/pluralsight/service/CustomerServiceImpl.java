package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.model.Customer;


//defines the below class as a bean.
@Service("customerService")
//@Scope("singleton") or 
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerServiceImpl implements CustomerService {
	
	//@Autowired  //member level
	private CustomerRepository customerRepository; //= new HibernateCustomerRepositoryImpl();
	
	//default constructor
	public CustomerServiceImpl()
	{
		
	}
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	
	@Autowired //setter level autowired so that this function also gets called.
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Setter Injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
