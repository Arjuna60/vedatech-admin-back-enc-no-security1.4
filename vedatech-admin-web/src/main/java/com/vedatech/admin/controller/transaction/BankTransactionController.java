package com.vedatech.admin.controller.transaction;


import com.vedatech.admin.bank.BankTransaction;
import com.vedatech.admin.services.dto.transaction.BankTransactionDtoService;
import com.vedatech.admin.services.transaction.BankTransactionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/transaction")
public class BankTransactionController {

     HttpHeaders headers = new HttpHeaders();

     public final BankTransactionService bankTransactionService;
     public final BankTransactionDtoService bankTransactionDtoService;



    public BankTransactionController(BankTransactionService bankTransactionService, BankTransactionDtoService bankTransactionDtoService) {
        this.bankTransactionService = bankTransactionService;
        this.bankTransactionDtoService = bankTransactionDtoService;
    }


    @RequestMapping(value = "/getAllBankTransaction/", method = RequestMethod.GET)
    public ResponseEntity<List<BankTransaction>> getAllBankTransaction() {

        List<BankTransaction> bankTransactionList = bankTransactionService.findAll();
        if (bankTransactionList.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<BankTransaction>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BankTransaction>>(bankTransactionList, HttpStatus.OK);

    }
}
