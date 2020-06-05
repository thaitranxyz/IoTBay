<%-- 
    Document   : profile
    Created on : 01/05/2020, 4:45:04 PM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.Model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .table {
                font-family: Arial, sans-serif;
                /*border-collapse: collaspe;*/
                width: 100%;
            }
            
            .table th, .table td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            
        </style>
    </head>
    <body>
        <%
            UserBean userBean = (UserBean)session.getAttribute("UserBean");
        %>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>userName</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${userBean.firstName}</td>
                        <td>${userBean.lastName}</td>
                        <td>${userBean.email}</td>
                        <td>${userBean.phone}</td>
                        <td>${userBean.userName}</td>
                        <td>${userBean.password}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
