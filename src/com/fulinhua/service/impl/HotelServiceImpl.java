package com.fulinhua.service.impl;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.ReservedOrder;
import com.fulinhua.bean.Room;
import com.fulinhua.dao.HotelDao;
import com.fulinhua.service.HotelService;

import java.util.List;

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

    @Override
    public Hotel HotelLogin ( Hotel hotel ) {
        return hotelDao.findByIdAndPassword(hotel);
    }

    @Override
    public void addRoom ( Room room ) {
        hotelDao.addRoom(room);
    }

    @Override
    public Room getRoom ( Room room ) {
        return hotelDao.getRoom(room);
    }

    @Override
    public void editRoom ( Room room ) {
        hotelDao.update(room);
    }

    @Override
    public List<ReservedOrder> getOrderList ( Hotel hotel) {
        return hotelDao.getOrderList(hotel);
    }

    @Override
    public void checkIn ( CheckInOrder checkInOrder ) {
        hotelDao.submitCheckIn(checkInOrder);
    }

    @Override
    public ReservedOrder getReservedOrder ( ReservedOrder order ) {
        return hotelDao.getReservedOrder(order);
    }
}
