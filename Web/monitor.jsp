<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5">
<title>在线用户监控</title>
</head>
<body>
在线用户数量为<s:property  value="#application.onlinecount" /><br>
用户列表为<br>
<s:iterator id="item" value="#application.users">
<s:property value="#item"/><br>
</s:iterator>
</body>
</html>