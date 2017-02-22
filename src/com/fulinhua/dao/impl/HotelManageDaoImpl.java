package com.fulinhua.dao.impl;

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
}
