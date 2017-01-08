package com.fulinhua.action;

import com.fulinhua.ENUM.BindType;
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

    public String MemberRegist(){
       boolean flag=memberService.Regist(member);
        if(flag=true){
            return "success";
        }else{
            return "registfail";
        }
    }

    public String MemberLogin(){
member=memberService.Login(member);
        if(member==null){
            return "LoginFail";
        }else{
            BankAccount account=member.getBankAccount();
            if(account==null){
                return "NotBind";
            }else{
                return "LoginSuccess";
            }
        }

    }
public String BindBank(){
    bankAccount.setBankID(Long.parseLong(bankid));
    bankAccount.setPassword(bankpassword);
BindType result=memberService.Active(member,bankAccount);
    if(result==BindType.银行账户不存在或密码错误){
        BindResult=result.toString();
        return SUCCESS;
    }else{
        BindResult=result.toString();
        return SUCCESS;
    }

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

    public String getBindResult () {
        return BindResult;
    }

    public void setBindResult ( String bindResult ) {
        BindResult = bindResult;
    }

    private String BindResult;

    public String getBankid () {
        return bankid;
    }

    public void setBankid ( String bankid ) {
        this.bankid = bankid;
    }

    private String bankid;

    public String getBankpassword () {
        return bankpassword;
    }

    public void setBankpassword ( String bankpassword ) {
        this.bankpassword = bankpassword;
    }

    private String bankpassword;

}
