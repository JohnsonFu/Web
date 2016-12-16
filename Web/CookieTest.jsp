<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/12
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
request.setCharacterEncoding("UTF-8");
    String username="";
    int visitcount=0;
    Cookie[] cookies=request.getCookies();
    for(int i=0;i<cookies.length&&cookies!=null;i++){
        Cookie cookie=cookies[i];
        if("username".equals(cookie.getName())){
            username=cookie.getValue();
        }
        else if("visitcount".equals(cookie.getName())){
            visitcount=Integer.parseInt(cookie.getValue());
        }
    }
    Cookie count=new Cookie("visitcount",Integer.toString(++visitcount));
    response.addCookie(count);
%>
<html>
<head>
    <title>欢迎登陆</title>
</head>
<body>
您的账号<%=username%><br>
登陆次数<%=visitcount%>
</body>
</html>
