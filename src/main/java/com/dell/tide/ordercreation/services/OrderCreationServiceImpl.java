package com.dell.tide.ordercreation.services;


import com.dell.tide.ordercreation.dtos.OrderDTO;
import com.dell.tide.ordercreation.models.Customer;
import com.dell.tide.ordercreation.models.Order;
import com.dell.tide.ordercreation.repos.CustomerRespository;
import com.dell.tide.ordercreation.repos.OrderCreationRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCreationServiceImpl implements OrderCreationService{

    private final OrderCreationRespository orderCreationRespository;
    private final CustomerRespository customerRespository;

    public OrderCreationServiceImpl(OrderCreationRespository orderCreationRespository,
                                    CustomerRespository customerRespository)
    {
        this.orderCreationRespository = orderCreationRespository;
        this.customerRespository = customerRespository;
    }


    @Override
    public Order createOrder(OrderDTO orderRequest) {

        Customer customer = customerRespository.findById(orderRequest.getCustomerId()).orElse(null);

        if(customer.getId() != null){
            Order order = new Order();
            order.setDescription(orderRequest.getDescription());
            order.setValue(orderRequest.getValue());
            order.setQuantity(orderRequest.getQuantity());
            customer.getOrders().add(order);
            order.setCustomer(customer);

            return orderCreationRespository.save(order);
        }
        return null;

    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderCreationRespository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getAllOrdersByCustomerId(Long customerId) {
        Customer customer = customerRespository.getById(customerId);
        if(customer.getId() != null){
            return customer.getOrders();
        }
        return new ArrayList<>();
    }
}
