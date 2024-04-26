package com.dell.tide.ordercreation.dtos;


import com.dell.tide.ordercreation.models.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long orderId;
    private String description;
    private int quantity;
    private int value;
    private Customer customer;

}


