package com.fulinhua.action;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;
import com.fulinhua.bean.ReservedOrder;
import com.fulinhua.service.HotelManageService;
import com.fulinhua.service.HotelService;
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

    public List<Hotel> getAllHotel () {
        return allHotel;
    }

    public void setAllHotel ( List<Hotel> allHotel ) {
        this.allHotel = allHotel;
    }

    private List<Hotel> allHotel=new ArrayList<Hotel>();
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
        totalMoney=0;
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
hotelManageService.settle(checkInOrders);
        checkInOrders=hotelManageService.getCheckInOrders(hotel);
        totalMoney=0;
        return "payMoney";
    }

    public String Agree(){
        hotelManageService.Agree(hotel);
        hotellist=hotelManageService.getUncheckHotel();
        return "Agree";
    }

    public HotelService getHotelservice () {
        return Hotelservice;
    }

    public void setHotelservice ( HotelService hotelservice ) {
        Hotelservice = hotelservice;
    }

    private HotelService Hotelservice;

    public List<ReservedOrder> getReservedOrders () {
        return reservedOrders;
    }

    public void setReservedOrders ( List<ReservedOrder> reservedOrders ) {
        this.reservedOrders = reservedOrders;
    }

    private List<ReservedOrder> reservedOrders=new ArrayList<>();

public String ShowSingleBusiness(){

    reservedOrders=Hotelservice.getHotelReservedOrders(hotel);
    checkInOrders=Hotelservice.getHotelCheckInOrders(hotel);
    return "ShowSingleBusiness";
}

}
