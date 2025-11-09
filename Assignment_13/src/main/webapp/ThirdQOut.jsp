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
<h1>Out Object</h1>
<%
	int i = 21;
	char c = 'T';
	float f = 67.09f;
	String str = "Tanaya Bankhele";
%>
<h3>
	Displaying an Integer  : <% out.println(i); %> <br/>
	Displaying Character  : <% out.println(c); %> <br/>
	Displaying Float : <% out.println(f); %> <br/> 
	Displaying String : <% out.println(str); %>
</h3>
</center>
</body>
</html>