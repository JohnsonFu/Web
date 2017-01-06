package com.fulinhua.action;

import com.fulinhua.bean.BankAccount;
import com.fulinhua.bean.Member;
import com.fulinhua.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class MemberAction extends ActionSupport {
    private MemberService memberService;

    public MemberService getMemberService () {
        return memberService;
    }

    public void setMemberService ( MemberService memberService ) {
        this.memberService = memberService;
    }

    public BankAccount getBankAccount () {
        return bankAccount;
    }

    public void setBankAccount ( BankAccount bankAccount ) {
        this.bankAccount = bankAccount;
    }

    public Member getMember () {
        return member;
    }

    public void setMember ( Member member ) {
        this.member = member;
    }

    private BankAccount bankAccount=new BankAccount();
    private Member member=new Member();




}
