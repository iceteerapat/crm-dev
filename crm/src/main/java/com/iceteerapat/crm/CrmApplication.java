package com.iceteerapat.crm;

import com.iceteerapat.crm.enumuration.CustStatus;
import com.iceteerapat.crm.model.Customer;
import com.iceteerapat.crm.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

import static com.iceteerapat.crm.enumuration.CustStatus.*;

@SpringBootApplication
public class CrmApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication app =new SpringApplication(CrmApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port","9090"));
		app.run(args);
	}

	@Bean
	CommandLineRunner run(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(
					null,
					"ice",
					"kongrit",
					123456789L,
					null,
					null,
					null,
					ACTIVE,
					"http://localhost:9090/customer/image/CustIcon.jpeg",
					null,
					"17042021",
					"AAA001"));
		};
	}

}
