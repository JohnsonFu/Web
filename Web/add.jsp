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
<title>添加书籍</title>
</head>
<body>
<a href="#">添加书籍</a>
<a href="showlist.action">书籍列表</a>
<a href="monitor.jsp">在线监控</a>
<s:form action="addbook">
<s:label>添加书籍</s:label><br>
<label>书名</label><input type="text" name="book.name" /><br>
<label>作者</label><input type="text" name="book.author" /><br>
<label>价格</label><input type="text" name="book.price" /><br>
<s:submit value="添加" method="add"></s:submit>
</s:form>
</body>
</html>