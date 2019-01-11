package com.vedatech.admin.controller.uploadfile;


import com.vedatech.admin.accounting.AccountingType;
import com.vedatech.admin.bank.Bank;
import com.vedatech.admin.dto.bank.AccountingTypeDto;
import com.vedatech.admin.dto.bank.BankTransactionDto;
import com.vedatech.admin.customer.Customer;
import com.vedatech.admin.dto.bank.CustomerDto;
import com.vedatech.admin.dto.bank.SupplierDto;
import com.vedatech.admin.services.accounting.type.AccountingTypeDao;
import com.vedatech.admin.services.accounting.type.AccountingTypeServiceImp;
import com.vedatech.admin.services.bank.BankDao;
import com.vedatech.admin.services.customer.CustomerDao;
import com.vedatech.admin.services.customer.CustomerService;
import com.vedatech.admin.services.dto.transaction.BankTransactionDtoService;
import com.vedatech.admin.services.readfile.ReadFileService;
import com.vedatech.admin.services.readfile.accounting.BeanReaderAccountingTypeService;
import com.vedatech.admin.services.readfile.bank.BeanReaderBankService;
import com.vedatech.admin.services.readfile.banktrans.BeanReaderBankTransService;
import com.vedatech.admin.services.readfile.customer.BeanReaderCustomerService;
import com.vedatech.admin.services.readfile.supplier.BeanReaderSupplierService;
import com.vedatech.admin.services.supplier.SupplierDao;
import com.vedatech.admin.services.transaction.BankTransactionDao;
import com.vedatech.admin.supplier.Supplier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class UploadFile {

    public final ReadFileService readFileService;
    public final BeanReaderSupplierService beanReaderSupplierService;
    public final BeanReaderCustomerService beanReaderCustomerService;
    public final BeanReaderBankService beanReaderBankService;
    public final BeanReaderBankTransService beanReaderBankTransService;
    public final BeanReaderAccountingTypeService beanReaderAccountingTypeService;
    public final SupplierDao supplierDao;
    public final CustomerService customerService;
    public final BankDao bankDao;
    public final BankTransactionDao bankTransactionDao;
    public final BankTransactionDtoService bankTransactionDtoService;
    public final AccountingTypeServiceImp accountingTypeServiceImp;

    public UploadFile(ReadFileService readFileService, BeanReaderSupplierService beanReaderSupplierService, BeanReaderCustomerService beanReaderCustomerService, BeanReaderBankService beanReaderBankService, BeanReaderBankTransService beanReaderBankTransService, BeanReaderAccountingTypeService beanReaderAccountingTypeService, SupplierDao supplierDao, CustomerService customerService, BankDao bankDao, BankTransactionDao bankTransactionDao, BankTransactionDtoService bankTransactionDtoService, AccountingTypeServiceImp accountingTypeServiceImp) {
        this.readFileService = readFileService;
        this.beanReaderSupplierService = beanReaderSupplierService;
        this.beanReaderCustomerService = beanReaderCustomerService;
        this.beanReaderBankService = beanReaderBankService;
        this.beanReaderBankTransService = beanReaderBankTransService;
        this.beanReaderAccountingTypeService = beanReaderAccountingTypeService;
        this.supplierDao = supplierDao;
        this.customerService = customerService;
        this.bankDao = bankDao;
        this.bankTransactionDao = bankTransactionDao;
        this.bankTransactionDtoService = bankTransactionDtoService;
        this.accountingTypeServiceImp = accountingTypeServiceImp;
    }

    //--------------------------------Read CSV File------------------------------------------------//

    @RequestMapping(value = "/supplier-file", method = RequestMethod.POST)
    public ResponseEntity<String> handleFileSupplierUpload(@RequestParam("file") MultipartFile file, String charset) throws Exception {

        String message="";
        SupplierDto supplier = new SupplierDto();

        try {
            File fileCnv= readFileService.convert(file);
            List<SupplierDto> objecList =  beanReaderSupplierService.readWithCsvBeanReaderSupplier(supplier, fileCnv.getName());
                //supplierDao.saveAll(supplierList);
            if ( objecList.size()==0) {
                message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            } else {
                System.out.println("process ok");
                for(SupplierDto at: objecList){

                    Supplier obj = new Supplier();
                    obj.setTitle(at.getTitle());
                    obj.setFirstName((at.getFirstName()));
                    obj.setLastName(at.getLastName());
                    obj.setCompany(at.getCompany());
                    obj.setDisplayName(at.getDisplayName());
                    obj.setPhone(at.getPhone());
                    obj.setMobile(at.getMobile());
                    obj.setWebsite(at.getWebsite());
                    obj.setStreet(at.getStreet());
                    obj.setCity(at.getCity());
                    obj.setState(at.getState());
                    obj.setCode(at.getCode());
                    obj.setCountry(at.getCountry());
                    obj.setShippingStreet(at.getShippingStreet());
                    obj.setShippingCity(at.getShippingCity());
                    obj.setShippingState(at.getShippingState());
                    obj.setShippingCode(at.getShippingCode());
                    obj.setShippingCountry(at.getShippingCountry());
                    supplierDao.save(obj);
                }
                // accountingTypeServiceImp.saveAll(objecList);
            }
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            System.out.println("Error "+ e);
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @RequestMapping(value = "/customer-file", method = RequestMethod.POST)
    public ResponseEntity<String> handleFileCustomerUpload(@RequestParam("file") MultipartFile file, String charset) throws Exception {

        String message="";
        CustomerDto customer = new CustomerDto();
        try {
            File fileCnv= readFileService.convert(file);
            List<CustomerDto> objecList =  beanReaderCustomerService.readWithCsvBeanReaderCustomer(customer, fileCnv.getName());
            if ( objecList.size()==0) {
                message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            } else {
                System.out.println("process ok");
                for(CustomerDto at: objecList){

                    Customer obj = new Customer();
                    obj.setTitle(at.getTitle());
                    obj.setFirstName((at.getFirstName()));
                    obj.setLastName(at.getLastName());
                    obj.setCompany(at.getCompany());
                    obj.setDisplayName(at.getDisplayName());
                    obj.setPhone(at.getPhone());
                    obj.setMobile(at.getMobile());
                    obj.setWebsite(at.getWebsite());
                    obj.setStreet(at.getStreet());
                    obj.setCity(at.getCity());
                    obj.setState(at.getState());
                    obj.setCode(at.getCode());
                    obj.setCountry(at.getCountry());
                    obj.setShippingStreet(at.getShippingStreet());
                    obj.setShippingCity(at.getShippingCity());
                    obj.setShippingState(at.getShippingState());
                    obj.setShippingCode(at.getShippingCode());
                    obj.setShippingCountry(at.getShippingCountry());
                    customerService.save(obj);
                }
                // accountingTypeServiceImp.saveAll(objecList);
            }


          //  customerDao.saveAll(objecList);
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            System.out.println("Error "+ e);
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @RequestMapping(value = "/bank-file", method = RequestMethod.POST)
    public ResponseEntity<String> handleFileBankUpload(@RequestParam("file") MultipartFile file, String charset) throws Exception {

        String message="";
        Bank obj = new Bank();
        try {
            File fileCnv= readFileService.convert(file);
            List<Bank> objecList =  beanReaderBankService.readWithCsvBeanReaderBank(obj, fileCnv.getName());
            bankDao.saveAll(objecList);
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            System.out.println("Error "+ e);
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


            /* Recevice Filt type CSV of Bank Transactions */

    @RequestMapping(value = "/bank-transaction-file", method = RequestMethod.POST)
    public ResponseEntity<String> handleFileBankTransUpload(@RequestParam("file") MultipartFile file, String charset) throws Exception {

        System.out.println("BANK-TRANSACTION-FILE");
        String message="";
        BankTransactionDto obj = new BankTransactionDto();
        List<BankTransactionDto> objList = new ArrayList<>();
        try {
            File fileCnv= readFileService.convert(file);
            objList =  beanReaderBankTransService.readWithCsvBeanReaderBankTrans(obj, fileCnv.getName());

           if ( objList.size()==0) {
               message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
               return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
           } else {
               bankTransactionDtoService.saveAll(objList);
           }

         //   bankTransactionDao.saveAll(objecList);
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            System.out.println("Error "+ e);
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @RequestMapping(value = "/accounting-type-file", method = RequestMethod.POST)
    public ResponseEntity<String> handleFileAccountingTypeUpload(@RequestParam("file") MultipartFile file, String charset) throws Exception {

      //  System.out.println("File " + file);
        String message="";
        AccountingTypeDto obj = new AccountingTypeDto();
        try {

             List<AccountingTypeDto> objecList;
             List<AccountingType> accountingTypeList = new ArrayList<>();
            File fileCnv= readFileService.convert(file);
            System.out.println("File Cnv " + fileCnv.toString());
            System.out.println("--------------------------------");
            objecList =  beanReaderAccountingTypeService.readWithCsvBeanReaderAccountingType(obj, fileCnv.getName());

            if ( objecList.size()==0) {
                message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            } else {
                System.out.println("process ok");
                for(AccountingTypeDto at: objecList){

                    AccountingType accountingType = new AccountingType();
                    accountingType.setName(at.getName());
                    accountingType.setAccount(at.getAccount());
                    accountingType.setBalance(at.getBalance());
                    accountingType.setState(false);
                    accountingTypeList.add(accountingType);
                  //  accountingTypeServiceImp.save(accountingType);
                }
                    accountingTypeServiceImp.saveAll(accountingTypeList);
            }
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            System.out.println("Error "+ e);
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    private <T> List<String> compareList(List<T> classT) {


        return null;

    }


}
