<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
        String name = request.getParameter("name");
        String address = request.getParameter("add"); 
%>
	<center>
    <h1>Form Data</h1>
    <h3><p>Name: <%= name %></p>
    <p>Email: <%= address %></p></h3>
	</center>
</body>
</html>