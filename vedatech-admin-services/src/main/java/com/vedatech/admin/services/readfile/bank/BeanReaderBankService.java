package com.vedatech.admin.services.readfile.bank;

import com.vedatech.admin.bank.Bank;
import com.vedatech.admin.supplier.Supplier;

import java.io.IOException;
import java.util.List;

public interface BeanReaderBankService {

    List<Bank> readWithCsvBeanReaderBank(Bank obj, String file) throws IOException;

}
