package com.fulinhua.service.impl;

import com.fulinhua.ENUM.BankType;
import com.fulinhua.ENUM.BindType;
import com.fulinhua.ENUM.MemberType;
import com.fulinhua.ENUM.OrderType;
import com.fulinhua.bean.*;
import com.fulinhua.dao.BankDao;
import com.fulinhua.dao.HotelDao;
import com.fulinhua.dao.MemberDao;
import com.fulinhua.service.MemberService;

import java.util.Date;
import java.util.List;

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

    public HotelDao getHotelDao () {
        return hotelDao;
    }

    public void setHotelDao ( HotelDao hotelDao ) {
        this.hotelDao = hotelDao;
    }

    private HotelDao hotelDao;
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
    public Member Login ( Member member ) {
        return memberDao.findByIdAndPassword(member);
    }

    @Override
    public BindType Active ( Member member, BankAccount bankAccount) {
        BankAccount account=bankDao.findByIdAndPassword(bankAccount);
        if(account!=null){//银行账户存在
            if(account.getBalance()>=1000){//余额充足
                member.setBalance(member.getBalance()+1000);
                member.setBankAccount(account);//绑定银行卡
                Date time=new Date();
                member.setActivedate(time);
                account.setBalance(account.getBalance()-1000);
                bankDao.update(account);//保存修改后的账户
                member.setIsActive(1);
                memberDao.update(member);
                return BindType.银行账户存在余额足够;
            }else{
               // member.setBankAccount(account);
                //memberDao.update(member);//钱不够不绑定
                return BindType.银行账户存在余额不足;

            }
        }else{
            return BindType.银行账户不存在或密码错误;
        }

    }

  @Override
    public BankType charge ( Member member, double money ) {
        BankAccount account=member.getBankAccount();
        if(account!=null){//银行账户存在
            if(account.getBalance()>=money){//余额充足
                member.setBalance(member.getBalance()+money);//将钱从银行卡中取到账户中
                account.setBalance(account.getBalance()-money);
                bankDao.update(account);//保存修改后的账户
                memberDao.update(member);
                return BankType.充值成功;
            }else{
                return BankType.余额不足;

            }
        }else{
            return BankType.账号不存在;
        }
    }

    @Override
    public void reserve () {

    }

    @Override
    public void QuitReserve () {

    }



@Override
    public MemberType pay (Member me,double money) {


       double balance=me.getBalance();
            if(balance>=money) {//余额充足
                me.setBalance(balance-money);
                memberDao.update(me);
                return MemberType.支付成功;
            }else{
                return MemberType.余额不足支付失败;
            }
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

    @Override
    public List<Hotel> getAllHotel () {
        return memberDao.getHotels();
    }

    @Override
    public Hotel getHotelRoom ( Hotel hotel ) {
        return memberDao.getSingleHotel(hotel);
    }

    @Override
    public Room getRoom ( Room room ) {
        return memberDao.getRoom(room);
    }

    @Override
    public OrderType submitOrder ( ReservedOrder order ) {
        Member member=order.getMember();
        Room temp=new Room();
        temp.setRid((int) order.getRoomID());
      Room  room=hotelDao.getRoom(temp);
        order.setPaymoney(order.getDays()*room.getPrice());
       // if(member.getBalance()<order.getPaymoney()) {//银行卡钱不够
        //    return OrderType.余额不足;
        //}else{
            memberDao.submitOrder(order);
          //  member.setBalance(member.getBalance()-order.getPaymoney());
            //memberDao.update(member);
            return OrderType.预定成功;
        //}


    }

    @Override
    public void updateRoom ( Room room ) {
        hotelDao.update(room);
    }

    @Override
    public List<ReservedOrder> getReservedOrder ( Member member ) {
        return memberDao.getReservedOrder(member);
    }

    @Override
    public List<CheckInOrder> getCheckInOrder ( Member member ) {
        return memberDao.getCheckInOrder(member);
    }

    @Override
    public Member getRegistMember () {
        return memberDao.getRegistMember();
    }

    @Override
    public void update ( Member member ) {
        memberDao.update(member);
    }

    @Override
    public void updateBankAccount ( BankAccount bankAccount ) {
        bankDao.update(bankAccount);
    }

    @Override
    public void CheckAllMemberQuality () {
        List<Member> memberList=memberDao.getAllMember();
        for (Member member:memberList) {
            if(member.getIsActive()==1) {//已激活
                Date date = member.getActivedate();
                Date nowtime = new Date();
                long minutes = (nowtime.getTime() - date.getTime()) / (1000 * 60);
                if (minutes > 525600&&member.getBalance()<1000) {//过去了一年并且金额已经不足1000
member.setIsActive(0);
                    memberDao.update(member);
                }
            }
            if(member.getIsActive()==0&&member.getBankAccount()!=null){//被停止了
                Date date = member.getActivedate();
                Date nowtime = new Date();
                long minutes = (nowtime.getTime() - date.getTime()) / (1000 * 60);
                if(member.getBalance()>=1000){//充值了
                    member.setActivedate(new Date());//重新设置激活时间
                    member.setIsActive(1);//激活
                    memberDao.update(member);
                }
                if(member.getBalance()<1000&&minutes>1051200) {//失效一年后仍未充值
              member.setIsActive(-1);
                    memberDao.update(member);
                }
            }
        }
    }

    @Override
    public ReservedOrder getOrderById ( ReservedOrder order ) {
        return memberDao.getOrderById(order);
    }

    @Override
    public Hotel getHotelById ( Hotel hotel ) {
        return hotelDao.getHotelById(hotel);
    }

    @Override
    public void delete ( ReservedOrder order ) {
        memberDao.delete(order);
    }

    @Override
    public void exchangePoints ( Member member ) {
        member.setBalance(member.getBalance()+member.getPoints());//把积分兑换成余额
        member.setPoints(0);//清空积分
        memberDao.update(member);//更新member
    }

    @Override
    public Member getMemberById ( long mid ) {
        return memberDao.getByMid(mid);
    }
}
