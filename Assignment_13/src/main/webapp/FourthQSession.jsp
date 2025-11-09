<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<head>
    <meta charset="UTF-8">
    <title>Session Information</title>
</head>
<body>
<center>
<%
// Get the session object
javax.servlet.http.HttpSession sessionJsp = request.getSession();

// Set a session attribute
session.setAttribute("username", "Tanaya Bankhele");

// Retrieve session information
String username = (String) session.getAttribute("username");
int sessionTimeout = session.getMaxInactiveInterval();

out.println("<h1>Session Information</h1>");
out.println("<p>Username: " + username + "</p>");
out.println("<p>Session Timeout (in seconds): " + sessionTimeout + "</p>");
%>
</center>
</body>
</html>