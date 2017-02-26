package com.fulinhua.action;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.ReservedOrder;
import com.fulinhua.bean.Room;
import com.fulinhua.service.HotelService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by fulinhua on 2017/2/21.
 */
public class HotelAction extends ActionSupport {

    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    public HotelService getHotelservice () {
        return Hotelservice;
    }

    public void setHotelservice ( HotelService hotelservice ) {
        Hotelservice = hotelservice;
    }


    public List<ReservedOrder> getReservedOrderList () {
        return reservedOrderList;
    }

    public void setReservedOrderList ( List<ReservedOrder> reservedOrderList ) {
        this.reservedOrderList = reservedOrderList;
    }

    public ReservedOrder getOrder () {
        return order;
    }

    public void setOrder ( ReservedOrder order ) {
        this.order = order;
    }

    private ReservedOrder order=new ReservedOrder();

    private List<ReservedOrder> reservedOrderList;

    private HotelService Hotelservice;
    private Hotel hotel=new Hotel();

    public Room getRoom () {
        return room;
    }

    public void setRoom ( Room room ) {
        this.room = room;
    }

    private Room room=new Room();
    public String submitRegist(){
        Hotelservice.SubmitHotel(hotel);
        return "registOK";
    }

    public String showAdd(){
        return "showAdd";
    }
    public String AddRoom(){
room.setHotel(hotel);
      Hotelservice.addRoom(room);
        hotel=Hotelservice.HotelLogin(hotel);
        room=new Room();
        return "AddOK";
    }

    public String ReleaseRoom(){
        return "ReleaseRoom";
    }

    public String EditRoom(){
        room=Hotelservice.getRoom(room);
        return "EditRoom";
    }

    public String EditOver(){
      room.setIsReleased(1);
        Hotelservice.editRoom(room);
        hotel=Hotelservice.HotelLogin(hotel);
        return "EditOver";
    }

    public String ShowReserved(){
        reservedOrderList=Hotelservice.getOrderList(hotel);
        return "CheckIn";
    }

    public CheckInOrder getCheckInOrder () {
        return checkInOrder;
    }

    public void setCheckInOrder ( CheckInOrder checkInOrder ) {
        this.checkInOrder = checkInOrder;
    }

    private CheckInOrder checkInOrder=new CheckInOrder();

    public String CheckIn(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        String time=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+" "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        checkInOrder.setCheckInTime(time);
        order=Hotelservice.getReservedOrder(order);
        checkInOrder.setReservedOrder(order);
    Hotelservice.checkIn(checkInOrder);
        return "CheckInOK";
}

    public String Login(){
       hotel=Hotelservice.HotelLogin(hotel);
        if(hotel!=null){
            if(hotel.getIsApprove()==1)//还没通过申请
            return "LoginOK";
            else{
                return "NotApprove";
            }
        }
        else{
            hotel=new Hotel();
            return "LoginFail";
        }
    }
}
