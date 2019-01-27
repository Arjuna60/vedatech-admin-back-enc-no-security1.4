package com.vedatech.admin.customer;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.admin.accounting.SubAccount;
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
    private Boolean status;
    private Double balance;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="sub_account_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    SubAccount subAccount;


}
