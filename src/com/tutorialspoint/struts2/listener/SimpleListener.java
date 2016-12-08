package com.tutorialspoint.struts2.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.tutorialspoint.struts2.action.User;

public class SimpleListener implements HttpSessionAttributeListener{
Map<String,HttpSession> map=new HashMap<String,HttpSession>();
	public void attributeAdded(HttpSessionBindingEvent se){
		String name=se.getName();
		System.out.println(name);
	if(name.equals("user")){
		User user=(User)se.getValue();
		if(map.get(user.getUsername())!=null){
			HttpSession session=map.get(user.getUsername());
			User olduser=(User)session.getAttribute("user");
			System.out.println("账号"+olduser.getUsername()+"已经登陆了");
		}
		map.put(user.getUsername(), se.getSession());
		System.out.println("账号"+user.getUsername()+"登录");
	}
	}
	public void attributeRemoved(HttpSessionBindingEvent se){

	}
	public void attributeReplaced(HttpSessionBindingEvent se){

	}


}
