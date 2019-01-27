package com.vedatech.admin.dto.bank;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
public class CustomerDto {

    private String title;
    private String firstName;
    private String lastName;
    private String company;
    private String displayName;
    private String phone;
    private String email;
    private String mobile;
    private String website;
    private String street;
    private String city;
    private String state;
    private String code;
    private String country;
    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingCode;
    private String shippingCountry;
    private Double balance;
    private Boolean status;

}
