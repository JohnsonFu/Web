package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/1/11.
 */
public class Room {
    private long rid;
    private int roomNumber;


    public long getRid () {
        return rid;
    }

    public void setRid ( long rid ) {
        this.rid = rid;
    }

    public int getRoomNumber () {
        return roomNumber;
    }

    public void setRoomNumber ( int roomNumber ) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType () {
        return roomType;
    }

    public void setRoomType ( RoomType roomType ) {
        this.roomType = roomType;
    }

    private RoomType roomType;

    public Hotel getHotel () {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    private Hotel hotel;

}
