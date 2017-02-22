package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.Room;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelDao {
    public void sendRegist(Hotel hotel);
    public Hotel findByIdAndPassword(Hotel hotel);
    public void addRoom ( Room room );
}
