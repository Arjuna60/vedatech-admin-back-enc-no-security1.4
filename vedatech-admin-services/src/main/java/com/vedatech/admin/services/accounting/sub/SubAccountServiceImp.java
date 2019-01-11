package com.vedatech.admin.services.accounting.sub;


import com.vedatech.admin.accounting.AccountingType;
import com.vedatech.admin.accounting.SubAccount;
import com.vedatech.admin.services.accounting.type.AccountingTypeDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubAccountServiceImp implements SubAccountService{

    public final SubAccountDao subAccountDao;
    public final AccountingTypeDao accountingTypeDao;

    public SubAccountServiceImp(SubAccountDao subAccountDao, AccountingTypeDao accountingTypeDao) {
        this.subAccountDao = subAccountDao;
        this.accountingTypeDao = accountingTypeDao;
    }

    @Override
    public List<SubAccount> findAll() {
        return (List<SubAccount>) subAccountDao.findAll();
    }

    @Override
    public Optional<SubAccount> findById(Long aLong) {
        return subAccountDao.findById(aLong);
    }

    @Override
    public SubAccount save(SubAccount object) {

        System.out.println(object.getAccountType().getId());
        System.out.println(subAccountDao.countAllByStatusAndAccountType_Id(true, object.getAccountType().getId()));

           subAccountDao.save(object);
           isActive(object);
           return object;
    }


    @Override
    public void delete(SubAccount object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void saveAll(List<SubAccount> object) {

    }

    public void isActive(SubAccount object){
        Double total=0.0;
        System.out.println(subAccountDao.countAllByStatusAndAccountType_Id(true, object.getAccountType().getId()));
        Optional<AccountingType> accountingType = accountingTypeDao.findAccountingTypeById(object.getAccountType().getId());
         List<SubAccount> subAccountList = accountingType.get().getSubAccount();
         for(SubAccount s : subAccountList ){
             total = total + s.getBalance();
         }
         accountingType.get().setBalance(total);

        if ( subAccountDao.countAllByStatusAndAccountType_Id(true, object.getAccountType().getId()) >= 1 ||
              !accountingType.get().getState()) {
            accountingType.get().setState(true);
        } else {
            accountingType.get().setState(false);
        }

        accountingTypeDao.save(accountingType.get());
    }


}
