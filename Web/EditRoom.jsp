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

<head>
    <!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
    <meta charset="utf-8">
    <title>Free HTML5 Bootstrap Admin Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">

    <div class="navbar-inner">


        <!-- user dropdown starts -->
        <!-- user dropdown ends -->

        <!-- theme selector starts -->
        <!-- theme selector ends -->

        <ul class="collapse navbar-collapse nav navbar-nav top-menu">
            <li><a href="#"><i class="glyphicon glyphicon-globe"></i>HostelWorld</a></li>
            <li>
            </li>
        </ul>
    </div>
</div>
</div>
<!-- topbar ends -->
<div class="ch-container">
    <div class="row">

        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="#"><i class="glyphicon glyphicon-home"></i><span> 主页</span></a>
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
        <!--/span-->
        <!-- left menu ends -->



        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li><i class="glyphicon glyphicon-home blue"></i><span>发布房间</span></li>
                </ul>

            </div><h1>
            <s:property value="hotel.name"></s:property></h1>
            <h3>地址:<s:property value="hotel.address"></s:property></h3>


            <form action="Hotel.action" onsubmit="computeTime()">
                <label>房间号:</label><s:property value="room.roomNumber"></s:property><br>
                <label>房间类型:</label><select name="room.type" id="type" onchange="showPrice()">
                <option value ="普通单人房">普通单人房</option>
                <option value ="豪华单人房">豪华单人房</option>
                <option value="普通大床房">普通大床房</option>
                <option value="豪华大床房">豪华大床房</option>
                <option value="总统套房">总统套房</option>
            </select><br>
                <label>房间定价:</label><input type="text" class="form-control" name="room.price" id="price"  placeholder="350" ><br>
                <label>开放预订天数:</label><input type="hidden" name="room.beforeTime" id="ddl">
                <select  id="time" >
                    <option value ="5">5</option>
                    <option value ="10">10</option>
                    <option value="15">15</option>
                    <option value="20">20</option>
                    <option value="25">25</option>
                    <option value="30">30</option>
                </select>
                <br>
                <s:submit value="发布" cssClass="btn btn-default" method="EditOver"></s:submit>
            </form>


        </div>
    </div>

</div><!--/.fluid-container-->

<script type="text/javascript">

    function computeTime(){
        var today=new Date();

        today.setDate(today.getDate()+parseInt(document.getElementById('time').value));
        var day=today.getDate();
        var month=today.getMonth()+1;
        var time=today.getFullYear()+"-"+month+"-"+day;
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

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>