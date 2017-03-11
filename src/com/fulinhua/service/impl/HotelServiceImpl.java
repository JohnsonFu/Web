package com.fulinhua.service.impl;

import com.fulinhua.ENUM.OrderType;
import com.fulinhua.bean.*;
import com.fulinhua.dao.HotelDao;
import com.fulinhua.dao.MemberDao;
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

    public MemberDao getMemberDao () {
        return memberDao;
    }

    public void setMemberDao ( MemberDao memberDao ) {
        this.memberDao = memberDao;
    }

    private MemberDao memberDao;

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
    public OrderType checkInByCard ( CheckInOrder checkInOrder ) {
        Member member=checkInOrder.getReservedOrder().getMember();
        ReservedOrder reservedOrder=checkInOrder.getReservedOrder();
         if(member.getBalance()<reservedOrder.getPaymoney()) {//银行卡钱不够
            return OrderType.余额不足;
        }else{
          member.setBalance((member.getBalance()-reservedOrder.getPaymoney())*(1-member.getLevel()*0.001));//优惠幅度 一级优惠0.1%
             member.setExp(member.getExp()+reservedOrder.getPaymoney());//经验值加上消费额为新的经验值
             member.setLevel(((int)member.getExp())/1000);//1000元升一级，重新设定等级
             member.setPoints(member.getPoints()+reservedOrder.getPaymoney()/100);//积分为消费额的百分之一

        memberDao.update(member);
             checkInOrder.getReservedOrder().setIsCheckIn(1);
             checkInOrder.setHasDepart(0);
             checkInOrder.setHasSettle(0);
             hotelDao.submitCheckIn(checkInOrder);
        return OrderType.支付成功;
        }

     }

    @Override
    public ReservedOrder getReservedOrder ( ReservedOrder order ) {
        return hotelDao.getReservedOrder(order);
    }

    @Override
    public List<ReservedOrder> getHotelReservedOrders ( Hotel hotel ) {
        return hotelDao.getHotelReservedOrders(hotel);
    }

    @Override
    public List<CheckInOrder> getHotelCheckInOrders ( Hotel hotel ) {
        return hotelDao.getHotelCheckInOrders(hotel);
    }

    @Override
    public OrderType checkInByCash ( CheckInOrder checkInOrder ) {//现金不能参加优惠
        ReservedOrder reservedOrder=checkInOrder.getReservedOrder();
        Hotel hotel=reservedOrder.getHotel();
        hotel.setBalance(hotel.getBalance()+reservedOrder.getPaymoney());
        hotelDao.UpdateHotel(hotel);
            checkInOrder.getReservedOrder().setIsCheckIn(1);
        checkInOrder.setHasSettle(1);//已经收到钱了
        checkInOrder.setHasDepart(0);
            hotelDao.submitCheckIn(checkInOrder);
            return OrderType.支付成功;

    }

    @Override
    public List<CheckInOrder> getDepartureCheckInOrders ( Hotel hotel ) {
        return hotelDao.getDepartureCheckInOrders(hotel);
    }

    @Override
    public CheckInOrder getCheckInOrderById ( CheckInOrder checkInOrder ) {
        return hotelDao.getCheckInOrderById(checkInOrder);
    }

    @Override
    public void updateCheckIn ( CheckInOrder checkInOrder ) {
        hotelDao.updateChcekIn(checkInOrder);
    }

    @Override
    public void updateHotel ( Hotel hotel ) {
        hotelDao.updateHotel(hotel);
    }

    @Override
    public void AddTouristCheckIn ( TouristCheckIn touristCheckIn ) {
        hotelDao.AddTouristCheckIn(touristCheckIn);
    }

    @Override
    public List<TouristCheckIn> getTouristCheckInList ( Hotel hotel ) {
        return hotelDao.getTouristCheckInList(hotel);
    }

    @Override
    public TouristCheckIn getTouristCheckInById ( TouristCheckIn touristCheckIn ) {
        return hotelDao.getTouristCheckInById(touristCheckIn);
    }

    @Override
    public void updateTouristCheckIn ( TouristCheckIn touristCheckIn ) {
        hotelDao.updateTouristCheckIn(touristCheckIn);
    }


}
