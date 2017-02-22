package com.fulinhua.service;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelManageService {
    public void CheckRegist(Hotel hotel);
    public HotelManager Login(HotelManager hotelManager);
}
