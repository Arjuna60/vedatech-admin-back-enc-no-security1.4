package com.vedatech.admin.services.bank;

import com.vedatech.admin.bank.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankServiceImp implements BankService {

    public final BankDao bankDao;

    public BankServiceImp(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public List<Bank> findAll() {
        return (List<Bank>) bankDao.findAll();
    }

    @Override
    public Optional<Bank> findById(Long aLong) {
        return null;
    }

    @Override
    public Bank save(Bank object) {
        return bankDao.save(object);
    }

    @Override
    public void delete(Bank object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void saveAll(List<Bank> object) {

    }


}
