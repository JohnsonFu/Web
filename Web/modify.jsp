<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
</head>
<body>
<a href="add.jsp">添加书籍</a>
<a href="showlist.action">书籍列表</a><br>
<s:form action="edit">
书名:<s:property value="book.name"></s:property><input type="hidden" name="book.name"   value=<s:property  value='book.name'/>><input type="hidden" name="book.id" value=<s:property  value='book.id'/>><br>
作者:<s:textfield name="book.author"></s:textfield><br>
价格:<s:textfield name="book.price"></s:textfield><br>
<s:submit value="修改" method="update"></s:submit>
</s:form>
</body>
</html>