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
    Cookie[] cookies = request.getCookies();
    String username = null;
    String address = null;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
            if (cookie.getName().equals("address")) {
                address = cookie.getValue();
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Read Cookies</title>
</head>
<body>
<center>
    <h1>Cookie Values</h1>
    <h3>Username: <%= username %></h3>
    <h3>Address: <%= address %></h3>
</center>
</body>
</html>