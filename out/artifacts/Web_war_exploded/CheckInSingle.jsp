<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/28
  Time: 19:46
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
    <title>办理入住</title>
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

        <s:form action="Hotel">
            姓名<s:property value="order.name"></s:property><br>
            身份证号<s:property value="order.personID"></s:property><br>
            <input type="hidden"  id="rightID" value=<s:property value="order.personID"></s:property>/>
            入住时间<s:property value="order.days"></s:property><br>
            金额<s:property value="order.paymoney"></s:property><br>
            房号<s:property value="order.roomNumber"></s:property><br>
            <input type="hidden" name="order.orderID" value=<s:property value="order.orderID"/>>
            <input type="hidden" name="room.rid" value=<s:property value="order.roomID"/>>
            <s:submit value="会员卡支付" method="CheckInByCard"></s:submit>
            <s:submit value="现金支付" method="CheckInByCash"></s:submit>
        </s:form>
        -----------<br>

</div>
<script type="text/javascript">

</script>
</body>
</html>
