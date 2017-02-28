<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/28
  Time: 10:26
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
    <h1>个人业务信息</h1>
    <h3>用户名<s:property value="member.name"></s:property></h3>
    预订单信息:<br>
    <s:iterator id="item" value="reservedOrders">
        酒店名:<s:property value='#item.hotel.name'/>&nbsp;&nbsp;
           房间类型:<s:property value='#item.RoomType'></s:property>&nbsp;&nbsp;
        所付金额:<s:property value='#item.paymoney'></s:property>&nbsp;&nbsp;
            <br>
    </s:iterator>

   入住单信息:<br>
    <s:iterator id="item" value="checkInOrders">
        酒店名:<s:property value='#item.reservedOrder.hotel.name'/>&nbsp;&nbsp;
        房间类型:<s:property value='#item.reservedOrder.RoomType'></s:property>&nbsp;&nbsp;
        所付金额:<s:property value='#item.reservedOrder.paymoney'></s:property>&nbsp;&nbsp;
        入住时间:<s:property value='#item.checkInTime'></s:property>
        <br>
    </s:iterator>

</div>
</body>

</html>