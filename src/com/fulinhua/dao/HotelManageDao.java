package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;

/**
 * Created by fulinhua on 2017/2/22.
 */
public interface HotelManageDao {
    public void CheckRegist(Hotel hotel);
    public HotelManager findByIdAndPassword( HotelManager member);
}
