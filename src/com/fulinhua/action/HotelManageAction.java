package com.fulinhua.action;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;
import com.fulinhua.service.HotelManageService;
import com.opensymphony.xwork2.ActionSupport;

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
    public String check(){
        hotelManageService.CheckRegist(hotel);
        return "check";
    }
    public String login(){
        hotelManager=hotelManageService.Login(hotelManager);
        if(hotelManager==null){
            return "loginfail";
        }else{
            return "loginsuccess";
        }
    }

}