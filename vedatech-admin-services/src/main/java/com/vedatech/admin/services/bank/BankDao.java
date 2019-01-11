package com.vedatech.admin.services.bank;

import com.vedatech.admin.bank.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankDao extends CrudRepository<Bank, Long> {

        Bank findBankByAccountNumber(Long accountNumber);
        Bank findBankById(Long id);

}
