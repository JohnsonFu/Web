<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/10
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
<s:form action="upload" enctype="multipart/form-data" method="POST" validate="true">
    <s:label value="上传文件"></s:label>
    <s:file name="file" label="文件"></s:file>
    <s:submit value="开始上传" method="upload"></s:submit>
</s:form>

</body>
</html>
