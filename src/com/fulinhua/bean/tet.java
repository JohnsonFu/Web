package com.fulinhua.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2017/1/11.
 */
public class tet {
    public static void  main(String[] args) throws SQLException {


        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "FROM CheckInOrder WHERE cid=8";
        List list=sess.createQuery(hql).list();
        tx.commit();
            sess.close();
            sf.close();
        CheckInOrder order= (CheckInOrder) list.get(0);
       System.out.print(order.getReservedOrder().getMember().getName());


         }
}
