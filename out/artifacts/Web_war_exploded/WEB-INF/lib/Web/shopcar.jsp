<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
用户名:<s:property value="#session.user.username"/>
<a href="usershow.action">商城</a>
<table border="1">
<tr>
<th>书名</th>
<th>作者</th>
<th>价格</th>
<th>删除</th>
</tr>
<s:iterator id="item" value="#session.shopcar">
<tr>
<s:form action="user">
<th><input type="hidden" name="book.name" value=<s:property  value='#item.name'/>>${item.name}
<input type="hidden" name="book.id" value=<s:property  value='#item.id'/>></th>
<th><input type="hidden" name="book.author" value=<s:property  value='#item.author'/>>${item.author}</th>
<s:if test="#item.price>50"><th style="color:red"></s:if><s:else><th></s:else><input type="hidden" name="book.price" value=<s:property  value='#item.price'/>>${item.price }</th>
<th><s:submit type="button" method="delete"  value="删除"/></th>
</s:form>
</tr>
</s:iterator>
总额:<s:property value="#session.totalmoney"/>
</table>


</body>
</html>