package com.fulinhua.dao.impl;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.Room;
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
}
