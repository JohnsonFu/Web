<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/1/6
  Time: 22:27
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
    <form action="MemberRegist">
        账号:<s:textfield name="member.name"></s:textfield><br>
        密码:<s:password name="member.password"></s:password><br>
        身份证号:<s:password name="member.pid"></s:password><br>
        <s:submit value="注册" method="MemberRegist"></s:submit>
    </form>
</head>
<body>

</body>
</html>