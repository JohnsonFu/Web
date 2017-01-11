package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/1/11.
 */
public enum RoomType {
    普通单人房(300),豪华单人房(350),普通大床房(400),豪华大床房(450),总统套房(500);

    public double getPrice () {
        return price;
    }

    private double price;
    private RoomType(double price){
        this.price=price;
    }
}
