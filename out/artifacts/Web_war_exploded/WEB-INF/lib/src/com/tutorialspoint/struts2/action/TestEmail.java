package com.tutorialspoint.struts2.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEmail {
public static void main(String[] args){
	Person person=new Person();
	person.setName("傅林华	");
	
	person.getEmails().add("flh@yahoo.com");
	person.getEmails().add("flh@163.com");
	person.getEmails().add("flh@qq.com");
	 Configuration conf = new Configuration()  
		        // 下面方法默认加载hibernate.cfg.xml文件  
		                .configure();  
		        // 以Configuration创建SessionFactory  
		        SessionFactory sf = conf.buildSessionFactory();  
		        // 创建Session  
		        Session sess = sf.openSession();  
		        // 开始事务  
		        Transaction tx = sess.beginTransaction();  
		        sess.persist(person);
		        tx.commit();
		        sess.close();
}
}
