<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
    <title>登录</title>
    <script language="JavaScript">
        function testAjax() {

            var $userNameInput = $("#ajax_username");
            var userName = $userNameInput.val();

            $.ajax({
                url : "pluginAjax.action",
                type : "GET",
                data : "ajaxField=" + userName,
                success : function(data, textStatus) {
                   // alert(data);
                    $("#show").val(data)
                }
            });
        }
    </script>
</head>
<body>
<input type="text" id="ajax_username" name="ajaxField">
<button onclick="testAjax()">测试</button>
<input type="text" id="show">
</body>
<script type="text/javascript">
    var msg = "${requestScope.haslogin}";
    if (msg != "") {
        alert(msg);
    }
</script>
</html>