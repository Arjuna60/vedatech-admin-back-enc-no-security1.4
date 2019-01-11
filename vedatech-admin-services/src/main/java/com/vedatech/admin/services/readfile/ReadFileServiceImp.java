package com.vedatech.admin.services.readfile;


import com.vedatech.admin.supplier.Supplier;
import com.vedatech.admin.services.supplier.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadFileServiceImp implements ReadFileService {

     public final GetProcessorService getProcessors;
     public final SupplierService supplierService;

    public ReadFileServiceImp(GetProcessorService getProcessors, SupplierService supplierService) {
        this.getProcessors = getProcessors;
        this.supplierService = supplierService;
    }

    @Override
    public <T> List<T> readWithCsvBeanReader(Class<T> tClass, String filename) throws IOException {

        List<T> objects = new ArrayList<>();
        ICsvBeanReader beanReader = null;

        try {
            beanReader = new CsvBeanReader(new FileReader(filename), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors.getSupplierProcessors();
            T object;
            // System.out.println("CUSTOMER " + customer.getFirstName());
            while( (object = beanReader.read(tClass, header, processors)) != null) {
                // System.out.println("BEAN READER LINE " + beanReader.getLineNumber() + " ROW " + beanReader.getRowNumber());
                System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
                        beanReader.getRowNumber(), object));
                objects.add(object);
            }

        }
        finally {
            if( beanReader != null ) {
                beanReader.close();
            }
        }

     return objects;
    }


    @Override
    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}


