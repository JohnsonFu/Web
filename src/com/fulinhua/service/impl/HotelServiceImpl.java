package com.fulinhua.service.impl;

import com.fulinhua.bean.Hotel;
import com.fulinhua.dao.HotelDao;
import com.fulinhua.service.HotelService;

/**
 * Created by fulinhua on 2017/2/21.
 */
public class HotelServiceImpl implements HotelService {
    public HotelDao getHotelDao () {
        return hotelDao;
    }

    public void setHotelDao ( HotelDao hotelDao ) {
        this.hotelDao = hotelDao;
    }

    private HotelDao hotelDao;


    @Override
    public void SubmitHotel ( Hotel hotel ) {
hotelDao.sendRegist(hotel);
    }
}