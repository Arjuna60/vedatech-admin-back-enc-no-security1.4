package com.vedatech.admin.controller.bank;

import com.vedatech.admin.accounting.SubAccount;
import com.vedatech.admin.bank.Bank;
import com.vedatech.admin.bank.BankTransaction;
import com.vedatech.admin.services.accounting.sub.SubAccountService;
import com.vedatech.admin.services.bank.BankDao;
import com.vedatech.admin.services.bank.BankService;
import com.vedatech.admin.services.transaction.BankTransactionService;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    public  final SubAccountService subAccountService;
    public final BankService bankService;
    public final BankDao bankDao;
    public final BankTransactionService bankTransactionService;

    public BankController(SubAccountService subAccountService, BankService bankService, BankDao bankDao, BankTransactionService bankTransactionService) {
        this.subAccountService = subAccountService;
        this.bankService = bankService;
        this.bankDao = bankDao;
        this.bankTransactionService = bankTransactionService;
    }


    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/addBankAccount/", method = RequestMethod.POST)
    public ResponseEntity<Bank> createUser(@RequestBody Bank bank, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User ");


        if (bankDao.findBankByAccountNumber(bank.getAccountNumber()) != null) {
            System.out.println("A User with name " + bank.getNameBank() + " " + bank.getAccountNumber() + " already exist");
            HttpHeaders headers = new HttpHeaders();
            headers.set("error ", "bank account already exist");
            return new ResponseEntity<Bank>(headers, HttpStatus.CONFLICT);
        }


        try {
            SubAccount subAccount = subAccountService.findById(bank.getSubAccount().getId()).get();
            subAccount.setBalance(bank.getBalance());
            subAccountService.save(subAccount);
            bank.setSubAccount(subAccount);
            bankService.save(bank);
        }catch (JDBCConnectionException e){

            HttpHeaders headers = new HttpHeaders();
            headers.set("error","Error al grabar datos en el servidor intente de nuevo");

            return new ResponseEntity<Bank>(headers, HttpStatus.CREATED);

        }

        Bank newBank = bankDao.findBankByAccountNumber(bank.getAccountNumber());

        HttpHeaders headers = new HttpHeaders();
        headers.set("accepted ok","bank account is ok");

        return new ResponseEntity<Bank>(newBank,headers, HttpStatus.CREATED);
    }


    //------------------- Update a Bank Account --------------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Bank> updateUser(@RequestBody Bank bank) {

        try {
            //   Bank currentBankAcc = bankService.findBankById(id);
            SubAccount subAccount = subAccountService.findById(bank.getSubAccount().getId()).get();
            subAccount.setBalance(bank.getBalance());
            subAccountService.save(subAccount);
            bank.setSubAccount(subAccount);
            bankService.save(bank);
            HttpHeaders headers = new HttpHeaders();
            headers.set("success", "the account is update success");
            return new ResponseEntity<Bank>(bank,headers, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            System.out.println("User with id " + " not found");
            HttpHeaders headers = new HttpHeaders();
            headers.set("error", "la cuenta no existe");
            return new ResponseEntity<Bank>(headers, HttpStatus.NOT_FOUND);
        }

    }


    //-------------------Retrieve All Bank Accounts--------------------------------------------------------

    @RequestMapping(value = "/getAllBankAccounts/", method = RequestMethod.GET)
    public ResponseEntity<List<Bank>> listAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        List<Bank> bankAccounts = bankService.findAll();
        List<String> stringList = new ArrayList<>();

        if (bankAccounts.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<Bank>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Bank>>(bankAccounts, HttpStatus.OK);
    }


    //-------------------Retrieve All Bank Transactions--------------------------------------------------------

    @RequestMapping(value = "/getAllBankTransaction/", method = RequestMethod.GET)
    public ResponseEntity<List<BankTransaction>> listAllBankTransaction() {
        HttpHeaders headers = new HttpHeaders();
        List<BankTransaction> bankAccounts = bankTransactionService.findAll();
        List<String> stringList = new ArrayList<>();

        if (bankAccounts.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<BankTransaction>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<BankTransaction>>(bankAccounts, HttpStatus.OK);
    }




    }


