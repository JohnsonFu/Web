<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/11
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
学号:<s:property value="#session.student.id"/>-----
姓名:<s:property value="#session.student.name"/><br>


登陆成功!
</body>
</html>
