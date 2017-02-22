package com.fulinhua.service;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.Room;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelService {
public void SubmitHotel(Hotel hotel);//申请开店
public Hotel HotelLogin(Hotel hotel);
    public  void addRoom ( Room room) ;

 public Room getRoom ( Room room );

  public  void editRoom ( Room room );
}
