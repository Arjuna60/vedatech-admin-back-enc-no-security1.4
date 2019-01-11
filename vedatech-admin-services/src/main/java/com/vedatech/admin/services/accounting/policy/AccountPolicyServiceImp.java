package com.vedatech.admin.services.accounting.policy;

import com.vedatech.admin.accounting.AccountPolicy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountPolicyServiceImp implements AccountPolicyService {

    AccountPolicyDao accountPolicyDao;

    public AccountPolicyServiceImp(AccountPolicyDao accountPolicyDao) {
        this.accountPolicyDao = accountPolicyDao;
    }

    @Override
    public List<AccountPolicy> findAll() {
        return (List<AccountPolicy>) accountPolicyDao.findAll();
    }

    @Override
    public Optional<AccountPolicy> findById(Long aLong) {
        return accountPolicyDao.findById(aLong);
    }

    @Override
    public AccountPolicy save(AccountPolicy object) {
        return null;
    }

    @Override
    public void delete(AccountPolicy object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void saveAll(List<AccountPolicy> object) {

    }
}
