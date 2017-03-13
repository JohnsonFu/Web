package com.fulinhua.filter;


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
System.out.println("权限验证器打开");
    }

    @Override
    public void doFilter ( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
     HttpServletRequest request=(HttpServletRequest)servletRequest;
        String requestURI=request.getRequestURI().replace(request.getContextPath()+"/","");
        String auth=(String)request.getSession().getAttribute("auth");
        ArrayList<String> memberlist=new ArrayList<String>();//用户权限
        memberlist.add("HotelLogin.jsp");
       memberlist.add("ManagerLogin.jsp");
        ArrayList<String> managerlist=new ArrayList<String>();//管理员权限
        managerlist.add("MemberLogin.jsp");
        managerlist.add("HotelLogin.jsp");
        ArrayList<String> hotellist=new ArrayList<String>();//管理员权限
        hotellist.add("MemberLogin.jsp");
        hotellist.add("ManagerLogin.jsp");
      if(auth=="member"&&(memberlist.contains(requestURI))){
            throw new RuntimeException(new AccountException("您无权访问该页面，请以退出用户账号后访问该页面"));
        }
        if(auth=="manager"&&(managerlist.contains(requestURI))){
            throw new RuntimeException(new AccountException("您无权访问该页面，请以退出管理员账号后访问该页面"));
        }
        if(auth=="hotel"&&(hotellist.contains(requestURI))){
            throw new RuntimeException(new AccountException("您无权访问该页面，请以退出酒店账号后访问该页面"));
        }
        filterChain.doFilter(servletRequest,servletResponse);
   }

    @Override
    public void destroy () {

    }
}
