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
        <!--/span-->
        <!-- left menu ends -->



        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <h1>
                <s:property value="hotel.name"></s:property></h1>
            <h3>地址:<s:property value="hotel.address"></s:property></h3>




            <div class="box-inner">
                <div class="box-header well" data-original-title="">
                    <h2><i class="glyphicon glyphicon-circle-arrow-right yellow"></i>办理入住</h2>

                    <div class="box-icon">
                        <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                class="glyphicon glyphicon-chevron-up"></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default"><i
                                class="glyphicon glyphicon-remove"></i></a>
                    </div>
                </div>
                <div class="box-content">

                    <form action="Hotel.action" onsubmit="return CheckMoney()">
                        <label>姓名:<s:property value="order.name"></s:property></label><br>
                        <label>身份证号:<s:property value="order.personID"></s:property></label><br>
                        <input type="hidden"  value=<s:property value="order.personID"></s:property>/>
                        <label>入住天数:<s:property value="order.days"></s:property></label><br>
                        <label>金额:<s:property value="order.paymoney"></s:property></label><br>
                        <label>房号:<s:property value="order.roomNumber"></s:property></label><br>
                        <input type="hidden" name="order.orderID" value=<s:property value="order.orderID"/>>
                        <input type="hidden" name="room.rid" value=<s:property value="order.roomID"/>>
                        <input type="hidden" id="balance" value=<s:property value="member.balance"/>>
                        <input type="hidden" id="paymoney" value=<s:property value="order.paymoney"/>>
                        <s:submit value="会员卡支付" cssClass="btn btn-primary" method="CheckInByCard"></s:submit>

                        </form>
                    <br>
                    <br>
                    <form action="Hotel.action">
                        <input type="hidden" name="order.orderID" value=<s:property value="order.orderID"/>>
                        <input type="hidden" name="room.rid" value=<s:property value="order.roomID"/>>
                        <input type="hidden"  id="rightID" value=<s:property value="order.personID"></s:property>/>
                        <s:submit value="现金支付" cssClass="btn btn-primary" method="CheckInByCash"></s:submit>
                    </form>


                </div>
            </div>


        </div>
    </div>

</div><!--/.fluid-container-->

<script type="text/javascript">
function CheckMoney(){
var balance=document.getElementById('balance').value;
    var paymoney=document.getElementById('paymoney').value;
    if(balance<=paymoney){
        alert("账户余额不足!");
        return false;
    }else{
        return true;
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