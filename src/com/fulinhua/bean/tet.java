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
        Room temp=new Room();
        temp.setRid(0);
Room room=hotelDao.getRoom(temp);
        room.setIsReleased(9);
hotelDao.update(room);
    }
}
