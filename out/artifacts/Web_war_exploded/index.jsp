<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
</head>
<body>
   <h1>登录</h1>
   <s:form action="user">
      <label for="name">登录界面</label><br/>
    <s:label value="账户名">  </s:label><input type="text" name="user.username"/><br>
      <s:label value="密码">  </s:label><input type="password" name="user.password"/>
      <s:submit value="登录" method="login"></s:submit>
   </s:form>
</body>
<script type="text/javascript">
var msg="${requestScope.haslogin}";
if(msg!=""){
alert(msg);
}
</script>
</html>