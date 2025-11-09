<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%
application.setAttribute("backgroundColor", "#ffcc00");
%>

<div style="background-color: <%= application.getAttribute("backgroundColor") %>;"><br>
    <h1>Background Color</h1>
    <p>This JSP page sets its background color using the implicit application object.</p><br>
</div>
</center>
</body>
</html>