package com.fulinhua.action;

import com.fulinhua.ENUM.OrderType;
import com.fulinhua.bean.*;
import com.fulinhua.service.HotelService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
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

    public List<ReservedOrder> getReservedOrders () {
        return reservedOrders;
    }

    public void setReservedOrders ( List<ReservedOrder> reservedOrders ) {
        this.reservedOrders = reservedOrders;
    }

    private List<ReservedOrder> reservedOrders=new ArrayList<>();//业务信息

    public List<CheckInOrder> getCheckInOrders () {
        return checkInOrders;
    }

    public void setCheckInOrders ( List<CheckInOrder> checkInOrders ) {
        this.checkInOrders = checkInOrders;
    }

    private List<CheckInOrder> checkInOrders=new ArrayList<>();

    public String ShowBill(){
        reservedOrders=Hotelservice.getHotelReservedOrders(hotel);
        checkInOrders=Hotelservice.getHotelCheckInOrders(hotel);
        touristCheckInList=Hotelservice.getTouristCheckInList(hotel);
        return "ShowBill";
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
        order=Hotelservice.getReservedOrder(order);
        member= order.getMember();
        return "CheckInSingle";
    }

    public String ShowReleasedRoom(){

    return "ShowReleasedRoom";
    }

    public String FillTouristOrder(){
        room=Hotelservice.getRoom(room);

        return "FillTouristOrder";
    }

    public TouristCheckIn getTouristCheckIn () {
        return touristCheckIn;
    }

    public String submitTouristOrder(){
        touristCheckIn.setHotel(hotel);
        touristCheckIn.setIsDeparture(0);
        touristCheckIn.setPaymoney(room.getPrice()*touristCheckIn.getDays());
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String time=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        touristCheckIn.setCheckinTime(time);
        hotel.setBalance(hotel.getBalance()+touristCheckIn.getPaymoney());
        Hotelservice.AddTouristCheckIn(touristCheckIn);
        Hotelservice.updateHotel(hotel);
        room.setIsFull(1);
        room.setIsReleased(0);
        room.setIsReserved(0);//已经入住了
        Hotelservice.editRoom(room);
        reservedOrderList=Hotelservice.getOrderList(hotel);
        return "CheckInOK";
    }

    public void setTouristCheckIn ( TouristCheckIn touristCheckIn ) {
        this.touristCheckIn = touristCheckIn;
    }

    private TouristCheckIn touristCheckIn=new TouristCheckIn();

    public Member getMember () {
        return member;
    }

    public void setMember ( Member member ) {
        this.member = member;
    }

    private Member member=new Member();

    public String CheckInByCard(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        String time=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        checkInOrder.setCheckInTime(time);
        order=Hotelservice.getReservedOrder(order);
        order.setIsCheckIn(1);
        checkInOrder.setReservedOrder(order);
  OrderType res=Hotelservice.checkInByCard(checkInOrder);
        if(res.equals(OrderType.支付成功)) {
            room=Hotelservice.getRoom(room);
            room.setIsFull(1);
            room.setIsReserved(0);//已经入住了
            Hotelservice.editRoom(room);
            reservedOrderList=Hotelservice.getOrderList(hotel);
            return "CheckInOK";
        }else{

            return "CheckInOK";
        }
}

    public String Departure(){
       checkInOrder=Hotelservice.getCheckInOrderById(checkInOrder);
        checkInOrder.setHasDepart(1);
        room=Hotelservice.getRoom(room);
        room.setIsFull(0);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String time=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        checkInOrder.setDepartureTime(time);
        Hotelservice.updateCheckIn(checkInOrder);
        Hotelservice.editRoom(room);//完毕
        checkInOrders=Hotelservice.getDepartureCheckInOrders(hotel);
        return "ShowDeparture";
    }

    public String backToHomePage(){
        hotel=Hotelservice.HotelLogin(hotel);
        return "LoginOK";
    }

    public String TouristDeparture(){
        touristCheckIn=Hotelservice.getTouristCheckInById(touristCheckIn);
        touristCheckIn.setIsDeparture(1);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String time=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        touristCheckIn.setQuitTime(time);
        room.setRid(touristCheckIn.getRoomID());
                room=Hotelservice.getRoom(room);
        room.setIsFull(0);
        Hotelservice.updateTouristCheckIn(touristCheckIn);
        Hotelservice.editRoom(room);

        return ShowDeparture();
    }

    public List<TouristCheckIn> getTouristCheckInList () {
        return touristCheckInList;
    }

    public void setTouristCheckInList ( List<TouristCheckIn> touristCheckInList ) {
        this.touristCheckInList = touristCheckInList;
    }

    private List<TouristCheckIn> touristCheckInList=new ArrayList<TouristCheckIn>();


    public String CheckInByCash(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        String time=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        checkInOrder.setCheckInTime(time);
        order=Hotelservice.getReservedOrder(order);
        order.setIsCheckIn(1);
        checkInOrder.setReservedOrder(order);
        Hotelservice.checkInByCash(checkInOrder);
room=Hotelservice.getRoom(room);
        room.setIsFull(1);
        room.setIsReserved(0);//已经入住了
        Hotelservice.editRoom(room);
        reservedOrderList=Hotelservice.getOrderList(hotel);
        return "CheckInOK";
    }

    public String ShowDeparture(){
checkInOrders=Hotelservice.getDepartureCheckInOrders(hotel);
        touristCheckInList=Hotelservice.getTouristCheckInList(hotel);
        return "ShowDeparture";
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
