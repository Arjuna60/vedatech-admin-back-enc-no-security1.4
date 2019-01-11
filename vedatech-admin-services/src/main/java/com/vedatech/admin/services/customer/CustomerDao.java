package com.vedatech.admin.services.customer;

import com.vedatech.admin.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Long> {
}
