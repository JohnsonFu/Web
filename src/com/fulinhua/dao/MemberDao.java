package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.Member;
import com.fulinhua.bean.Room;

import java.util.List;

/**
 * Created by fulinhua on 2017/1/6.
 */
public interface MemberDao {
    public Member find ( String  pid);
    public void insert(Member member);
    public void update(Member member);
    public Member findByIdAndPassword(Member member);
    public List<Hotel> getHotels ();
    public Hotel getSingleHotel ( Hotel hotel );
    public Room getRoom ( Room room );
}
