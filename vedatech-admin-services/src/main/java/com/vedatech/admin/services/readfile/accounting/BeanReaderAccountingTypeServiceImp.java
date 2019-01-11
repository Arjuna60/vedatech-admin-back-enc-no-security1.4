package com.vedatech.admin.services.readfile.accounting;


import com.vedatech.admin.accounting.AccountingType;
import com.vedatech.admin.dto.bank.AccountingTypeDto;
import com.vedatech.admin.services.readfile.GetProcessorService;
import com.vedatech.admin.services.readfile.beanreader.BeanReaderService;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.ICsvBeanReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public
class BeanReaderAccountingTypeServiceImp implements BeanReaderAccountingTypeService {

    public final BeanReaderService beanReaderService;
    public final GetProcessorService getProcessorService;

    public BeanReaderAccountingTypeServiceImp(BeanReaderService beanReaderService, GetProcessorService getProcessorService) {
        this.beanReaderService = beanReaderService;
        this.getProcessorService = getProcessorService;
    }

    @Override
    public List<AccountingTypeDto> readWithCsvBeanReaderAccountingType(AccountingTypeDto obj, String file) throws IOException {

        ICsvBeanReader beanReader = null;
        List<AccountingTypeDto> objects = new ArrayList<>();
        try {
            beanReader = beanReaderService.readWithCsvBeanReader(AccountingTypeDto.class, file);
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessorService.getAccountingTypeProcessors();
            objects = beanReaderService.BeanReaderSave(AccountingTypeDto.class, beanReader,processors,header);

        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
            return objects;
        }
    }

   }
