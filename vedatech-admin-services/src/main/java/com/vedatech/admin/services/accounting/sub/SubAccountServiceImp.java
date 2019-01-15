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
        SubAccount subAccountOrigin = subAccountDao.findById(object.getId()).get();
        if (object.getAccountType().getId() != subAccountOrigin.getAccountType().getId()) {
           accountingTypeDao.save( changeTypeTrue(subAccountOrigin));
           subAccountDao.save(object);
            isActive(object);
            return object;
        } else {
            subAccountDao.save(object);
            isActive(object);
            return object;
        }
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
//         List<SubAccount> subAccountList = accountingType.get().getSubAccount();
         List<SubAccount> subAccountList = subAccountDao.findAllByStatusAndAccountType_Id(true, object.getAccountType().getId());
         for(SubAccount s : subAccountList ){
             total = total + s.getBalance();
         }
         accountingType.get().setBalance(total);

        if ( subAccountDao.countAllByStatusAndAccountType_Id(true, object.getAccountType().getId()) >= 1 ||
              !accountingType.get().getState()) {
            accountingType.get().setState(true);
        } else {
            accountingType.get().setState(false);
            accountingType.get().setBalance(0.00);
        }


        accountingTypeDao.save(accountingType.get());

    }

    public AccountingType changeTypeTrue(SubAccount original) {
        System.out.println("CHANGE TYPE TRUE");
        Double total = 0.0;
        if ( subAccountDao.countAllByStatusAndAccountType_Id(true, original.getAccountType().getId()) > 1) {
            System.out.println("MAYOR QUE UNO");
            AccountingType accountingType = accountingTypeDao.findById(original.getAccountType().getId()).get();
            total = accountingType.getBalance() - original.getBalance();
            System.out.println("TOTAL " + total);
             accountingType.setBalance(total);
             return accountingType;
        }

        if (subAccountDao.countAllByStatusAndAccountType_Id(true, original.getAccountType().getId()) == 1){

            AccountingType accountingType = accountingTypeDao.findById(original.getAccountType().getId()).get();
            total = accountingType.getBalance() - original.getBalance();
            System.out.println("TOTAL " + total);
            accountingType.setBalance(total);
            accountingType.setState(false);
            return accountingType;
        } else {

            AccountingType accountingType = accountingTypeDao.findById(original.getAccountType().getId()).get();
            accountingType.setBalance(0.00);
            return accountingType;
        }
    }


}
