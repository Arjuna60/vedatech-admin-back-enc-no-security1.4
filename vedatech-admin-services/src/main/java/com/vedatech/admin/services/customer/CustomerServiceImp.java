package com.vedatech.admin.services.customer;


import com.vedatech.admin.customer.Customer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{

    public final CustomerDao customerDao;

    public CustomerServiceImp(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerDao.findAll();
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return null;
    }

    @Override
    public Customer save(Customer object) {
        return customerDao.save(object);
    }

    @Override
    public void delete(Customer object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void saveAll(List<Customer> object) {
            customerDao.saveAll(object);
    }
}
