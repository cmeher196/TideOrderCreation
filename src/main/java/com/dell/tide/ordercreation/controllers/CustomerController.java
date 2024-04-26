package com.dell.tide.ordercreation.controllers;


import com.dell.tide.ordercreation.dtos.CustomerDTO;
import com.dell.tide.ordercreation.models.Customer;
import com.dell.tide.ordercreation.models.Order;
import com.dell.tide.ordercreation.services.CustomerService;
import com.dell.tide.ordercreation.services.CustomerServiceImpl;
import com.dell.tide.ordercreation.services.OrderCreationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }


    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("Order Creation Service is up and running", HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerRequest) {
        log.info("Request received to create Customer");
        return new ResponseEntity<>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        log.info("Request received to get all Customers");
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        log.info("Request received to get Customer by id");
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerRequest) {
        log.info("Request received to update Customer");
        return new ResponseEntity<>(customerService.updateCustomer(id, customerRequest), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        log.info("Request received to delete Customer");
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

}
