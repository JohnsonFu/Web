package com.fulinhua.dao.impl;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.Member;
import com.fulinhua.bean.ReservedOrder;
import com.fulinhua.bean.Room;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.MemberDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class MemberDaoImpl extends BaseDao implements MemberDao{
    @Override
    public Member find ( String pid ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Member WHERE pid= ?";
        List list=sess.createQuery(hql).setString(0, pid).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            Member member  = (Member) list.get(0);
            tx.commit();
            sess.close();
            sf.close();
            return member;
        }
    }

    @Override
    public void insert ( Member member ) {
        try {
            super.insert(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update ( Member member ) {
        try {
            super.update(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Member findByIdAndPassword(Member member){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Member WHERE mid= ? AND password=?";
        List list=sess.createQuery(hql).setLong(0, member.getMid()).setString(1,member.getPassword()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            Member result = (Member) list.get(0);
            tx.commit();
            sess.close();
            sf.close();
            return result;
        }


    }

    @Override
    public List<Hotel> getHotels () {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Hotel ";
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
    public Hotel getSingleHotel ( Hotel hotel ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Hotel WHERE hid= ?";
        List list=sess.createQuery(hql).setLong(0, hotel.getHid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            Hotel member  = (Hotel) list.get(0);
            tx.commit();
            sess.close();
            sf.close();
            return member;
        }
    }

    @Override
    public Room getRoom ( Room room ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Room WHERE rid= ?";
        List list=sess.createQuery(hql).setLong(0, room.getRid()).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            Room member  = (Room) list.get(0);
            tx.commit();
            sess.close();
            sf.close();
            return member;
        }
    }

    @Override
    public void submitOrder ( ReservedOrder order ) {

        try {
            super.insert(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ReservedOrder> getReservedOrder ( Member member ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM ReservedOrder";
       // System.out.println("用户ID为"+member.getMid());
        List list = sess.createQuery(hql).list();
        if (list.size() == 0) {
            tx.commit();
            sess.close();
            sf.close();
            return null;
        } else {
            List temp=new ArrayList();
            for(int i=0;i<list.size();i++) {
               ReservedOrder order=(ReservedOrder)list.get(i);
                if(order.getMember().getMid()==member.getMid()){
                    temp.add(order);
                }
            }
            tx.commit();
            sess.close();
            sf.close();
            return temp;
        }
    }
}
