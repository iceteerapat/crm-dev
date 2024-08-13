package com.iceteerapat.crm;

import com.iceteerapat.crm.model.Customer;
import com.iceteerapat.crm.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,
					"ice",
					"kongrit",
					123456789L,
					null,
					null,
					null,
					null,
					"http://localhost:8080/customer/image/CustIcon.jpeg",
					null,
					"17042021",
					null));
		};
	}

}
