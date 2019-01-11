package com.vedatech.admin.dto.bank;


import com.vedatech.admin.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountingTypeDto extends BaseEntity {

    private String name;
    private String account;
    private Double balance;

}
