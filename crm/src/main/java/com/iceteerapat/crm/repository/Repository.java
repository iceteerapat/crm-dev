package com.iceteerapat.crm.repository;

import com.iceteerapat.crm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Customer, Long> {
    Customer findById(Integer id);
    Customer findByCustCode(Integer custCode);

}
