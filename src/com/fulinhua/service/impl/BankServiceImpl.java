package com.fulinhua.service.impl;

import com.fulinhua.bean.BankAccount;
import com.fulinhua.ENUM.BankType;
import com.fulinhua.dao.BankDao;
import com.fulinhua.service.BankService;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class BankServiceImpl implements BankService {
    private BankDao bankDao;
    @Override
    public BankType WithDrawMoney ( long id, double money ) {
        BankAccount bankAccount=bankDao.find(id);
        if(bankAccount==null){
            return BankType.账号不存在;
        }
        if(bankAccount.getBalance()<money){
            return BankType.余额不足;
        }
        else{
            bankAccount.setBalance(bankAccount.getBalance()-money);
              bankDao.update(bankAccount);

            return BankType.取款成功;
        }


    }

    @Override
    public BankType ChargeMoney ( long id, double money ) {
        BankAccount bankAccount=bankDao.find(id);
        if(bankAccount==null){
            return BankType.账号不存在;
        }else{
            bankAccount.setBalance(bankAccount.getBalance()+money);

                bankDao.update(bankAccount);

            return BankType.充值成功;
        }
    }
}
