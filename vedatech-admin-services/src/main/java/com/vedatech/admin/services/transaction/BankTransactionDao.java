package com.vedatech.admin.services.transaction;

import com.vedatech.admin.bank.BankTransaction;
import org.springframework.data.repository.CrudRepository;

public interface BankTransactionDao extends CrudRepository<BankTransaction, Long> {
}
