package com.iceteerapat.crm.service;

import com.iceteerapat.crm.model.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer create(Customer customer);
    Customer get(Long uniqueId);
    Customer update(Customer customer);
    Boolean delete(Long uniqueId);
    Collection<Customer> list(int limit);
    Customer search(Integer id);
}
