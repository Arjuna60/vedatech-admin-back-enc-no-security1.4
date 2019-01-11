package com.vedatech.admin.services.accounting.type;

import com.vedatech.admin.accounting.AccountingType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountingTypeDao extends CrudRepository<AccountingType, Long> {

        Optional<AccountingType> findAccountingTypeById(Long Id);

         List<AccountingType> findAccountingTypeByState(Boolean val);


}
