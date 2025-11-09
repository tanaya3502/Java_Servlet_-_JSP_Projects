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
    String username = request.getParameter("username");
    String address = request.getParameter("address");

    // Create cookies for username and address
    Cookie usernameCookie = new Cookie("username", username);
    Cookie addressCookie = new Cookie("address", address);

    // Set the cookies' expiration time (optional)
    usernameCookie.setMaxAge(3600); // 1 hour
    addressCookie.setMaxAge(3600);  // 1 hour

    // Add the cookies to the response
    response.addCookie(usernameCookie);
    response.addCookie(addressCookie);

    response.sendRedirect("SevenQCookies1.jsp");
%>

</center>
</body>
</html>