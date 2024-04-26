package com.dell.tide.ordercreation.services;

import com.dell.tide.ordercreation.dtos.CustomerDTO;
import com.dell.tide.ordercreation.models.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(CustomerDTO customerRequest);
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(Long id);
    public Customer updateCustomer(Long id, CustomerDTO customerRequest);
    public String deleteCustomer(Long id);


}
