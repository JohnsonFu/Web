package com.tutorialspoint.struts2.action;

import java.sql.SQLException;
import java.util.List;

import com.tutorialspoint.struts2.dao.BaseDao;

public class IBookServiceImpl implements IBookService{
	private BaseDao dao;
	
	public void createBook(Book book){
	try {
		dao.add(book);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void Remove(Book book){
		dao.Remove(book);
	}
	
	public List<Book> listBook() throws SQLException{
		
		return dao.getBooks();
	}


	public BaseDao getDao() {
		return dao;
	}


	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		try {
			this.dao.update(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
