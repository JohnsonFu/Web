package com.fulinhua.dao.impl;

import com.fulinhua.bean.Hotel;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.HotelDao;

import java.sql.SQLException;

/**
 * Created by fulinhua on 2017/2/21.
 */
public class HotelDaoImpl extends BaseDao implements HotelDao {
    @Override
    public void sendRegist ( Hotel hotel ) {
        try {
            super.insert(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
