<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/12
  Time: 18:33
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
<h1>登录</h1>
<h3>用户名<s:property value="member.name"></s:property></h3>
<s:iterator id="item" value="hotelList">
    <form action="Member.action">
    <s:property value='#item.name'/>&nbsp;&nbsp;
    <s:property value='#item.address'></s:property>
        <input type="hidden" name="hotel.hid" value=<s:property value='#item.hid'/>>
        <s:submit value="查看房间" method="showHotelRoom"></s:submit><br>
    </form>
</s:iterator>
    </div>
</body>

</html>