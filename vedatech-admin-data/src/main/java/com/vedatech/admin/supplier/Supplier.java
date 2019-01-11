package com.vedatech.admin.supplier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.admin.info.Address;
import com.vedatech.admin.info.ContactInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier extends ContactInfo {

    private String company;
    private String displayName;
}

