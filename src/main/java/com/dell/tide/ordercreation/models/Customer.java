package com.dell.tide.ordercreation.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "tide_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String currency;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

//Customer : Order
// 1  : M
// 1  : 1
// 1 : M


}
