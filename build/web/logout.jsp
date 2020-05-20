<%-- 
    Document   : logout
    Created on : 01/05/2020, 11:34:49 AM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>You have been logged out, <a href="index.jsp">click here</a> to go back to home page</p>
        <% session.invalidate(); %>
    </body>
</html>
