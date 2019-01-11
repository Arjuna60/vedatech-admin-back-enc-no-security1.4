package com.vedatech.admin.customer;


import com.vedatech.admin.info.Address;
import com.vedatech.admin.info.ContactInfo;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends ContactInfo {

    private String company;
    private String displayName;

}
