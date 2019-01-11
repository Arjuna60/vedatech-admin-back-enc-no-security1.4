package com.vedatech.admin.services.readfile.customer;

import com.vedatech.admin.customer.Customer;
import com.vedatech.admin.dto.bank.CustomerDto;
import com.vedatech.admin.supplier.Supplier;

import java.io.IOException;
import java.util.List;

public interface BeanReaderCustomerService {

    List<CustomerDto> readWithCsvBeanReaderCustomer(CustomerDto object, String file) throws IOException;

}
