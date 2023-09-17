<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16-Sep-23
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>



</head>
<body>
<h1>${tipu}</h1>
<%
    if(session.getAttribute("tipu")==null) {
        response.sendRedirect("index.jsp");
    }
%>
<h1>Wellcome</h1>
</body>
</html>
