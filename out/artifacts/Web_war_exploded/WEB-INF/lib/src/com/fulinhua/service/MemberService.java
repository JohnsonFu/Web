package com.fulinhua.service;

import com.fulinhua.ENUM.BankType;
import com.fulinhua.ENUM.BindType;
import com.fulinhua.ENUM.MemberType;
import com.fulinhua.bean.BankAccount;
import com.fulinhua.bean.Member;

/**
 * Created by fulinhua on 2017/1/6.
 */
public interface MemberService {
    public boolean Regist( Member member);
    public Member Login(Member member);
    public BindType Active( Member member, BankAccount bankAccount);
    public BankType charge( Member member, double money);
    public void reserve();
    public void QuitReserve();
    public MemberType pay( Member me, double money);
    public void abolish();
    public void Modify();
    public void ShowInfo();


}
