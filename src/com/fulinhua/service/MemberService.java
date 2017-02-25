package com.fulinhua.service;

import com.fulinhua.ENUM.BankType;
import com.fulinhua.ENUM.BindType;
import com.fulinhua.ENUM.MemberType;
import com.fulinhua.ENUM.OrderType;
import com.fulinhua.bean.*;

import java.util.List;

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
    public List<Hotel> getAllHotel ();
    public Hotel getHotelRoom ( Hotel hotel );
    public Room getRoom ( Room room );
    public OrderType submitOrder ( ReservedOrder order );
}
