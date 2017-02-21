package com.fulinhua.action;

import com.fulinhua.bean.Hotel;
import com.fulinhua.service.HotelService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by fulinhua on 2017/2/21.
 */
public class HotelAction extends ActionSupport {

    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    public HotelService getHotelservice () {
        return Hotelservice;
    }

    public void setHotelservice ( HotelService hotelservice ) {
        Hotelservice = hotelservice;
    }

    private HotelService Hotelservice;
    private Hotel hotel=new Hotel();

    public String submitRegist(){
        Hotelservice.SubmitHotel(hotel);
        return "registOK";
    }
    public String Login(){
       hotel=Hotelservice.HotelLogin(hotel);
        if(hotel!=null){
            return "LoginOK";
        }
        else{
            return "LoginFail";
        }
    }
}
