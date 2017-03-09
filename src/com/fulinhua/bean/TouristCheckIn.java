package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/3/9.
 */
public class TouristCheckIn {
    private long tid;
    private String name;//入住者姓名
    private String personID;//入住者身份证号

    public long getTid () {
        return tid;
    }

    public void setTid ( long tid ) {
        this.tid = tid;
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

    public int getRoomID () {
        return roomID;
    }

    public void setRoomID ( int roomID ) {
        this.roomID = roomID;
    }





    public String getQuitTime () {
        return QuitTime;
    }

    public void setQuitTime ( String quitTime ) {
        QuitTime = quitTime;
    }



    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }



    private double paymoney;//实付金额
    private int roomID;//房间ID

    public String getRoomType () {
        return roomType;
    }

    public void setRoomType ( String roomType ) {
        this.roomType = roomType;
    }

    private String roomType;

    public int getDays () {
        return days;
    }

    public void setDays ( int days ) {
        this.days = days;
    }

    private int days;

    public String getCheckinTime () {
        return CheckinTime;
    }

    public void setCheckinTime ( String checkinTime ) {
        CheckinTime = checkinTime;
    }

    private String CheckinTime;//入住时间
    private String QuitTime;//将退房时间

    public int getIsDeparture () {
        return isDeparture;
    }

    public void setIsDeparture ( int isDeparture ) {
        this.isDeparture = isDeparture;
    }

    private int isDeparture;//是否离店
    private Hotel hotel;//所订酒店

    public long getRoomNumber () {
        return roomNumber;
    }

    public void setRoomNumber ( long roomNumber ) {
        this.roomNumber = roomNumber;
    }

    private long roomNumber;


}
