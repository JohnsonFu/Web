package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/2/24.
 */
public class ReservedOrder {//

    public long getOrderID () {
        return OrderID;
    }

    public void setOrderID ( long orderID ) {
        OrderID = orderID;
    }

    private long OrderID;
    private String SubmitTime;//订单提交时间
    private String name;//入住者姓名
    private String personID;//入住者身份证号
    private double paymoney;//实付金额
    private Member member;//预订者

    public String getSubmitTime () {
        return SubmitTime;
    }

    public void setSubmitTime ( String submitTime ) {
        SubmitTime = submitTime;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getPersonID () {
        return personID;
    }

    public void setPersonID ( String personID ) {
        this.personID = personID;
    }

    public double getPaymoney () {
        return paymoney;
    }

    public void setPaymoney ( double paymoney ) {
        this.paymoney = paymoney;
    }

    public Member getMember () {
        return member;
    }

    public void setMember ( Member member ) {
        this.member = member;
    }

    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }


    public String getInTime () {
        return inTime;
    }

    public void setInTime ( String orderTime ) {
        inTime = orderTime;
    }

    public String getQuitTime () {
        return QuitTime;
    }

    public void setQuitTime ( String quitTime ) {
        QuitTime = quitTime;
    }

    private Hotel hotel;//所订酒店
   private long RoomNumber;

    public long getRoomNumber () {
        return RoomNumber;
    }

    public void setRoomNumber ( long roomNumber ) {
        RoomNumber = roomNumber;
    }


    public String getRoomType () {
        return RoomType;
    }

    public void setRoomType ( String roomType ) {
        RoomType = roomType;
    }

    private String RoomType;
    private String inTime;//将入住时间
    private String QuitTime;//将退房时间

    public int getDays () {
        return days;
    }

    public void setDays ( int days ) {
        this.days = days;
    }

    private int days;//入住了多久

}
