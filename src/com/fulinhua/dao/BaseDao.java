package com.fulinhua.dao;

import com.fulinhua.bean.Hotel;
import com.fulinhua.bean.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
	public void insert(T object) throws SQLException{
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

		// 保存消息
		sess.save(object);
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}

	public void update(T object) throws SQLException{
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
		sess.update(object);
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();


	}

//	public boolean IsExist(User user){
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//
//		String hql = "FROM User WHERE username = ? AND password = ?";
//		List<User>list = sess.createQuery(hql).setString(0, user.getUsername()).setString(1, user.getPassword()).list();
//
//		if(list.size()>0){
//			return true;
//		}else{
//			return false;
//		}
//	}

	public void Remove(T object){

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
		sess.delete(object);
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}


//	public void delete(String bookname) throws SQLException{
////		 PreparedStatement pstmt=null;
////			String sql="delete from booklist where name=?";
////			pstmt=this.con.prepareStatement(sql);
////			pstmt.setString(1,bookname);
////			pstmt.executeUpdate();
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//		// 创建消息实例
//
//		Query query = sess.createQuery("delete  Book b  where b.name=?");
//		query.setString(0, bookname);
//		query.executeUpdate();
//		// 提交事务
//		tx.commit();
//		// 关闭Session
//		sess.close();
//		sf.close();
//	}
//
//	public List<Book> getBooks() throws SQLException{
//		List<Book> list=new ArrayList<Book>();
//
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//		// 创建消息实例
//
//		Query query = sess.createQuery("from Book");
//		list = query.list();
//
//		// 提交事务
//		tx.commit();
//		// 关闭Session
//		sess.close();
//		sf.close();
//		return list;
//	}



    public List<T> find (Query  query) {
		List<T> list=new ArrayList<T>();
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

		//Query query = sess.createQuery("from "+name);
		list = query.list();

		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return list;

    }



//	public Member getMember (long id) {
//
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//		// 创建消息实例
//
//		String hql = "FROM Member WHERE mid = ?";
//		Member member =(Member)sess.createQuery(hql).setLong(0, id).list().get(0);
//
//		// 提交事务
//		tx.commit();
//		// 关闭Session
//		sess.close();
//		sf.close();
//		return member;
//
//	}
//
//
//	public void deleteCourse ( int id ) {
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//		// 创建消息实例
//
//		Query query = sess.createQuery("delete  Course b  where b.id=?");
//		query.setInteger(0, id);
//		query.executeUpdate();
//		// 提交事务
//		tx.commit();
//		// 关闭Session
//		sess.close();
//		sf.close();
//
//	}
//
//	public String isExistStudent (Student student) {
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//
//		String hql = "FROM Student WHERE id = ? AND password = ?";
//		List<Student>list = sess.createQuery(hql).setLong(0, student.getId()).setString(1, student.getPassword()).list();
//
//		if(list.size()>0){
//			ActionContext.getContext().getSession().put("student", list.get(0));
//			List<StudentCourse> mycourses=list.get(0).getCourses();
//			ActionContext.getContext().getSession().put("MyCourses",mycourses);
//			for(StudentCourse sc:mycourses){
//				if(!sc.isHasExam()){
//					return "warning";
//				}
//			}
//
//
//			return "normal";
//		}else{
//			return null;
//		}
//	}
//
    public void addRoom ( Hotel hotel, Room room ) {

		hotel.getRoomList().add(room);
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(sess.merge(hotel));
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
    }

	public void addRoom2 ( Hotel hotel, Room room ) {

		//hotel.getRoomList().add(room);
		room.setHotel(hotel);
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(sess.merge(room));

		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}




	public Hotel getHotel ( long id ) {
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
		List<Hotel>list = sess.createQuery(hql).setLong(0,id).list();
		Hotel temp=list.get(0);
		//List<StudentCourse> courselist=temp.getCourses();
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
		return temp;


	}

	public Room getRoom ( long id ) {
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();

		String hql = "FROM Room WHERE rid = ?";
		List<Room>list = sess.createQuery(hql).setLong(0,id).list();
		Room temp=list.get(0);
		//List<StudentCourse> courselist=temp.getCourses();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return temp;


	}

//
//	public List<StudentCourse> getMyCourses ( Student student ) {
//		Configuration conf = new Configuration()
//				// 下面方法默认加载hibernate.cfg.xml文件
//				.configure();
//		// 以Configuration创建SessionFactory
//		SessionFactory sf = conf.buildSessionFactory();
//		// 创建Session
//		Session sess = sf.openSession();
//		// 开始事务
//		Transaction tx = sess.beginTransaction();
//
//		String hql = "FROM Student WHERE id = ? AND password = ?";
//		List<Student>list = sess.createQuery(hql).setLong(0, student.getId()).setString(1, student.getPassword()).list();
//		Student temp=list.get(0);
//		List<StudentCourse> courselist=temp.getCourses();
//		return courselist;
//

	//}
}