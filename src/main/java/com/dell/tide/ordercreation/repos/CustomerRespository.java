package com.dell.tide.ordercreation.repos;

import com.dell.tide.ordercreation.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, Long> {
}
