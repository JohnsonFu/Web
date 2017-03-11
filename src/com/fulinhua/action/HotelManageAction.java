package com.fulinhua.action;

import com.fulinhua.bean.*;
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
            hotelManager=new HotelManager();
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

hotelManageService.settle(checkInOrders);
        checkInOrders=hotelManageService.getCheckInOrders(hotel);
        hotelManageService.update(hotel,totalMoney);
        System.out.println("酒店余额为:"+hotel.getBalance()+" totalmoney="+totalMoney);
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

    public String getHotelData(){
         data=hotelManageService.getHotelSalesData();
        System.out.println(data);
        return SUCCESS;
    }

    public String getData () {
        return data;
    }

    public void setData ( String data ) {
        this.data = data;
    }

    private String data;

    public List<TouristCheckIn> getTouristCheckInList () {
        return touristCheckInList;
    }

    public void setTouristCheckInList ( List<TouristCheckIn> touristCheckInList ) {
        this.touristCheckInList = touristCheckInList;
    }

    private List<TouristCheckIn> touristCheckInList=new ArrayList<TouristCheckIn>();


public String ShowSingleBusiness(){
    hotel=hotelManageService.getSingleHotel(hotel);
    reservedOrders=Hotelservice.getHotelReservedOrders(hotel);
    checkInOrders=Hotelservice.getHotelCheckInOrders(hotel);
    touristCheckInList=Hotelservice.getTouristCheckInList(hotel);
    return "ShowSingleBusiness";
}

}
