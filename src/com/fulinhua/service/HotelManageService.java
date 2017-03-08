package com.fulinhua.service;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;

import java.util.List;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelManageService {
    public void CheckRegist(Hotel hotel);
    public HotelManager Login(HotelManager hotelManager);
    public List<Hotel> getUncheckHotel();
    public void Agree ( Hotel hotel );
    public List<Hotel> getAllHotels ();
    public Hotel getSingleHotel ( Hotel hotel );
    public List<CheckInOrder> getCheckInOrders ( Hotel hotel );
    public void update ( Hotel hotel,double money );
    public void settle ( List<CheckInOrder> checkInOrders );
    public String getHotelSalesData ();
}
