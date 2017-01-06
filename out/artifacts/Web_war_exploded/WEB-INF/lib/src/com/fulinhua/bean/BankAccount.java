package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class BankAccount {
    private long BankID;

    public long getBankID () {
        return BankID;
    }

    public void setBankID ( long bankID ) {
        BankID = bankID;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public double getBalance () {
        return balance;
    }

    public void setBalance ( double balance ) {
        this.balance = balance;
    }

    private String password;
    private double balance;



}
