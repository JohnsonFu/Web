<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/11
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>学生登录</title>
</head>
<body>
<h1>学生登录</h1>
<s:form action="Student">
    <s:label value="学号">  </s:label><input type="text" name="student.id"/><br>
    <s:label value="密码">  </s:label><input type="password" name="student.password"/>
    <s:submit value="登录" method="login"></s:submit>
</s:form>
</body>
</html>