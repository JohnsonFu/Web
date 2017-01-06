package com.fulinhua.service.impl;

import com.fulinhua.ENUM.BindType;
import com.fulinhua.bean.BankAccount;
import com.fulinhua.bean.Member;
import com.fulinhua.dao.BankDao;
import com.fulinhua.dao.MemberDao;
import com.fulinhua.service.MemberService;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class MemberServiceImpl implements MemberService {
    public MemberDao getMemberDao () {
        return memberDao;
    }

    public void setMemberDao ( MemberDao memberDao ) {
        this.memberDao = memberDao;
    }

    public BankDao getBankDao () {
        return bankDao;
    }

    public void setBankDao ( BankDao bankDao ) {
        this.bankDao = bankDao;
    }

    private MemberDao memberDao;
    private BankDao bankDao;
    @Override
    public boolean Regist ( Member member ) {
        if(memberDao.find(member.getPid())!=null){//该账户已经存在
            return false;
        }else{
            memberDao.insert(member);
            return true;
        }
    }

    @Override
    public BindType Active ( Member member, BankAccount bankAccount) {
        BankAccount account=bankDao.findByIdAndPassword(bankAccount);
        if(account!=null){//银行账户存在
            if(account.getBalance()>=1000){//余额充足
                member.setBalance(member.getBalance()+1000);
                member.setBankAccount(account);//绑定银行卡
                account.setBalance(account.getBalance()-1000);
                bankDao.update(account);//保存修改后的账户
                memberDao.update(member);
                return BindType.银行账户存在余额足够;
            }else{
                member.setBankAccount(account);
                memberDao.update(member);//绑定银行卡
                return BindType.银行账户存在余额不足;

            }
        }else{
            return BindType.银行账户不存在;
        }

    }

    @Override
    public void charge ( Member member, double money ) {

    }

    @Override
    public void reserve () {

    }

    @Override
    public void QuitReserve () {

    }

    @Override
    public void pay () {

    }

    @Override
    public void abolish () {

    }

    @Override
    public void Modify () {

    }

    @Override
    public void ShowInfo () {

    }
}
