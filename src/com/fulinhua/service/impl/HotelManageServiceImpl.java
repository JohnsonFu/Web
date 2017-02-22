package com.fulinhua.service.impl;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;
import com.fulinhua.dao.HotelManageDao;
import com.fulinhua.service.HotelManageService;

import java.util.List;

/**
 * Created by fulinhua on 2017/2/22.
 */
public class HotelManageServiceImpl implements HotelManageService {
    public HotelManageDao getHotelManageDao () {
        return hotelManageDao;
    }

    public void setHotelManageDao ( HotelManageDao hotelManageDao ) {
        this.hotelManageDao = hotelManageDao;
    }

    private HotelManageDao hotelManageDao;
    @Override
    public void CheckRegist ( Hotel hotel ) {
        hotelManageDao.CheckRegist(hotel);
    }
    @Override
    public HotelManager Login ( HotelManager hotelManager ) {
        return hotelManageDao.findByIdAndPassword(hotelManager);
    }

    @Override
    public List<Hotel> getUncheckHotel () {
        return hotelManageDao.getUncheckHotels();
    }
}
