package com.vedatech.admin.controller.customer;

import com.vedatech.admin.customer.Customer;
import com.vedatech.admin.services.customer.CustomerService;
import com.vedatech.admin.supplier.Supplier;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

        private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer) {
        System.out.println("Creating User ");
        HttpHeaders headers = new HttpHeaders();

        try {
            customerService.save(customer);
            headers.set("accepted ok","bank account is ok");
            return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);
        }catch (JDBCConnectionException e){

            headers.set("error","Error al grabar datos en el servidor intente de nuevo");

            return new ResponseEntity<Customer>(headers, HttpStatus.CREATED);

        }

    }


    //-------------------Retrieve All Accounts Type--------------------------------------------------------

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllSubAcc() {
        HttpHeaders headers = new HttpHeaders();
        List<com.vedatech.admin.customer.Customer> customers =  customerService.findAll();

        if (customers.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<Customer>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
}
