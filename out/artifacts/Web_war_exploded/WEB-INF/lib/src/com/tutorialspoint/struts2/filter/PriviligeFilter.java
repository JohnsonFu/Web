package com.tutorialspoint.struts2.filter;


import com.tutorialspoint.struts2.action.User;

import javax.security.auth.login.AccountException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/9.
 */
public class PriviligeFilter implements Filter {
    @Override
    public void init ( FilterConfig filterConfig ) throws ServletException {

    }

    @Override
    public void doFilter ( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
     HttpServletRequest request=(HttpServletRequest)servletRequest;
        String requestURI=request.getRequestURI().replace(request.getContextPath()+"/","");
        User user=(User)request.getSession().getAttribute("user");
        ArrayList<String> authlist=new ArrayList<String>();
        authlist.add("usershow.jsp");
        authlist.add("shopcar.jsp");
        if(user==null&&(authlist.contains(requestURI))){
            throw new RuntimeException(new AccountException("您无权访问该页面，请以合适的身份登陆后查看"));
        }
        System.out.println("requestURI为"+requestURI);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy () {

    }
}
