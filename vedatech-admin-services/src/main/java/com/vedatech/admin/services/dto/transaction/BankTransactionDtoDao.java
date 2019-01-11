package com.vedatech.admin.services.dto.transaction;

import com.vedatech.admin.dto.bank.BankTransactionDto;
import org.springframework.data.repository.CrudRepository;


public interface BankTransactionDtoDao extends CrudRepository<BankTransactionDto, Long> {
}
