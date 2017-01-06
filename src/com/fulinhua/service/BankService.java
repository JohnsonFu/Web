package com.fulinhua.service;

import com.fulinhua.ENUM.BankType;

/**
 * Created by fulinhua on 2017/1/6.
 */
public interface BankService {
    public BankType WithDrawMoney( long id, double money);
    public BankType ChargeMoney(long id,double money);
}
