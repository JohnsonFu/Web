<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/9
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
    <title>用户注册</title>
    <s:label>用户注册</s:label>
    <form action="user">
        账号:<s:textfield name="user.username"></s:textfield><br>
        密码:<s:password name="user.password"></s:password><br>
        <s:submit value="注册" method="regist"></s:submit>
    </form>
</head>
<body>

</body>
</html>
