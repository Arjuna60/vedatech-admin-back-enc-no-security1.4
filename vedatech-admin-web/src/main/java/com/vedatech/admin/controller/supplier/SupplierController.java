package com.vedatech.admin.controller.supplier;


import com.vedatech.admin.accounting.AccountingType;
import com.vedatech.admin.accounting.SubAccount;
import com.vedatech.admin.bank.Bank;
import com.vedatech.admin.services.supplier.SupplierService;
import com.vedatech.admin.supplier.Supplier;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {

    public final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/addSupplier/", method = RequestMethod.POST)
    public ResponseEntity<Supplier> createUser(@RequestBody Supplier supplier) {
        System.out.println("Creating User ");
        HttpHeaders headers = new HttpHeaders();

         try {
            supplierService.save(supplier);
             headers.set("accepted ok","bank account is ok");
             return new ResponseEntity<Supplier>(supplier, headers, HttpStatus.CREATED);
        }catch (JDBCConnectionException e){

            headers.set("error","Error al grabar datos en el servidor intente de nuevo");

            return new ResponseEntity<Supplier>(headers, HttpStatus.CREATED);

        }

    }



    //-------------------Retrieve All Accounts Type--------------------------------------------------------

    @RequestMapping(value = "/getAllSuppliers", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> getAllSubAcc() {
        HttpHeaders headers = new HttpHeaders();
        List<Supplier> suppliers = (List<Supplier>) supplierService.findAll();

        if (suppliers.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<Supplier>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
    }
}
