<%-- 
    Document   : main
    Created on : 30/04/2020, 10:43:22 PM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .button {
                padding: 15px;
                padding-left: 5px 0px;
                background-color: #00b894;
                color: white;
                font-family: Arial, sans-serif;
                border: 0;
                font-size: 20px;
                cursor: pointer;
                border-radius: 20px;
                position: relative;
                float: right;
                margin-right: 5px; 
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <% 
            UserBean userBean = (UserBean)session.getAttribute("userBean");
        %>
        
        <a href="welcome.jsp" class="button">Go back</a>
        <a href="logout.jsp" class="button">Logout</a>
        <a href="edit.jsp" class="button">Edit</a>
        
        <jsp:include page="profile.jsp" flush="true" />
        
    </body>
</html>
