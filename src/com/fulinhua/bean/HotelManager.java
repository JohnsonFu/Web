package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/2/22.
 */
public class HotelManager {
    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    private String username;
    private String password;
    private String name;
}
