package com.fulinhua.dao.impl;

import com.fulinhua.bean.*;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.HotelDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2017/2/21.
 */
public class HotelDaoImpl extends BaseDao implements HotelDao {
    @Override
    public void sendRegist ( Hotel hotel ) {
        try {
            super.insert(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hotel findByIdAndPassword ( Hotel hotel ) {
            Configuration conf = new Configuration().configure();
            SessionFactory sf = conf.buildSessionFactory();
            Session sess = sf.openSession();
            Transaction tx = sess.beginTransaction();
            String hql = "FROM Hotel WHERE username= ? AND password=?";
            List list=sess.createQuery(hql).setString(0, hotel.getUsername()).setString(1,hotel.getPassword()).list();
            if(list.size()==0){
                tx.commit();
                sess.close();
                sf.close();
                return null;
            }else {
                Hotel result = (Hotel) list.get(0);
                tx.commit();
                sess.close();
                sf.close();
                return result;
            }



    }

    @Override
    public void addRoom ( Room room ) {
        try {
            super.insert(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room getRoom ( Room room ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Room WHERE rid=?";
        List list=sess.createQuery(hql).setLong(0, room.getRid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            Room result = (Room) list.get(0);
            tx.commit();
            sess.close();
            sf.close();
            return result;
        }


    }



    @Override
    public void update ( Room room ) {
        try {
            super.update(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ReservedOrder> getOrderList ( Hotel hotel ) {
         Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM ReservedOrder WHERE hotel.hid=? AND isCheckIn=0";
        List list=sess.createQuery(hql).setLong(0, hotel.getHid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            tx.commit();
            sess.close();
            sf.close();
            return list;
        }
    }

    @Override
    public void submitCheckIn ( CheckInOrder checkInOrder ) {
        try {
            super.insert(checkInOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ReservedOrder getReservedOrder ( ReservedOrder order ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM ReservedOrder WHERE orderID=?";
        List list=sess.createQuery(hql).setLong(0, order.getOrderID()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            tx.commit();
            sess.close();
            sf.close();
            return (ReservedOrder)list.get(0);
        }
    }

    @Override
    public List<ReservedOrder> getHotelReservedOrders ( Hotel hotel ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM ReservedOrder WHERE hotel.hid=?";
        List list=sess.createQuery(hql).setLong(0, hotel.getHid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            tx.commit();
            sess.close();
            sf.close();
            return list;
        }
    }

    @Override
    public List<CheckInOrder> getHotelCheckInOrders ( Hotel hotel ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM CheckInOrder WHERE reservedOrder.hotel.hid= ?";
        List list=sess.createQuery(hql).setLong(0, hotel.getHid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {

            tx.commit();
            sess.close();
            sf.close();
            return list;
        }
    }

    @Override
    public void UpdateHotel ( Hotel hotel ) {
        try {
            super.update(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CheckInOrder> getDepartureCheckInOrders ( Hotel hotel ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM CheckInOrder WHERE reservedOrder.hotel.hid=? and hasDepart=0";
        List list=sess.createQuery(hql).setLong(0, hotel.getHid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            tx.commit();
            sess.close();
            sf.close();
            return list;
        }
    }

    @Override
    public CheckInOrder getCheckInOrderById ( CheckInOrder checkInOrder ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM CheckInOrder WHERE cid=?";
        List list=sess.createQuery(hql).setLong(0, checkInOrder.getCid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            tx.commit();
            sess.close();
            sf.close();
            return (CheckInOrder)list.get(0);
        }
    }

    @Override
    public void updateChcekIn ( CheckInOrder checkInOrder ) {
        try {
            super.update(checkInOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hotel getHotelById ( Hotel hotel ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Hotel WHERE hid=?";
        Hotel result=(Hotel)sess.createQuery(hql).setLong(0, hotel.getHid()).uniqueResult();
        if(result==null){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {

            tx.commit();
            sess.close();
            sf.close();
            return result;
        }
    }

    @Override
    public void updateHotel ( Hotel hotel ) {
        try {
            super.update(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTouristCheckIn ( TouristCheckIn touristCheckIn ) {
        try {
            super.insert(touristCheckIn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
