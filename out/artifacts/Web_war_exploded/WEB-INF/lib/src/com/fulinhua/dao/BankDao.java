package com.fulinhua.dao;

import com.fulinhua.bean.BankAccount;

/**
 * Created by fulinhua on 2017/1/6.
 */
public interface BankDao {
    public BankAccount find (long id);
    public BankAccount findByIdAndPassword(BankAccount account);
    public void update(BankAccount bankAccount);
}
