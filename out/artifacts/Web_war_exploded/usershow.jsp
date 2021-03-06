<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="50">
    <title>商品列表</title>
</head>
<body>
<label><s:property value="#session.msg"></s:property></label>
用户名:<s:property value="#session.user.username"/>
<a href="shopcar.jsp">购物车</a>
<s:form action="user">
    <s:submit value="注销" method="logout"></s:submit>
</s:form>
<table border="1">
    <tr>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>添加</th>
    </tr>
    <s:iterator id="item" value="booklist">
        <tr>
            <s:form action="user">
                <th><input type="hidden" name="book.name" value=<s:property value='#item.name'/>>${item.name}
                    <input type="hidden" name="book.id" value=<s:property value='#item.id'/>></th>
                <th><input type="hidden" name="book.author" value=<s:property value='#item.author'/>>${item.author}</th>
                <s:if test="#item.price>50">
                    <th style="color:red">
                </s:if><s:else><th></s:else><input type="hidden" name="book.price" value=<s:property
                    value='#item.price'/>>${item.price }</th>
                <th><s:submit type="button" method="buy" value="添加"/></th>
            </s:form>
        </tr>

    </s:iterator>
</table>

</body>
<script type="text/javascript">
    var msg = "${requestScope.message}";
    if (msg != "") {
        alert(msg);
    }


</script>
</html>