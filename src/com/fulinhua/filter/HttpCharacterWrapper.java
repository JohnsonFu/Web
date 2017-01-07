package com.fulinhua.filter;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HttpCharacterWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter CharWriter=new CharArrayWriter();
	public HttpCharacterWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}
	@Override
	public PrintWriter getWriter(){
		return new PrintWriter(CharWriter);
	}
	public CharArrayWriter getCharArrayWriter(){
		return this.CharWriter;
	}

}
