package com.vedatech.admin.services.supplier;


import com.vedatech.admin.supplier.Supplier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImp implements SupplierService{

    public final SupplierDao supplierDao;

    public SupplierServiceImp(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierDao.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long aLong) {
        return supplierDao.findById(aLong);
    }

    @Override
    public Supplier save(Supplier object) {
        return supplierDao.save(object);
    }

    @Override
    public void delete(Supplier object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    public void saveAll(List<Supplier> suppliers){
        supplierDao.saveAll(suppliers);
    }
}
