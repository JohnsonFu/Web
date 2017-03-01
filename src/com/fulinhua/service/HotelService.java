package com.fulinhua.service;

import com.fulinhua.ENUM.OrderType;
import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.ReservedOrder;
import com.fulinhua.bean.Room;

import java.util.List;

/**
 * Created by fulinhua on 2017/2/21.
 */
public interface HotelService {
public void SubmitHotel(Hotel hotel);//申请开店
public Hotel HotelLogin(Hotel hotel);
public  void addRoom ( Room room) ;
public Room getRoom ( Room room );
public  void editRoom ( Room room );
public List<ReservedOrder> getOrderList ( Hotel hotel);
public OrderType checkInByCard ( CheckInOrder checkInOrder );
public ReservedOrder getReservedOrder ( ReservedOrder order );
public List<ReservedOrder> getHotelReservedOrders ( Hotel hotel );
public List<CheckInOrder> getHotelCheckInOrders ( Hotel hotel );
public OrderType checkInByCash ( CheckInOrder checkInOrder );
public List<CheckInOrder> getDepartureCheckInOrders ( Hotel hotel );
public CheckInOrder getCheckInOrderById ( CheckInOrder checkInOrder );
public void updateCheckIn ( CheckInOrder checkInOrder );
}
