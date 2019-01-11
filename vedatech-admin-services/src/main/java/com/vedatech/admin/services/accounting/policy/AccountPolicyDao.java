package com.vedatech.admin.services.accounting.policy;

import com.vedatech.admin.accounting.AccountPolicy;
import org.springframework.data.repository.CrudRepository;

public interface AccountPolicyDao extends CrudRepository<AccountPolicy, Long> {
}
