package com.fulinhua.bean;

import java.util.Date;

/**
 * Created by fulinhua on 2017/1/6.
 */
//会员实体
public class Member {
    private long mid;//会员卡号
    private double balance;//账户余额

    public long getMid () {
        return mid;
    }

    public void setMid ( long mid ) {
        this.mid = mid;
    }

    public double getBalance () {
        return balance;
    }

    public void setBalance ( double balance ) {
        this.balance = balance;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getPid () {
        return pid;
    }

    public void setPid ( String pid ) {
        this.pid = pid;
    }

    public double getAllFee () {
        return allFee;
    }

    public void setAllFee ( double allFee ) {
        this.allFee = allFee;
    }

    public int getLevel () {
        return level;
    }

    public void setLevel ( int level ) {
        this.level = level;
    }

    public BankAccount getBankAccount () {
        return bankAccount;
    }

    public void setBankAccount ( BankAccount bankAccount ) {
        this.bankAccount = bankAccount;
    }

    private String password;
    private String name;//姓名
    private String pid;//身份证号
    private double allFee;//消费总额
    private int level;//账号级别
    private BankAccount bankAccount;//用户银行卡

    public int getIsActive () {
        return isActive;
    }

    public void setIsActive ( int isActive ) {
        this.isActive = isActive;
    }

    private int isActive;

    public Date getActivedate () {
        return activedate;
    }

    public void setActivedate ( Date activedate ) {
        this.activedate = activedate;
    }

    private Date activedate;
}
