package com.vedatech.admin.services.accounting.sub;

import com.vedatech.admin.accounting.SubAccount;
import com.vedatech.admin.services.CrudServices;
import org.springframework.data.repository.CrudRepository;

public interface SubAccountService extends CrudServices<SubAccount, Long> {
}
