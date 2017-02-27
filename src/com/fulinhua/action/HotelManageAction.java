package com.fulinhua.action;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;
import com.fulinhua.service.HotelManageService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulinhua on 2017/2/22.
 */
public class HotelManageAction extends ActionSupport {
    public HotelManageService getHotelManageService () {
        return hotelManageService;
    }

    public void setHotelManageService ( HotelManageService hotelManageService ) {
        this.hotelManageService = hotelManageService;
    }

    private HotelManageService hotelManageService;

    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    public HotelManager getHotelManager () {
        return hotelManager;
    }

    public void setHotelManager ( HotelManager hotelManager ) {
        this.hotelManager = hotelManager;
    }

    private HotelManager hotelManager=new HotelManager();
    private Hotel hotel=new Hotel();

    public List<CheckInOrder> getCheckInOrders () {
        return checkInOrders;
    }

    public void setCheckInOrders ( List<CheckInOrder> checkInOrders ) {
        this.checkInOrders = checkInOrders;
    }

    private List<CheckInOrder> checkInOrders=new ArrayList<CheckInOrder>();
    public String check(){
        hotelManageService.CheckRegist(hotel);
        return "check";
    }

    public double getTotalMoney () {
        return totalMoney;
    }

    public void setTotalMoney ( double totalMoney ) {
        this.totalMoney = totalMoney;
    }

    private double totalMoney=0;

    public List<Hotel> getHotellist () {
        return hotellist;
    }

    public void setHotellist ( List<Hotel> hotellist ) {
        this.hotellist = hotellist;
    }

    private List<Hotel> hotellist=new ArrayList<Hotel>();
    public String login(){
        hotelManager=hotelManageService.Login(hotelManager);
        if(hotelManager==null){
            return "loginfail";
        }else{
            hotellist=hotelManageService.getUncheckHotel();
            return "loginsuccess";
        }
    }

    public String ShowSettleMoney(){
        hotellist=hotelManageService.getAllHotels();
        return "ShowSettle";
    }

    public String ShowSingleList(){
hotel=hotelManageService.getSingleHotel(hotel);
        checkInOrders=hotelManageService.getCheckInOrders(hotel);
        for(CheckInOrder s:checkInOrders){
            totalMoney+=s.getReservedOrder().getPaymoney();
        }
        return "ShowSingleList";
    }

    public String payMoney(){
hotel.setBalance(hotel.getBalance()+totalMoney);
        hotelManageService.update(hotel);

        return "payMoney";
    }

    public String Agree(){
        hotelManageService.Agree(hotel);
        hotellist=hotelManageService.getUncheckHotel();
        return "Agree";
    }

}
