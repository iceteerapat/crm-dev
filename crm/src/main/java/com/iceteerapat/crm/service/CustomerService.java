package com.iceteerapat.crm.service;

import com.iceteerapat.crm.model.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer create(Customer customer);
    Customer get(Long id);
    Customer update(Customer customer);
    Boolean delete(Long id);
    Collection<Customer> list(int limit);
    Customer searchById(Long id);
    Collection<Customer> searchByCustCode(String custCode);
    Customer updateProfilePicture(String custCode, String imageProfile);
}
