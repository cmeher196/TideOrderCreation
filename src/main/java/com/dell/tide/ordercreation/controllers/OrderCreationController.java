package com.dell.tide.ordercreation.controllers;


import com.dell.tide.ordercreation.dtos.OrderDTO;
import com.dell.tide.ordercreation.models.Order;
import com.dell.tide.ordercreation.services.OrderCreationService;
import com.dell.tide.ordercreation.services.OrderCreationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderCreationController {

    private final OrderCreationService orderCreationService;

    public OrderCreationController(OrderCreationServiceImpl orderCreationServiceImpl) {
        this.orderCreationService = orderCreationServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderRequest) {

        return new ResponseEntity<>(orderCreationService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/customer/{customer_id}")
    public ResponseEntity<List<Order>> getAllOrder(@PathVariable("customer_id") Long customerId) {
        return new ResponseEntity<>(orderCreationService.getAllOrdersByCustomerId(customerId), HttpStatus.OK);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("order_id") Long orderId) {
        return new ResponseEntity<>(orderCreationService.getOrderById(orderId), HttpStatus.OK);
    }

}
