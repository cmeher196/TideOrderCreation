package com.dell.tide.ordercreation.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String email;
    private String address;
    private String currency;

}
