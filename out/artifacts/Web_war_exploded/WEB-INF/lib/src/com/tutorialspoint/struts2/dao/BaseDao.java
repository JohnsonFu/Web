package com.tutorialspoint.struts2.dao;

import com.opensymphony.xwork2.ActionContext;
import com.tutorialspoint.homework.bean.Course;
import com.tutorialspoint.homework.bean.Student;
import com.tutorialspoint.homework.bean.StudentCourse;
import com.tutorialspoint.struts2.action.Book;
import com.tutorialspoint.struts2.action.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
	public void add(T object) throws SQLException{
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
//		 PreparedStatement pstmt=null;
//			String sql="update  booklist set author=?,price=?  where name=?";
//			pstmt=this.con.prepareStatement(sql);
//			pstmt.setString(1,book.getAuthor());
//			pstmt.setDouble(2,book.getPrice());
//			pstmt.setString(3,book.getName());
//			pstmt.executeUpdate();
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

	public boolean IsExist(User user){
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();

		String hql = "FROM User WHERE username = ? AND password = ?";
		List<User>list = sess.createQuery(hql).setString(0, user.getUsername()).setString(1, user.getPassword()).list();

		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

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


	public void delete(String bookname) throws SQLException{
//		 PreparedStatement pstmt=null;
//			String sql="delete from booklist where name=?";
//			pstmt=this.con.prepareStatement(sql);
//			pstmt.setString(1,bookname);
//			pstmt.executeUpdate();
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

		Query query = sess.createQuery("delete  Book b  where b.name=?");
		query.setString(0, bookname);
		query.executeUpdate();
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}

	public List<Book> getBooks() throws SQLException{
		List<Book> list=new ArrayList<Book>();
//		 PreparedStatement pstmt=null;
//			String sql="select * from booklist";
//			pstmt=this.con.prepareStatement(sql);
//			ResultSet result=pstmt.executeQuery();
//		while(result.next()){
//			Book book=new Book(result.getString("name"),result.getString("author"),result.getDouble("price"));
//			list.add(book);
//		}
//		return list;

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

		Query query = sess.createQuery("from Book");
		list = query.list();

		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return list;
	}


    public List<T> getList (String name) {
		List<T> list=new ArrayList<T>();
//		 PreparedStatement pstmt=null;
//			String sql="select * from booklist";
//			pstmt=this.con.prepareStatement(sql);
//			ResultSet result=pstmt.executeQuery();
//		while(result.next()){
//			Book book=new Book(result.getString("name"),result.getString("author"),result.getDouble("price"));
//			list.add(book);
//		}
//		return list;

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

		Query query = sess.createQuery("from "+name);
		list = query.list();

		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return list;

    }

	public void deleteCourse ( int id ) {
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

		Query query = sess.createQuery("delete  Course b  where b.id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();

	}

	public String isExistStudent (Student student) {
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();

		String hql = "FROM Student WHERE id = ? AND password = ?";
		List<Student>list = sess.createQuery(hql).setLong(0, student.getId()).setString(1, student.getPassword()).list();

		if(list.size()>0){
			ActionContext.getContext().getSession().put("student", list.get(0));
			List<StudentCourse> mycourses=list.get(0).getCourses();
			ActionContext.getContext().getSession().put("MyCourses",mycourses);
			for(StudentCourse sc:mycourses){
				if(!sc.isHasExam()){
					return "warning";
				}
			}


			return "normal";
		}else{
			return null;
		}
	}

    public void addCourse ( Student student, Course course ) {
		StudentCourse sc=new StudentCourse();
		sc.setCourseid(course.getId());
		sc.setName(course.getName());
		sc.setHasExam(false);
		student.getCourses().add(sc);
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(sess.merge(student));
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
    }

	public List<StudentCourse> getMyCourses ( Student student ) {
		Configuration conf = new Configuration()
				// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();

		String hql = "FROM Student WHERE id = ? AND password = ?";
		List<Student>list = sess.createQuery(hql).setLong(0, student.getId()).setString(1, student.getPassword()).list();
		Student temp=list.get(0);
		List<StudentCourse> courselist=temp.getCourses();
		return courselist;


	}
}