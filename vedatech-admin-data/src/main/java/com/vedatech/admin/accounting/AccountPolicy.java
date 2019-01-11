package com.vedatech.admin.accounting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.admin.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "account_policy")
public class AccountPolicy extends BaseEntity {

    @Column
    private String concept;

    @Column
    private Double credit;

    @Column
    private Double debit;

    @Column
    private Double balance;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="sub_account_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SubAccount subAccount;

}
