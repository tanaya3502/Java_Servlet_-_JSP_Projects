<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
    
<body>
No session will be created after setting session attribute to false in page directive.
Hence, accessing the session object  will result in an error.

Session ID: <%= session.getId() %>  <br/>
Session creating time : <%= new Date(session.getCreationTime()) %>  <br/>

</body>


