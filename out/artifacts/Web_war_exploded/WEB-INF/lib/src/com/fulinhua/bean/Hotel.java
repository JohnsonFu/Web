package com.fulinhua.bean;



import java.util.List;

/**
 * Created by fulinhua on 2017/1/11.
 */

public class Hotel {
    private long hid;
    private String name;
    private String address;
    private List<Room> roomList;

    public long getHid () {
        return hid;
    }

    public void setHid ( long hid ) {
        this.hid = hid;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public List<Room> getRoomList () {
        return roomList;
    }

    public void setRoomList ( List<Room> roomList ) {
        this.roomList = roomList;
    }
}
