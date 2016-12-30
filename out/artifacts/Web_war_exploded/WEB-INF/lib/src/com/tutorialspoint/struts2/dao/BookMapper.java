package com.tutorialspoint.struts2.dao;


import com.tutorialspoint.struts2.action.Book;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/30.
 */
public interface BookMapper {
    public Book getBook ( int bookid );

    public Book getBookAndClass ( String studentID );

    public List<Book> getAllBook ();

    public void insertBook ( Book entity );

    public void deleteBook ( Book entity );
    public int RemoveById ( int id );

    public int updateBook ( Book entity );
}
