package com.fulinhua.listener;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SimpleListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded ( HttpSessionBindingEvent httpSessionBindingEvent ) {

	}

	@Override
	public void attributeRemoved ( HttpSessionBindingEvent httpSessionBindingEvent ) {

	}

	@Override
	public void attributeReplaced ( HttpSessionBindingEvent httpSessionBindingEvent ) {

	}
//Map<String,HttpSession> map=new HashMap<String,HttpSession>();
//	public void attributeAdded(HttpSessionBindingEvent se){
//		String name=se.getName();
//		System.out.println(name);
//	if(name.equals("user")){
//		User user=(User)se.getValue();
//		if(map.get(user.getUsername())!=null){
//			HttpSession session=map.get(user.getUsername());
//			User olduser=(User)session.getAttribute("user");
//			session.removeAttribute("user");
//			session.setAttribute("msg","您的账号"+olduser.getUsername()+"在别处登录，你已被迫下线");
//		}
//		map.put(user.getUsername(), se.getSession());
//		System.out.println("账号"+user.getUsername()+"登录");
//	}
//	}
//	public void attributeRemoved(HttpSessionBindingEvent se){
//
//	}
//	public void attributeReplaced(HttpSessionBindingEvent se){
//
//		String name=se.getName();
//		System.out.println(name);
//		if(name.equals("user")){
//			User olduser=(User)se.getValue();
//			map.remove(olduser.getUsername());
//			User user=(User)se.getSession().getAttribute("user");
//			if(map.get(user.getUsername())!=null){
//				HttpSession session=map.get(user.getUsername());
//				session.removeAttribute("user");
//				session.setAttribute("msg","您的账号"+olduser.getUsername()+"在别处登录，你已被迫下线");
//			}
//			map.put(user.getUsername(), se.getSession());
//			System.out.println("账号"+user.getUsername()+"登录");
//		}
//
//	}


}
