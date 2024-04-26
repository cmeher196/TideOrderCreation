package com.dell.tide.ordercreation.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pnp_customer_id")
    @JsonBackReference
    private Customer customer;


}
