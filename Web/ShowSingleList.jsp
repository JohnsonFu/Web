<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/27
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
    <title>酒店结算列表</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Project name</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
<br>
<br>
<div class="container" align="center">
    <h1>酒店结算</h1>
    <h2><s:property value="hotel.name"></s:property></h2>&nbsp;&nbsp;<h4>地址:<s:property value="hotel.address"></s:property></h4>
    <s:iterator id="item" value="checkInOrders">
        <tr>

                <th>入住时间:<s:property value='#item.checkInTime'></s:property> </th><br>
                <th>入住人:<s:property value='#item.reservedOrder.member.name'></s:property></th><br>
                <th>总金额:<s:property value='#item.reservedOrder.paymoney'></s:property></th><br>


            <br>

        </tr>
    </s:iterator>
</div>
</body>
</html>