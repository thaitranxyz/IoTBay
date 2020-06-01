<%-- 
    Document   : welcome
    Created on : 28/04/2020, 10:55:50 PM
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
                padding: 15px;
                padding-left: 5px 0px;
                background-color: #00b894;
                color: white;
                font-family: Arial, sans-serif;
                border: 0;
                font-size: 20px;
                cursor: pointer;
                border-radius: 20px;
            }

            .btn-container {
                position: relative;
                float: right;
            }

            body {
                font-family: Arial, sans-serif;
            }
        </style>
    </head>
    <body>
        <%--<jsp:useBean id="User" scope="session" class="Model"/>--%>
        <div class="container">
            <div class="btn-container">
                <a href="main.jsp" class="button">Main</a>
                <a href="index.jsp" class="button">Cancel</a>
            </div>


            <%
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");
                String address = request.getParameter("address");
                int customerId = Integer.parseInt(request.getParameter("customerId"));
            %>

            <h1>First Name: <%= firstName%></h1>   
            <h1>Last Name: <%= lastName%></h1>    
            <h1>Email: <%= email%></h1>    
            <h1>Phone: <%= phone%></h1>    
            <h1>Password: <%= password%></h1>    
        </div>




    </body>
</html>
