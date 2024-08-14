package com.iceteerapat.crm.repository;

import com.iceteerapat.crm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAcctNo(String acctNo);
    List<Customer> findByAcctNoContainingIgnoreCase(String acctNo);
    Customer findByAcctNoAndImageProfile (String acctNo, String imageProfile);
}
