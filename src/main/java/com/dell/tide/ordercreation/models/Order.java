package com.dell.tide.ordercreation.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tide_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String description;
    private int quantity;
    private int value;

    @ManyToOne
    @JoinColumn(name = "pnp_customer_id")
    private Customer customer;


}
