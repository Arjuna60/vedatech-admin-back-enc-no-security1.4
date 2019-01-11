package com.vedatech.admin.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class ContactInfo extends Address {



    private String title;
    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String website;




}
