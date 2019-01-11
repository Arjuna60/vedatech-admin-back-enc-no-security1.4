package com.vedatech.admin.services.address;

import com.vedatech.admin.info.Address;

import java.util.List;
import java.util.Optional;

public class AddressServiceImp implements AddressService {

    public final AddressDao addressDao;

    public AddressServiceImp(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Optional<Address> findById(Long aLong) {
        return null;
    }

    @Override
    public Address save(Address object) {
        return addressDao.save(object);
    }

    @Override
    public void delete(Address object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void saveAll(List<Address> object) {

    }
}
