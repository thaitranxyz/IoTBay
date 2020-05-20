<%-- 
    Document   : edit
    Created on : 01/05/2020, 4:55:26 PM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserBean userBean = (UserBean)session.getAttribute("UserBean");
        %>
        <h1>not available</h1>
        <a href="main.jsp">Go back</a>
    </body>
</html>
