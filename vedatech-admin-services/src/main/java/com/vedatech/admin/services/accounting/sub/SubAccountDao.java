package com.vedatech.admin.services.accounting.sub;

import com.vedatech.admin.accounting.SubAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubAccountDao extends CrudRepository<SubAccount, Long> {

    Long countByAccountType_State(Boolean val);
    Long countAllByStatusAndAccountType_Id(Boolean val, Long Id);
}
