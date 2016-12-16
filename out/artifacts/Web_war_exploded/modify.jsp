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
<title>修改信息</title>
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
                         <li><a href="showlist.action">书籍列表</a></li>
                    </ul>
               </div><!--/.nav-collapse -->
          </div>
     </div>
</div>
<br>
<br>
<br>
<div class="container" align="center">
<s:form action="edit">
书名:<s:property value="book.name"></s:property><input type="hidden" name="book.name"   value=<s:property  value='book.name'/>><input type="hidden" name="book.id" value=<s:property  value='book.id'/>><br>
作者:<s:textfield name="book.author"></s:textfield><br>
价格:<s:textfield name="book.price"></s:textfield><br>
<s:submit value="修改" method="update"></s:submit>
</s:form>
     </div>
</body>
</html>