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


    public int getIsReleased () {
        return isReleased;
    }

    public void setIsReleased ( int isReleased ) {
        this.isReleased = isReleased;
    }

    public int isReleased;

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    private Hotel hotel;
    private double price;

    public int getIsFull () {
        return isFull;
    }

    public void setIsFull ( int isFull ) {
        this.isFull = isFull;
    }

    private int isFull;
    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }


    public String getBeforeTime () {
        return beforeTime;
    }

    public void setBeforeTime ( String beforeTime ) {
        this.beforeTime = beforeTime;
    }

    public String beforeTime;//可以订房的截至日期

    private String type;

}
