<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/3/1
  Time: 15:45
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
    <title>离店办理</title>
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
    <h1><s:property value="hotel.name"></s:property></h1>&nbsp;&nbsp;<h4>地址:<s:property value="hotel.address"></s:property></h4>
    <s:iterator id="item" value="checkInOrders">
<form action="Hotel.action">
            姓名<s:property value="#item.reservedOrder.member.name"></s:property><br>
            身份证号<s:property value="#item.reservedOrder.personID"></s:property><br>
            入住时间<s:property value="#item.checkInTime"></s:property><br>
    <input type="hidden" name="checkInOrder.cid" value=<s:property value="#item.cid"></s:property>>
    <s:submit value="办理离店" method="Departure"></s:submit>
    </form>
        -----------<br>
    </s:iterator>
</div>
</body>
</html>
