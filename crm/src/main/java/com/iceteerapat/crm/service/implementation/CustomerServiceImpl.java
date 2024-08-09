package com.iceteerapat.crm.service.implementation;

import com.iceteerapat.crm.enumuration.CustStatus;
import com.iceteerapat.crm.model.Customer;
import com.iceteerapat.crm.repository.Repository;
import com.iceteerapat.crm.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.Collection;

import static com.iceteerapat.crm.enumuration.CustStatus.ACTIVE;
import static com.iceteerapat.crm.enumuration.CustStatus.INACTIVE;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final Repository repository;

    @Override
    public Customer create(Customer customer) {
        log.info("Create New Customer: {}", customer.getName());
        customer.setImageCust(imageCustomer());
        return repository.save(customer);
    }

    @Override
    public Customer get(Long uniqueId) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public Boolean delete(Long uniqueId) {
        return null;
    }

    @Override
    public Collection<Customer> list(int limit) {
        return null;
    }

    @Override
    public Customer search(Integer id) {
        return null;
    }

    private String imageCustomer(){
        return null;
    }
}
