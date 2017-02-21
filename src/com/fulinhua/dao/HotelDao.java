package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelDao {
    public void sendRegist(Hotel hotel);
    public Hotel findByIdAndPassword(Hotel hotel);
}
