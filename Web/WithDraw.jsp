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
    <title>银行卡转账</title>
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
    <script src="js/echarts.min.js" type="text/javascript"></script>

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
        <button type="button" class="navbar-toggle pull-left animated flip">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- user dropdown starts -->
        <!-- user dropdown ends -->

        <!-- theme selector starts -->
        <!-- theme selector ends -->

        <ul class="collapse navbar-collapse nav navbar-nav top-menu">
            <li><a href="#"><i class="glyphicon glyphicon-globe"></i>HostelWorld</a></li>
            <li class="dropdown">
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li class="divider"></li>
                    <li><a href="#">One more separated link</a></li>
                </ul>
            </li>
            <li>
            </li>
        </ul>

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
                        <li><a class="ajax-link" href="Member.action?method%3ABackToHomepage"><i class="glyphicon glyphicon-home"></i><span> 主页</span></a>
                        </li>
                        <li><a class="ajax-link" href="#"><i class="glyphicon glyphicon-book blue"></i><span>银行转账/积分兑换</span></a>
                        </li>
                        <li><a class="ajax-link" href="Member.action?method%3AshowBusiness"><i class="glyphicon glyphicon-list-alt green"></i><span>业务信息</span></a>
                        </li>
                        <li><a class="ajax-link" href="Member.action?method%3AShowPersonInfo"><i class="glyphicon glyphicon-user yellow"></i><span>账号信息</span></a>
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
                    <li><i class="glyphicon glyphicon-book blue"></i><span>银行转账/积分兑换</span>
                    </li>
                </ul>
            </div><h1>
            Welcome,<s:property value="member.name"></s:property></h1> <br>
   <form action="Member.action" onsubmit="return checkMoney()">
       <label>您的会员卡余额<s:property value="member.balance"></s:property>元</label><br>
<label>您的银行卡号:<s:property value="member.bankAccount.BankID"></s:property></label><br>
       <input type="hidden" id="bankmoney" value=<s:property value="member.bankAccount.balance"></s:property>>
            <label>银行卡余额:<s:property value="member.bankAccount.balance"></s:property></label><br>
            向会员卡充值金额:<input type="text" class="form-control" id="inputmoney" name="WithDrawMoney" ><br>
           <s:submit cssClass="btn btn-primary" value="充值" method="DoWithDraw"></s:submit>
       </form>
            <br>
            <br>
            <form action="Member.action" >
                <label>您可兑换的积分:<s:property value="member.points"></s:property>(兑换规则：1积分=1元)</label><br>
                <s:submit cssClass="btn btn-primary" value="兑换" method="exchange"></s:submit>

            </form>




            <!-- content ends -->
        </div><!--/#content.col-md-0-->
    </div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <div class="row">
        <div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
            <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
            <!-- Charisma Demo 2 -->
            <ins class="adsbygoogle"
                 style="display:inline-block;width:728px;height:90px"
                 data-ad-client="ca-pub-5108790028230107"
                 data-ad-slot="3193373905"></ins>

        </div>


    </div>
    <!-- Ad ends -->

    <hr>

<script type="text/javascript">
    function checkMoney(){
        var val=document.getElementById("inputmoney").value;
        var reg = new RegExp("^[0-9]*$");
        if(!reg.test(val)){
            alert("充值金额请输入数字!");
            return false;
        }else {
            var bankmoney=document.getElementById("bankmoney").value;
            if(val>=bankmoney){
                alert("银行卡余额小于充值金额");
                return false;
            }else {
                return true;
            }
        }

    }


</script>




</div><!--/.fluid-container-->

<!-- external javascript -->
<script src="js/jquery.min.js"></script>
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