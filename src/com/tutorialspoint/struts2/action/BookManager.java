package com.tutorialspoint.struts2.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

public class BookManager {
	@SuppressWarnings("deprecation")  
    public static void main(String[] args) throws Exception {  
        // 实例化Configuration，  
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
        Book n = new Book();  
        // 设置消息标题和消息内容  
        n.setName("语文书");  
        n.setAuthor("够够够");
        n.setPrice(99);  
        // 保存消息  
        sess.save(n);  
        // 提交事务  
        tx.commit();  
        // 关闭Session  
        sess.close();  
        sf.close();  
    }  
}
