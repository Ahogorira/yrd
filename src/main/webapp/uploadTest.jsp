<%--
  Created by IntelliJ IDEA.
  User: 16477
  Date: 2019/5/31
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/fileUploadPage" enctype="multipart/form-data" method="post">
    <input type="file" name="uploadFile" multiple/><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
