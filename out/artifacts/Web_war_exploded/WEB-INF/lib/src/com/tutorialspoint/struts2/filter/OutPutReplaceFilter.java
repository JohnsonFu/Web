package com.tutorialspoint.struts2.filter;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class OutPutReplaceFilter implements Filter {
	private Properties pp=new Properties();
    public void init(FilterConfig config){
    	String file=config.getInitParameter("file");
    	String realPath=config.getServletContext().getRealPath(file);
    	try {
			pp.load(new FileInputStream(realPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpCharacterWrapper response=new HttpCharacterWrapper((HttpServletResponse) res);
		chain.doFilter(req, response);
		String output=response.getCharArrayWriter().toString();
		for(Object obj:pp.keySet()){
			String key=(String) obj;
			output=output.replace(key, pp.getProperty(key));
		}
		PrintWriter out=res.getWriter();
		out.write(output);
	}
	public void destroy(){
		//System.out.println("过滤器销毁");
	}

}
