package com.vedatech.admin.services.readfile;

import com.vedatech.admin.supplier.Supplier;
import com.vedatech.admin.services.supplier.SupplierDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveFileServiceImp  {

    public final SupplierDao supplierDao;

    public SaveFileServiceImp(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public Supplier SaveFileServiceImp(Supplier type ){

       return supplierDao.save(type);
    }
}
