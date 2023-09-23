<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23-Sep-23
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="uploadfile" method="post" enctype="multipart/form-data">
    Select File:<input type="file" name="fname"/><br/>
    <input type="submit" value="upload"/>
</form>
</body>
</html>
