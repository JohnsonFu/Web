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
    <form action="Member.action">
    <h3>用户名<s:property value="member.name"></s:property><br>
        <s:property value="hotel.name"></s:property>&nbsp;<s:property value="hotel.address"></s:property>
    </h3>
        房号:<s:property value='room.roomNumber'/>&nbsp;&nbsp;<br>
            房型:<s:property value='room.type'></s:property><br>
            价格:<s:property value="room.price"></s:property><br>
    可预订时间:今日至<s:property value="room.beforeTime" ></s:property><br>
入住人姓名:<input type="text" name="order.name"><br>
    入住人身份证号:<input type="text" name="order.personID"><br>
    <input type="hidden" id="maxtime" value=<s:property value='room.beforeTime'/>>
    <input type="hidden" id="price" value=<s:property value='room.price'/>>
        <input type="hidden" name="order.roomNumber" value=<s:property value='room.roomNumber'/>>
        <input type="hidden" name="order.roomType" value=<s:property value='room.type'/>>
    <div class="control-group">
        <label class="control-label">入住日期</label>
        <div class="controls input-append date form_date"  data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
            <input size="16" type="text" name="order.inTime" id="newtime" value="" readonly onchange="checkTime()">
            <span class="add-on"><i class="icon-th"></i></span>
        </div>
    </div>
    入住天数: <select name="order.days"  id="nights" onchange="computeMoney()" >
    <option value ="1">1</option>
    <option value ="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
</select>
    <br>
    入住金额:<label id="allmoney" name="order.paymoney" ></label>
    <br>
        <s:submit value="提交" method="submitOrder"></s:submit>
</form>
        -------------
</div>
    <script type="text/javascript">

        function computeMoney(){
            var price=document.getElementById("price").value;
            var nights=document.getElementById("nights").value;
            var allmoney=price*nights;
            document.getElementById("allmoney").innerHTML=allmoney+"元"
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
            var reDate=document.getElementById("newtime").value.split("-");
            var e=new Date();
            e.setFullYear(reDate[0]);
            e.setMonth(reDate[1]-parseInt(1))
            e.setDate(reDate[2]);
            var mindate=new Date();
            mindate.setHours(6);
            if(e<mindate){
                document.getElementById("newtime").value="";
                alert("不能选择现在之前的日期")
            }
            if(e>d){
                document.getElementById("newtime").value="";
                alert("超过该房间的计划时间，前选择较早的日期或者其他房间")

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
</body>

</html>
