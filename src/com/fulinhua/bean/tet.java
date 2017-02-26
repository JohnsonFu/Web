package com.fulinhua.bean;

import com.fulinhua.dao.HotelDao;
import com.fulinhua.dao.impl.HotelDaoImpl;

import java.sql.SQLException;

/**
 * Created by fulinhua on 2017/1/11.
 */
public class tet {
    public static void  main(String[] args) throws SQLException {

       HotelDao hotelDao=new HotelDaoImpl();
        CheckInOrder checkInOrder=new CheckInOrder();
        checkInOrder.setCheckInTime("dafs");
hotelDao.submitCheckIn(checkInOrder);
    }
}
