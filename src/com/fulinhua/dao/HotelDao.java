package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.ReservedOrder;
import com.fulinhua.bean.Room;

import java.util.List;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelDao {
    public void sendRegist(Hotel hotel);
    public Hotel findByIdAndPassword(Hotel hotel);
    public void addRoom ( Room room );
    public Room getRoom ( Room room );
    public void update ( Room room );
public List<ReservedOrder> getOrderList ( Hotel hotel);
}
