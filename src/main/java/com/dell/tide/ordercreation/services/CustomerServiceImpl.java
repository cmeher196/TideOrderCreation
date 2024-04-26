package com.dell.tide.ordercreation.services;

import com.dell.tide.ordercreation.dtos.CustomerDTO;
import com.dell.tide.ordercreation.models.Customer;
import com.dell.tide.ordercreation.repos.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRespository customerRespository;


    @Autowired
    public CustomerServiceImpl(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public Customer createCustomer(CustomerDTO customerRequest) {

        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        customer.setCurrency(customerRequest.getCurrency());

        return customerRespository.save(customer);

    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRespository.findAll();

    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerRespository.findById(id).orElse(null);

    }

    @Override
    public Customer updateCustomer(Long id, CustomerDTO customerRequest) {

        Customer customer = customerRespository.findById(id).orElse(null);

        if(customer != null){
            customer.setName(customerRequest.getName());
            customer.setEmail(customerRequest.getEmail());
            customer.setAddress(customerRequest.getAddress());
            customer.setCurrency(customerRequest.getCurrency());

            return customerRespository.save(customer);
        }

        return null;
    }

    @Override
    public String deleteCustomer(Long id) {

            customerRespository.deleteById(id);
            return "Customer Deleted Successfully with id: "+id;

    }
}
