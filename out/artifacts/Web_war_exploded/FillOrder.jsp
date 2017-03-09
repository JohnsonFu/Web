<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/2/23
  Time: 11:46
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
    <title>提交订单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->

    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>


    <link href="css/select2.css" rel="stylesheet">
    <link rel="stylesheet" href="css/datepicker.css" />
    <!-- jQuery -->


    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
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
                        <li><a class="ajax-link" href="Member.action?method%3AWithDraw"><i class="glyphicon glyphicon-book blue"></i><span>银行转账</span></a>
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

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->


            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-edit"></i> Form Elements</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-setting btn-round btn-default"><i
                                        class="glyphicon glyphicon-cog"></i></a>
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i
                                        class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form action="Member.action" onsubmit="return checkTime()">






                                <img src="img/timg.jpg" width="200px" height="150px"><br>
                                <label>  <s:property value="hotel.name"/></label><br>
                                <label>房型:<s:property value='room.type'></s:property></label>
                                <br>
                                <label>房号:<s:property value='room.roomNumber'/></label>
                                <br>
                                <label>可预订时间:今日至<s:property value="room.beforeTime" ></s:property></label>
                                <br>
                                <label>入住人姓名:</label><input type="text" name="order.name" class="form-control">
                                <label>入住人身份证号:</label><input type="number" name="order.personID" class="form-control">
                                <input type="hidden" id="maxtime" value=<s:property value='room.beforeTime'/>>
                                <input type="hidden" id="price" value=<s:property value='room.price'/>>
                                <input type="hidden" name="order.roomNumber" value=<s:property value='room.roomNumber'/>>
                                <input type="hidden" name="order.roomID" value=<s:property value='room.rid'/>>
                                <input type="hidden" name="order.roomType" value=<s:property value='room.type'/>>
                                <div class="control-group">
                                    <label class="control-label">入住日期</label>

                                    <div  data-date="" class="input-append date datepicker" >
                                        <input type="text" value="" name="order.inTime" id="newtime"      data-date-format="yyyy-mm-dd" class="span" >
                                        <span class="add-on"><button class="btn btn-sm blue">选择</button><i class="icon-th"></i></span> </div>
                                </div>

                                <label>入住天数:</label> <select class="js-example-basic-single" name="order.days"  id="nights" onchange="computeMoney()" >
                                <option value ="1">1</option>
                                <option value ="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                            </select>
                                <br><br>

                                <label>入住金额:</label><label id="allmoney" name="order.paymoney" ><s:property value="room.price"></s:property></label>元
                                <input type="hidden" name="order.paymoney" id="paymoney" />
                                <br>
                                <s:submit value="预定" method="submitOrder" cssClass="btn btn-default"  onsubmit="setMoney()"></s:submit>
                            </form>

                        </div>
                    </div>
                </div>
                <!--/span-->

            </div><!--/row-->

            <!-- content ends -->
        </div><!--/#content.col-md-0-->
    </div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <!-- Ad ends -->

    <hr>


</div><!--/.fluid-container-->

<script type="text/javascript">
    $(document).ready(function() {
        $(".js-example-basic-single").select2();
    });
</script>
<!-- external javascript -->

<script type="text/javascript">

    function computeMoney(){
        var price=document.getElementById("price").value;
        var nights=document.getElementById("nights").value;
        var allmoney=price*nights;
        document.getElementById("allmoney").innerHTML=allmoney
    }
    function setMoney(){
        document.getElementById("paymoney").value=document.getElementById("allmoney").innerHTML
    }

    function checkTime(){
        var strDate=document.getElementById("maxtime").value.split("-");
        var d = new Date();
        d.setFullYear(strDate[0])
        d.setMonth(strDate[1]-parseInt(1))
        d.setDate(strDate[2])
        d.setHours(23);
        d.setMinutes(59);
        d.setSeconds(59)
        var reDate=document.getElementById("newtime").value.split("/");
        var e=new Date();
        e.setFullYear(reDate[2]);
        e.setMonth(reDate[0]-parseInt(1))
        e.setDate(reDate[1]);
        var mindate=new Date();
        mindate.setHours(6);
        if(e<mindate){
            document.getElementById("newtime").value="";
            alert("不能选择现在之前的日期")
            return false
        }
        if(e>d){
            document.getElementById("newtime").value="";
            alert("超过该房间的计划时间,请选择较早的日期或者其他房间")
return false
        }else{
            document.getElementById("newtime").value=e.getFullYear()+"-"+(e.getMonth()+parseInt(1))+"-"+e.getDate();
            return true;
        }

    }

    $(".form_date").datetimepicker({
        format: "yyyy-mm-dd",
        language:'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>

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


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-colorpicker.js"></script>


<script src="js/bootstrap-datepicker.js"></script>
<script src="js/masked.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/matrix.js"></script>
<script src="js/matrix.form_common.js"></script>


</body>
</html>
