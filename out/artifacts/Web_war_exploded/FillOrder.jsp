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
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<link href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script src="bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<link href="bootstrap-datetimepicker-master/sample%20in%20bootstrap%20v2/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">

<head>
    <title></title>
</head>
<body>
<div class="container" align="center">
    <h3>用户名<s:property value="member.name"></s:property><br>
        <s:property value="hotel.name"></s:property>&nbsp;<s:property value="hotel.address"></s:property>
    </h3>


            房号:<s:property value='room.roomNumber'/>&nbsp;&nbsp;<br>
            房型:<s:property value='room.type'></s:property><br>
            价格:<s:property value="room.price"></s:property><br>
    <div class="control-group">
        <label class="control-label">Date Picking</label>
        <div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
            <input size="16" type="text" value="" readonly>
            <span class="add-on"><i class="icon-th"></i></span>
        </div>
        <input type="hidden" id="dtp_input2" value="" /><br/>
    </div>
    可预订时间:今日至<s:property value="room.beforeTime"></s:property><br>

        -------------
</div>
    <script type="text/javascript">
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
</body>

</html>
