<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Project name</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="add.jsp">添加书籍</a></li>
                    <li><a href="#">书籍列表</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
<br>
<br>
<br>
<div class="container" align="center">
<table border="1">
<tr>
<th>书名</th>
<th>作者</th>
<th>价格</th>
<th>删除</th>
<th>编辑</th>
</tr>
<s:iterator id="item" value="booklist">
<tr>
<s:form action="edit">
<th><input type="hidden" name="book.id" value=<s:property value="#item.id" />><input type="hidden" name="book.name" value=<s:property  value='#item.name'/>>${item.name}</th>
<th><input type="hidden" name="book.author" value=<s:property  value='#item.author'/>>${item.author}</th>
<s:if test="#item.price>50"><th style="color:red"></s:if><s:else><th></s:else><input type="hidden" name="book.price" value=<s:property  value='#item.price'/>>${item.price }</th>
<th><s:submit type="button" method="modify"  value="编辑"/></th>
<th><s:submit type="button" method="remove"  value="删除"/></th>
</s:form>
</tr>
</s:iterator>
</table>
    </div>
</body>
</html>