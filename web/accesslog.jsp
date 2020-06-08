<%-- 
    Document   : accesslog
    Created on : 06/06/2020, 10:48:24 PM
    Author     : trandamtrungthai
--%>

<%@page import="DAO.Model.AccessLog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                text-decoration: none;
/*                float: right;*/
                /*border: 1px solid #00b894;*/
                margin-right: 5px; 
                margin-bottom: 20px;
            }
            
            .button:hover {
                background-color: #b2bec3;
                color: white;
            }
            
            #back {
                float: right;
            }
            
            .input {
                padding: 5px 0px;
            }
            
        </style>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            ArrayList<AccessLog> list = (ArrayList)session.getAttribute("list");
        %>
        <div class="container">
            <form action="SearchServlet?email=<%=user.getEmail()%>" method="get">
                <input type="text" name="search" class="input">
                <button type="submit" class="button" id="login">Search</button>
                <a href="main.jsp" class="button" id="back">Back</a>
            </form>
            <table class="table">
                <thead>
                    <tr>
                        <th>User Id</th>
                        <th>Access Log Id</th>
                        <th>Login Date</th>
                        <th>Login Time</th>
                        <th>Logout Date</th>
                        <th>Logout Time</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%for (AccessLog a : list)
                        {%>
                        <td><%=a.getUserId()%></td>
                        <td><%=a.getAccessLogId()%></td>
                        <td><%=a.getLoginDate()%></td>
                        <td><%=a.getLoginTime()%></td>
                        <td><%=a.getLogoutDate()%></td>
                        <td><%=a.getLogoutTime()%></td>
                        
                    </tr>
                    <%}%>
                   
                </tbody>
            </table>
        </div>
    </body>
</html>
