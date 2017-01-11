package com.fulinhua.bean;

import com.fulinhua.dao.BaseDao;

import java.sql.SQLException;

/**
 * Created by fulinhua on 2017/1/11.
 */
public class tet {
    public static void  main(String[] args) throws SQLException {

        BaseDao baseDao=new BaseDao();
       Hotel hotel=baseDao.getHotel(1);
      for(Room room:hotel.getRoomList()){
          System.out.println(room.getRoomNumber());
      }


    }
}
