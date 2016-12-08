package com.tutorialspoint.struts2.action;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {
public void createBook(Book book);
public List<Book> listBook() throws SQLException;
public void Remove(Book book);
public void update(Book book);
}
