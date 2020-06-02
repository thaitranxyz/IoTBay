<%-- 
    Document   : main
    Created on : 30/04/2020, 10:43:22 PM
    Author     : trandamtrungthai
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .button {
                padding: 8px 17px;
                background-color: #00b894;
                color: white;
                font-family: Arial, sans-serif;
                border: 0;
                font-size: 15px;
                cursor: pointer;
                border-radius: 5px;
                position: relative;
                float: right;
                margin-right: 5px; 
                margin-bottom: 20px;
            }
            
            .button:hover {
                background-color: white;
                color: green;
            }
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <!--<a href="welcome.jsp" class="button">Go back</a>-->
        <a href="logout.jsp" class="button">Logout</a>
        <a href="EditServlet?email='<%= user.getEmail()%>'&password='<%=user.getPassword()%>'" class="button">Edit</a>
        <div>It works</div>
        <%--<jsp:include page="profile.jsp" flush="true" />--%>
        
    </body>
</html>
