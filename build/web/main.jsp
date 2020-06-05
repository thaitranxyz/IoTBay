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
                text-decoration: none;
                float: right;
                /*border: 1px solid #00b894;*/
                margin-right: 5px; 
                margin-bottom: 20px;
            }
            
            .button:hover {
                background-color: #b2bec3;
                color: white;
            }
            
            #user {
                position: fixed;
                /*float: right;*/
                
                top: 0.1em;
                right: 10em;
            }
            
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <!--<a href="welcome.jsp" class="button">Go back</a>-->
        <a href="LogoutServlet?email='<%=user.getEmail()%>'" class="button">Logout</a>
        <a href="EditServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'" class="button">Edit</a>
        <div>
            <p id="user">You are logged in as <b>&lt${user.email}&gt</b></p>
           
             
        </div>
        <%--<jsp:include page="profile.jsp" flush="true" />--%>
    </body>
</html>
