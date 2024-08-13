package com.iceteerapat.crm.service.implementation;

import com.iceteerapat.crm.model.Customer;
import com.iceteerapat.crm.repository.CustomerRepository;
import com.iceteerapat.crm.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository custRepo;

    @Override
    public Customer create(Customer customer) {
        log.info("Create New Customer: {}", customer.getName());
        customer.setImageProfile(defaultImage());
        return custRepo.save(customer);
    }

    @Override
    public Customer get(Long id) {
        log.info("Fetching all customer by id: {}", id);
        return custRepo.findById(id).get();
    }

    @Override
    public Customer update(Customer customer) {
        log.info("Updating the customer: {}", customer.getName());
        return custRepo.save(customer);
    }
    @Override
    public Boolean delete(Long id) {
        log.info("Deleting the customer: {}", id);
        custRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Collection<Customer> list(int limit) {
        log.info("Fetching all customers:");
        return custRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Customer searchById(Long id) {
        log.info("Searching customer by id: {}", id);
        return custRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Customer> searchByCustCode(String custCode) {
        log.info("Searching customer by code containing: {}", custCode);
        return custRepo.findByCustCodeContainingIgnoreCase(custCode);
    }

    @Override
    public Customer updateProfilePicture(String custCode, String imageProfile) {
        log.info("Updating the profile picture of the customer: {}", custCode);
        Customer customer = custRepo.findByCustCodeAndImageProfile(custCode, imageProfile);
        customer.setImageProfile(imageProfile);
        return custRepo.save(customer);
    }

    private String defaultImage(){
        String[] icon = {"CustIcon.jpeg"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer/image/" + icon).toUriString();
    }
}
