package com.vedatech.admin.controller;


import com.vedatech.admin.customer.Customer;
import com.vedatech.admin.services.accounting.sub.SubAccountService;
import com.vedatech.admin.services.accounting.type.AccountingTypeService;
import com.vedatech.admin.services.customer.CustomerService;
import com.vedatech.admin.services.supplier.SupplierService;
import com.vedatech.admin.supplier.Supplier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class VedatechBootstrap implements CommandLineRunner {

    private final AccountingTypeService accountingTypeService;
    private final SubAccountService subAccountService;
    private final CustomerService customerService;
    private final SupplierService supplierService;

    public VedatechBootstrap(AccountingTypeService accountingTypeService, SubAccountService subAccountService, CustomerService customerService, SupplierService supplierService) {
        this.accountingTypeService = accountingTypeService;
        this.subAccountService = subAccountService;
        this.customerService = customerService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {





    }
}
