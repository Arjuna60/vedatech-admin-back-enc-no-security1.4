package com.vedatech.admin;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@MappedSuperclass
public class BaseContact extends BaseEntity {

    //@NotBlank
    //@Email
    @Column(name = "email")
    private String email;

    //@NotBlank
    @Column(name = "phone")
    private String phone;

    @Column(name="address")
    private String address;

    // @NotNull
    @Column(name = "observation")
    private String observation;

    private double balance;

}
