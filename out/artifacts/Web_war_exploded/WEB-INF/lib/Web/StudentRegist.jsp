<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/11
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
    <title>学生注册</title>
    <s:label>学生注册</s:label>
    <form action="Student">
        学号:<s:textfield name="student.id"></s:textfield><br>
        姓名:<s:textfield name="student.name"></s:textfield><br>
        密码:<s:password name="student.password"></s:password><br>
        <s:submit value="注册" method="regist"></s:submit>
    </form>
</head>
<body>

</body>
</html>
