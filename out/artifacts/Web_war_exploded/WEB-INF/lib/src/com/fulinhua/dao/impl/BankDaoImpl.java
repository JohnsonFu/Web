package com.fulinhua.dao.impl;

import com.fulinhua.bean.BankAccount;
import com.fulinhua.dao.BankDao;
import com.fulinhua.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class BankDaoImpl extends BaseDao implements BankDao {


@Override
    public BankAccount find ( long  id) {
        Configuration conf = new Configuration()
                // 下面方法默认加载hibernate.cfg.xml文件
                .configure();
        // 以Configuration创建SessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        // 创建Session
        Session sess = sf.openSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();
        // 创建消息实例
        String hql = "FROM BankAccount WHERE BankID= ?";
        List list=sess.createQuery(hql).setLong(0, id).list();
        if(list.size()==0){
            tx.commit();
            // 关闭Session
            sess.close();
            sf.close();
            return null;
        }else {
            BankAccount bankAccount = (BankAccount) list.get(0);
            // 提交事务
            tx.commit();
            // 关闭Session
            sess.close();
            sf.close();
            return bankAccount;
        }
    }

    @Override
    public BankAccount findByIdAndPassword ( BankAccount account ) {
        Configuration conf = new Configuration()
                // 下面方法默认加载hibernate.cfg.xml文件
                .configure();
        // 以Configuration创建SessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        // 创建Session
        Session sess = sf.openSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();
        // 创建消息实例
        String hql = "FROM BankAccount WHERE BankID= ? AND password=?";
        List list=sess.createQuery(hql).setLong(0, account.getBankID()).setString(1,account.getPassword()).list();
        if(list.size()==0){
            tx.commit();
            // 关闭Session
            sess.close();
            sf.close();
            return null;
        }else {
            BankAccount bankAccount = (BankAccount) list.get(0);
            // 提交事务
            tx.commit();
            // 关闭Session
            sess.close();
            sf.close();
            return bankAccount;
        }
    }

    @Override
    public void update ( BankAccount bankAccount ) {
        try {
            super.update(bankAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
