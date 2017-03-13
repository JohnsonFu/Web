<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/22
  Time: 16:39
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
    <title>发布计划</title>
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
<div class="col-sm-2 col-lg-2">
    <div class="sidebar-nav">
        <div class="nav-canvas">
            <div class="nav-sm nav nav-stacked">

            </div>
            <ul class="nav nav-pills nav-stacked main-menu">
                <li class="nav-header">Main</li>
                <li><a class="ajax-link" href="Hotel.action?method%3AbackToHomePage"><i class="glyphicon glyphicon-home"></i><span> 主页</span></a>
                </li>
                <li><a class="ajax-link" href="Hotel.action?method%3AshowAdd"><i class="glyphicon glyphicon-plus-sign green"></i><span>添加房间</span></a>
                </li>
                <li><a class="ajax-link" href="Hotel.action?method%3AShowReserved"><i class="glyphicon glyphicon-circle-arrow-right yellow"></i><span>入住办理</span></a>
                </li>
                <li><a class="ajax-link" href="Hotel.action?method%3AShowDeparture"><i class="glyphicon glyphicon-circle-arrow-right red"></i><span>离店办理</span></a>
                </li>
                <li><a class="ajax-link" href="Hotel.action?method%3AShowBill"><i class="glyphicon glyphicon-folder-open blue"></i><span>查看业务信息</span></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<br>
<br>
<div class="container" align="center">
    <h1><s:property value="hotel.name"></s:property></h1>&nbsp;&nbsp;<h4>地址:<s:property value="hotel.address"></s:property></h4>
    空房间:<br>
    <s:iterator id="item" value="hotel.roomList">
    <s:if test="#item.isReleased<1 && #item.isFull<1">
        <form action="Hotel.action" method="post">
        <s:property value="#item.roomNumber"></s:property>
            <input type="hidden" name="room.rid" value=<s:property value='#item.rid'/>>
            <s:submit value="编辑" method="EditRoom"></s:submit>
            </form>
        <br>
        </s:if>
    </s:iterator>
</div>
</div>
</body>
</html>