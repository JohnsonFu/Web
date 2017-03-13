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
    <title>管理员主页</title>
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
    <script src="js/jquery.min.js"></script>
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
                        <li><a class="ajax-link" href="HotelManager.action?method%3ABackToHomepage"><i class="glyphicon glyphicon-home"></i><span> 主页</span></a>
                        </li>
                        <li><a class="ajax-link" href="HotelManager.action?method%3AShowSettleMoney"><i class="glyphicon glyphicon-folder-open blue"></i><span>各店业务查看/结算</span></a>
                        </li>
                        <li><a class="ajax-link" href="ManagerCharts.jsp"><i class="glyphicon glyphicon-folder-close yellow"></i><span>查看各店资产</span></a>
                        </li>
                        <li><a class="ajax-link" href="HotelManager.action?method%3AShowAllMember"><i class="glyphicon glyphicon-list red"></i><span>查看会员账单</span></a>
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
                    <li><i class="glyphicon glyphicon-home blue"></i><span> 主页</span></li>
                </ul>

            </div>

            <div class=" row">

                <div class="col-md-3 col-sm-3 col-xs-6">
                    <a data-toggle="tooltip"  class="well top-block" href="HotelManager.action?method%3AShowSettleMoney">
                        <i class="glyphicon glyphicon-folder-open blue"></i>

                        <div>各店业务查看/结算</div>

                    </a>
                </div>

                <div class="col-md-3 col-sm-3 col-xs-6">
                    <a data-toggle="tooltip"  class="well top-block" href="ManagerCharts.jsp">
                        <i class="glyphicon glyphicon-folder-close yellow"></i>

                        <div>查看各店资产</div>

                    </a>
                </div>

                <div class="col-md-3 col-sm-3 col-xs-6">
                    <a data-toggle="tooltip"  class="well top-block" href="HotelManager.action?method%3AShowAllMember">
                        <i class="glyphicon glyphicon-list red"></i>

                        <div>查看会员账单</div>

                    </a>
                </div>

                <div class="col-md-3 col-sm-3 col-xs-6">
                    <a data-toggle="tooltip"  class="well top-block" href="HotelManager.action?method%3ALogout">
                        <i class="glyphicon glyphicon-remove red"></i>

                        <div>退出登录</div>

                    </a>
                </div>

            </div>

            <div id="main" style="width: 650px;height:400px;"></div>

            <!-- Ad ends -->

            <hr>


        </div>
    </div>

</div><!--/.fluid-container-->

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




<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
var hotel=[];
    var sales=[];
chartstart();
function chartstart() {

    $.ajax({
        url: "getHotelData.action",
        type: "GET",
        success: function (data,textStatus) {
           // alert(data);
           datas=data;
            test();
        }
    });
}
function test() {
    var t = datas.split(";");
    for (var i = 0; i < t.length-1; i++) {
        var p = t[i].split(",");
        hotel.push(p[0]);
        sales.push(p[1]);
    }


    var dataAxis = hotel;
    var data = sales;
    var yMax = 500;
    var dataShadow = [];

    for (var i = 0; i < data.length; i++) {
        dataShadow.push(yMax);
    }

    option = {
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : hotel,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'营业总额',
                type:'bar',
                barWidth: '60%',
                data:sales
            }
        ]
    };
    myChart.setOption(option);
}


</script>

</body>
</html>
