package com.fulinhua.dao.impl;

import com.fulinhua.bean.Member;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.MemberDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
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
}
