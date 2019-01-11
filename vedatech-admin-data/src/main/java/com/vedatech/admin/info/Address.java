package com.vedatech.admin.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
//@Entity
//@Table(name = "address")
public class Address extends ShippingAddress {

    private String street;

    private String number;

    private String city;

    private String state;

    private String code;

    private String country;



}
