package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/2/26.
 */
public class CheckInOrder {
    public long getCid () {
        return cid;
    }

    public void setCid ( long cid ) {
        this.cid = cid;
    }

    private long cid;
    public ReservedOrder getReservedOrder () {
        return reservedOrder;
    }

    public void setReservedOrder ( ReservedOrder reservedOrder ) {
        this.reservedOrder = reservedOrder;
    }

    public String getCheckInTime () {
        return CheckInTime;
    }

    public void setCheckInTime ( String checkInTime ) {
        CheckInTime = checkInTime;
    }

    private ReservedOrder reservedOrder;//预订单
    private String CheckInTime;

    public int getHasSettle () {
        return hasSettle;
    }

    public void setHasSettle ( int hasSettle ) {
        this.hasSettle = hasSettle;
    }

    private int hasSettle;//是否支付



}
