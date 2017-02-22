package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;

import java.util.List;

/**
 * Created by fulinhua on 2017/2/22.
 */
public interface HotelManageDao {
    public void CheckRegist(Hotel hotel);
    public HotelManager findByIdAndPassword( HotelManager member);
    public List<Hotel> getUncheckHotels();
}
