<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/23
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
    <title></title>
</head>
<body>
<div class="container" align="center">
    <h3>用户名<s:property value="member.name"></s:property><br>
        <s:property value="hotel.name"></s:property>&nbsp;<s:property value="hotel.address"></s:property>
    </h3>


            房号:<s:property value='room.roomNumber'/>&nbsp;&nbsp;<br>
            房型:<s:property value='room.type'></s:property><br>
            价格:<s:property value="room.price"></s:property><br>
            可预订时间:今日至<s:property value="room.beforeTime"></s:property><br>

        -------------
</div>
</body>

</html>
