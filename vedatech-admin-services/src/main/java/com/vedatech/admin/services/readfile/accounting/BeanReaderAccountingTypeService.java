package com.vedatech.admin.services.readfile.accounting;

import com.vedatech.admin.accounting.AccountingType;
import com.vedatech.admin.dto.bank.AccountingTypeDto;

import java.io.IOException;
import java.util.List;

public interface BeanReaderAccountingTypeService {

    List<AccountingTypeDto> readWithCsvBeanReaderAccountingType(AccountingTypeDto obj, String file) throws IOException;

}
