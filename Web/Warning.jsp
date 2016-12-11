<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/11
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程警告页面</title>
</head>
<body>
<a href="#">添加课程</a>
<a href="#">课程列表</a>
<table border="1">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>状态</th>
    </tr>
    <s:iterator id="item" value="myCourses">
        <tr>
            <s:form action="Student">
                <th><input type="hidden" name="course.id" value=<s:property value="#item.id" />>${item.id}</th>
                <th><input type="hidden" name="course.name" value=<s:property  value='#item.name'/>>${item.name}</th>
                <s:if test="#item.hasExam==false"><th style="color:red;">未测验</th></s:if><s:else><th>已测验</th></s:else>
            </s:form>
        </tr>
    </s:iterator>
</table>
</body>
</html>