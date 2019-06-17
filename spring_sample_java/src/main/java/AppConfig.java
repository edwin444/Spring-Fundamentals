import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;

//to replace the xml file with application config within the java
//@Configuration will tell spring to go and look for any bean in 
//this configuration class.

@Configuration
@ComponentScan({"com.pluralsight"})  //for auto-wiring.
@PropertySource("app.properties")
public class AppConfig {
	
	//this bean returns a CustomerServiceImpl.
	//as the customerServiceImpl object needs HibernateCustomerRepository
	//object, we create a bean for that first. 
	//And then we do setter injection to inject that to the 
	//customerServiceImpl Class.
//	@Bean(name="customerService")
//	public CustomerService getCustomerService() {
//		CustomerServiceImpl service =  new CustomerServiceImpl();
//		service.setCustomerRepository(getCustomerRepository());
//		return service;
//	}
//	
	//below in the constructor injection.
//	@Bean(name="customerService")
//	public CustomerService getCustomerService() {
//		CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository());
//		return service;
//	}
	
	//next we define an autowired setup so that
	//customerRepository bean is automatically inserted into the customerService
	//bean.
	// in the AppConfig file.
	
	//commented the below when using steriotypes.
//	@Bean(name="customerService")
//	public CustomerService getCustomerService() {
//		CustomerServiceImpl service = new CustomerServiceImpl();
//		return service;
//	}
//	
//	@Bean(name="customerRepository")
//	public CustomerRepository getCustomerRepository() {
//		return new HibernateCustomerRepositoryImpl();
//	}
//	
	
	
	//to get info from some other file
	//instead of hardcoding everything
	@Bean //this is a bean which spring
	//defines which gets the properties 
	//from other files and helps in injection
	//into whatever files we want.
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
