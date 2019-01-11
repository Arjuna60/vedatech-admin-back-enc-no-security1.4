package com.vedatech.admin.services.readfile.supplier;

import com.vedatech.admin.dto.bank.SupplierDto;
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
public class BeanReaderSupplierServiceImp implements BeanReaderSupplierService {

    public final BeanReaderService beanReaderService;
    public final GetProcessorService getProcessorService;

    public BeanReaderSupplierServiceImp(BeanReaderService beanReaderService, GetProcessorService getProcessorService) {
        this.beanReaderService = beanReaderService;
        this.getProcessorService = getProcessorService;
    }

    @Override
    public List<SupplierDto> readWithCsvBeanReaderSupplier(SupplierDto supplier, String file) throws IOException {
        ICsvBeanReader beanReader = null;
        List<SupplierDto> suppliers = new ArrayList<>();
        try {
            beanReader = beanReaderService.readWithCsvBeanReader(SupplierDto.class, file);
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessorService.getSupplierProcessors();
            suppliers = beanReaderService.BeanReaderSave(SupplierDto.class, beanReader,processors,header);

            } finally {
                    if (beanReader != null) {
                beanReader.close();
                }
                    return suppliers;
        }
    }

}

