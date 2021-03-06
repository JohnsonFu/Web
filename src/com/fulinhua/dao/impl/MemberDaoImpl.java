package com.fulinhua.dao.impl;

import com.fulinhua.bean.*;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.MemberDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public List<CheckInOrder> getCheckInOrder ( Member member ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM CheckInOrder WHERE reservedOrder.member.mid= ?";
        List list=sess.createQuery(hql).setLong(0, member.getMid()).list();
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
    public Member getRegistMember () {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "select max(m.mid) from Member m";
        List list=sess.createQuery(hql).list();
        if(list.size()==0){
            tx.commit();
            sess.close();
            sf.close();
            return null;
        }else {
            Long id  = (Long) list.get(0);
            tx.commit();
            sess.close();
            sf.close();

            return this.getByMid(id);
        }
    }

    @Override
    public List<Member> getAllMember () {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "from Member";
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
    public ReservedOrder getOrderById ( ReservedOrder order ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "from ReservedOrder where orderID=?";
        List list=sess.createQuery(hql).setLong(0,order.getOrderID()).list();
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
    public void delete ( ReservedOrder order ) {
        super.Remove(order);
    }


    public Member getByMid ( long mid ) {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM Member WHERE mid= ?";
        List list=sess.createQuery(hql).setLong(0, mid).list();
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

    public void CheckAllMemberQuality () {
        List<Member> memberList=this.getAllMember();
        System.out.println("用户人数为"+memberList.size());
        for (Member member:memberList) {
            if(member.getIsActive()==1) {//已激活
                Date date = member.getActivedate();
                Date nowtime = new Date();
                long minutes = (nowtime.getTime() - date.getTime()) / (1000 * 60);
                System.out.println("当前账户信息"+member.getName()+"时间"+minutes+"分钟");
                if (minutes > 525600&&member.getBalance()<1000) {//过去了一年并且金额已经不足1000
                    member.setIsActive(0);
                    this.update(member);
                }
            }
            if(member.getIsActive()==0&&member.getBankAccount()!=null){//被停止了
                Date date = member.getActivedate();
                Date nowtime = new Date();
                long minutes = (nowtime.getTime() - date.getTime()) / (1000 * 60);
                if(member.getBalance()>=1000&&minutes<1051200){//充值了
                    member.setActivedate(new Date());//重新设置激活时间
                    member.setIsActive(1);//激活
                    this.update(member);
                }
                if(member.getBalance()<1000&&minutes>1051200) {//失效一年后仍未充值
                    member.setPassword("yourqualityisgooff");
                    this.update(member);
                }
            }
        }
    }

}
