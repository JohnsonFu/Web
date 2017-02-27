package com.fulinhua.service.impl;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;
import com.fulinhua.dao.HotelManageDao;
import com.fulinhua.dao.MemberDao;
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

    public MemberDao getMemberDao () {
        return memberDao;
    }

    public void setMemberDao ( MemberDao memberDao ) {
        this.memberDao = memberDao;
    }

    private MemberDao memberDao;
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

    @Override
    public void Agree ( Hotel hotel ) {
        hotelManageDao.agree(hotel);
    }

    @Override
    public List<Hotel> getAllHotels () {
        return hotelManageDao.getAllHotels();
    }

    @Override
    public Hotel getSingleHotel ( Hotel hotel ) {
        return memberDao.getSingleHotel(hotel);
    }

    @Override
    public List<CheckInOrder> getCheckInOrders ( Hotel hotel ) {
        return hotelManageDao.getCheckIn(hotel);
    }

    @Override
    public void update ( Hotel hotel ) {
        hotelManageDao.update(hotel);
    }

    @Override
    public void settle ( List<CheckInOrder> checkInOrders ) {
        hotelManageDao.settle(checkInOrders);
    }
}
