<%-- 
    Document   : profile
    Created on : 01/05/2020, 4:45:04 PM
    Author     : trandamtrungthai
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Model.AccessLog"%>
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
            ArrayList<AccessLog> list = (ArrayList)session.getAttribute("list");
            String resultErr = (String) session.getAttribute("resultErr");
        %>
        <div class="container">
            <h1><%=resultErr != null ? resultErr : ""%></h1>
            <table class="table">
                <thead>
                    <tr>
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
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
