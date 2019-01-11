package com.vedatech.admin.services.readfile.bank;

import com.vedatech.admin.bank.Bank;
import com.vedatech.admin.services.readfile.GetProcessorService;
import com.vedatech.admin.services.readfile.beanreader.BeanReaderService;
import com.vedatech.admin.supplier.Supplier;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.ICsvBeanReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeanReaderBankServiceImp implements BeanReaderBankService {

    public final BeanReaderService beanReaderService;
    public final GetProcessorService getProcessorService;

    public BeanReaderBankServiceImp(BeanReaderService beanReaderService, GetProcessorService getProcessorService) {
        this.beanReaderService = beanReaderService;
        this.getProcessorService = getProcessorService;
    }

    @Override
    public List<Bank> readWithCsvBeanReaderBank(Bank obj, String file) throws IOException {
        ICsvBeanReader beanReader = null;
        List<Bank> objects = new ArrayList<>();
        try {
            beanReader = beanReaderService.readWithCsvBeanReader(Supplier.class, file);
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessorService.getBankProcessors();
            objects = beanReaderService.BeanReaderSave(Bank.class, beanReader,processors,header);

        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
            return objects;
        }
    }

}

