<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/23
  Time: 10:49
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

    <s:iterator id="item" value="hotel.roomList">
        <s:if test="#item.isReleased>0">
            <form action="Member.action">
            <input type="hidden" name="room.rid" value=<s:property value='#item.rid'/>>
            房号:<s:property value='#item.roomNumber'/>&nbsp;&nbsp;<br>
           房型:<s:property value='#item.type'></s:property><br>
        价格:<s:property value="#item.price"></s:property><br>
        可预订时间:今日至<s:property value="#item.beforeTime"></s:property><br>
            <s:submit value="预定" method="FillOrder"></s:submit><br>
        </form>
        -------------
        <br>
        </s:if><s:else></s:else>

    </s:iterator>
</div>
</body>

</html>