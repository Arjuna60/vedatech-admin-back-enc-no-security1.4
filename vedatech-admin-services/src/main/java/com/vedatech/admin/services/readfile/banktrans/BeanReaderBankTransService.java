package com.vedatech.admin.services.readfile.banktrans;

import com.vedatech.admin.dto.bank.BankTransactionDto;

import java.io.IOException;
import java.util.List;

public interface BeanReaderBankTransService {

    List<BankTransactionDto> readWithCsvBeanReaderBankTrans(BankTransactionDto obj, String file) throws IOException;

}
