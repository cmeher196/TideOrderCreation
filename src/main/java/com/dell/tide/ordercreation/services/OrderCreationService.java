package com.dell.tide.ordercreation.services;


import com.dell.tide.ordercreation.dtos.OrderDTO;
import com.dell.tide.ordercreation.models.Order;

public interface OrderCreationService {

    public Order createOrder(OrderDTO orderRequest);

}
