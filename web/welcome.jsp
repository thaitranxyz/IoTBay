<%-- 
    Document   : welcome
    Created on : 28/04/2020, 10:55:50 PM
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
        <%--<jsp:useBean id="UserBean" scope="session" class="beans.UserBean"/>--%>
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
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
            %>

            <h1>First Name: <%= firstName%></h1>   
            <h1>Last Name: <%= lastName%></h1>    
            <h1>Email: <%= email%></h1>    
            <h1>Phone: <%= phone%></h1>    
            <h1>Username: <%= userName%></h1>    
            <h1>Password: <%= password%></h1>    
        </div>
       

        <%
            UserBean userBean = new UserBean(firstName, lastName, email, phone, userName, password);
            session.setAttribute("userBean", userBean);
        %>




    </body>
</html>
