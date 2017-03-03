package com.fulinhua.dao.impl;

import com.fulinhua.bean.CheckInOrder;
import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.HotelManager;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.HotelManageDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2017/2/22.
 */
public class HotelManageDaoImpl extends BaseDao implements HotelManageDao {
    @Override
    public void CheckRegist ( Hotel hotel ) {
        try {
            super.update(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HotelManager findByIdAndPassword ( HotelManager manager ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM HotelManager WHERE username= ? AND password=?";
        List list=sess.createQuery(hql).setString(0, manager.getUsername()).setString(1,manager.getPassword()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            HotelManager result = (HotelManager) list.get(0);
            tx.commit();
            sess.close();
            sf.close();
            return result;
        }

    }

    @Override
    public List<Hotel> getUncheckHotels () {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Hotel where isApprove=0";
        List list=sess.createQuery(hql).list();
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
    public void agree ( Hotel hotel ) {
        Configuration conf = new Configuration()
                // 下面方法默认加载hibernate.cfg.xml文件
                .configure();
        // 以Configuration创建SessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        // 创建Session
        Session sess = sf.openSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();

        String hql = "FROM Hotel WHERE hid = ?";
        List<Hotel>list = sess.createQuery(hql).setLong(0,hotel.getHid()).list();
        tx.commit();
        // 关闭Session
        sess.close();
        sf.close();
         hotel=list.get(0);
        hotel.setIsApprove(1);
        try {
            super.update(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> getAllHotels () {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Hotel";
        List list=sess.createQuery(hql).list();
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
    public List<CheckInOrder> getCheckIn ( Hotel hotel ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM CheckInOrder where reservedOrder.hotel.hid=? and hasSettle=0";
        List list=sess.createQuery(hql).setLong(0,hotel.getHid()).list();
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
    public void update ( Hotel hotel ,double money) {

        double premoney=hotel.getBalance();
        hotel.setBalance(premoney+money);
        System.out.println(hotel.getBalance());
        try {
            super.update(hotel);
            System.out.println(hotel.getBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void settle ( List<CheckInOrder> checkInOrders ) {
        for(int i=0;i<checkInOrders.size();i++){
            CheckInOrder order=checkInOrders.get(i);
            order.setHasSettle(1);
            try {
                super.update(order);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
