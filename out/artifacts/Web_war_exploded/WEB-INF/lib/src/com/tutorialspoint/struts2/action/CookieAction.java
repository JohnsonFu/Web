package com.tutorialspoint.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class CookieAction extends ActionSupport {
    private User user=new User();
    private UserService service=new UserServiceImpl();

    public User getUser () {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public UserService getService () {
        return service;
    }

    public void setService ( UserService service ) {
        this.service = service;
    }

    public String login() throws Exception{
        if(service.login(user)){
           HttpServletRequest request= ServletActionContext.getRequest();
            HttpServletResponse response=ServletActionContext.getResponse();
            ActionContext.getContext().getSession().put("user",user);
           Cookie usercookie=new Cookie("username",user.getUsername());
            Cookie visitcount=new Cookie("visitcount","0");
            response.addCookie(usercookie);
            response.addCookie(visitcount);
            return "CookieTest";
        }
        return "fail";
    }
}
