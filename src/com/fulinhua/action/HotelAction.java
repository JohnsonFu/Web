package com.fulinhua.action;

import com.fulinhua.bean.Hotel;
import com.fulinhua.service.HotelService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by fulinhua on 2017/2/21.
 */
public class HotelAction extends ActionSupport {
    public HotelService getService () {
        return service;
    }

    public void setService ( HotelService service ) {
        this.service = service;
    }

    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    private HotelService service;
    private Hotel hotel;
}
