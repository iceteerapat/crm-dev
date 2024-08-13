package com.iceteerapat.crm.repository;

import com.iceteerapat.crm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCustCode(String custCode);
    List<Customer> findByCustCodeContainingIgnoreCase(String custCode);
    Customer findByCustCodeAndImageProfile (String custCode, String imageProfile);
}
