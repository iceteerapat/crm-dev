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
					"Teerapat",
					"Kongrit",
					00001L,
					"477/455, Jom-Pon, Jatujak, Bangkok ",
					"10900",
					"0822195643",
					ACTIVE,
					"http://localhost:9090/customer/image/CustIcon.jpeg",
					"Iceteerapat.k@hotmail.com",
					"17042021",
					"AAA001"));
			customerRepository.save(new Customer(
					null,
					"Priyapat",
					"Kongrit",
					00002L,
					"477/455, Jom-Pon, Jatujak, Bangkok ",
					"10900",
					"0994217345",
					ACTIVE,
					"http://localhost:9090/customer/image/CustIcon.jpeg",
					null,
					"28021996",
					"AAA002"));
			customerRepository.save(new Customer(
					null,
					"Orawan",
					"Bunsin",
					00003L,
					"90 The viva condo sathorn-taksin",
					"10900",
					"0983623922",
					ACTIVE,
					"http://localhost:9090/customer/image/CustIcon.jpeg",
					null,
					"23072000",
					"AAA003"));
		};
	}

}
