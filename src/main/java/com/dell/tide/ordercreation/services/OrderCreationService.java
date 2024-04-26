package com.dell.tide.ordercreation.services;


import com.dell.tide.ordercreation.dtos.OrderDTO;
import com.dell.tide.ordercreation.models.Order;

import java.util.List;

public interface OrderCreationService {

    public Order createOrder(OrderDTO orderRequest);

    public Order getOrderById(Long orderId);

    public List<Order> getAllOrdersByCustomerId(Long customerId);


}
