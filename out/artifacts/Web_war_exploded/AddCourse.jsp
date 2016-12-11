<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/11
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加课程</title>
</head>
<body>
<a href="#">课程书籍</a>
<a href="showCourselist.action">课程列表</a>
<s:form action="Teacher">
    <s:label>添加课程</s:label><br>
    <label>课程名</label><input type="text" name="course.name" /><br>
    <s:submit value="添加" method="addCourse"></s:submit>
</s:form>
</body>
</html>
