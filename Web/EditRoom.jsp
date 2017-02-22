<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/22
  Time: 17:10
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
    <title>发布房间</title>
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
   <form action="Hotel.action" onsubmit="computeTime()">
    房间号:<s:property value="room.roomNumber"></s:property><br>
    房间类型:<select name="room.type" id="type" onchange="showPrice()">
        <option value ="普通单人房">普通单人房</option>
        <option value ="豪华单人房">豪华单人房</option>
        <option value="普通大床房">普通大床房</option>
        <option value="豪华大床房">豪华大床房</option>
    <option value="总统套房">总统套房</option>
    </select><br>
    房间定价:<input type="text" name="room.price" id="price"  placeholder="300" ><br>
    开放预订天数:<input type="hidden" name="room.beforeTime" id="ddl">
       <select  id="time" >
           <option value ="1">1</option>
           <option value ="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
           <option value="5">5</option>
           <option value="6">6</option>
           <option value="7">7</option>
           <option value="8">8</option>
           <option value="9">9</option>
           <option value="10">10</option>
           <option value="11">11</option>
           <option value="12">12</option>
           <option value="13">13</option>
           <option value="14">14</option>
           <option value="15">15</option>
       </select>
       <br>
       <s:submit value="发布" method="EditOver"></s:submit>
</form>
</div>
</div>
<script type="text/javascript">

    function computeTime(){
      var today=new Date();
        today.setDate(today.getDate()+document.getElementById('time').value);
        var time=today.getFullYear()+"-"+today.getMonth()+1+"-"+today.getDate()+" "+today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
        document.getElementById("ddl").value=time;
    }



    function showPrice(){
var type=document.getElementById('type').value
        if(type=='普通单人房'){
            document.getElementById("price").value=350;
        }
        if(type=='豪华单人房'){
            document.getElementById("price").value=400;
        }
        if(type=='普通大床房'){
            document.getElementById("price").value=500;
        }
        if(type=='豪华大床房'){
            document.getElementById("price").value=550;
        }
        if(type=='总统套房'){
            document.getElementById("price").value=700;
        }
    }
</script>
</body>
</html>