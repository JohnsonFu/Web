<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2017/1/8
  Time: 13:27
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
    <title>学生登录</title>
</head>
<body>

<br>
<br>
<div class="container" align="center">
   <s:property value="member.name"></s:property>
    <h1>绑定银行卡</h1>

        银行卡号<input type="text" id="bankid" name="bankAccount.BankId"/><br>
        密码<input type="password" id="bankpassword" name="bankAccount.password"/><br>
        <button onclick="Bind()">绑定</button>

</div>
<script language="JavaScript">
    function Bind() {

        var $userNameInput = $("#bankid");
        var userName = $userNameInput.val();

        var password = $("#bankpassword").val();
        $.ajax({
            url : "bindBank.action",
            type : "GET",
            data : "bankid=" + userName+'&bankpassword='+password,
            success : function(data, textStatus) {
                 alert(data);
                //$("#show").val(data)
            }
        });
    }
</script>
</body>
</html>