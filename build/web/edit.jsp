<%-- 
    Document   : edit
    Created on : 01/05/2020, 4:55:26 PM
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
            h1 {
                text-align: center;
                font-family: sans-serif;
            }
            
            h3
            {
                text-align: center;
                color: #00b894;
                font-family: sans-serif;
            }
            
            form {
                display: grid;
                width: 50%;   
                /*padding: 2spx;*/
                margin: 0 auto;
                margin-top: -20px;
                /*border-spacing: 5px;*/
                /*border: 1px solid black;*/
             }
            
             input {
                 padding: 30px;
                 font-size: 18px;
                 margin-top: 10px;
             }
             
             .button {
                 width: 100%;
                 padding: 20px;
                 margin: 0 auto; 
                 margin-top: 10px;
                 background-color: #00b894;
                 color: white;
                 border: 0;
                 font-size: 20px;
                 cursor: pointer;
             }
             
             #cancel-btn {
                 background-color: grey;
             }
             
             .title-header {
                 font-family: sans-serif;
                 font-size: 25px;
                 text-align: center;
                 padding: 10px;
                 color: #00b894;   
             }
             
             .button-main {
                padding: 8px 17px;
                background-color: #b2bec3;
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
                margin-bottom: 10px;
            }
            
            .button-main:hover {
                background-color: #00b894;
                color: white;
            }
             
            .logo {
                position: relative;
                float: left;
                font-family: sans-serif;
                font-size: 20px;
                cursor: pointer;
            }
            
            #delete-btn {
                background-color: #d63031;
            }
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String updated = (String) session.getAttribute("updated");
            String existErr = (String) session.getAttribute("existErr");
            
        %>
        <div class="header">
            <a class="logo">IotBay</a>
            <a class="button-main" href="LogoutServlet?email=<%=user.getEmail()%>">Logout</a>
            <a class="button-main" href="MainServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'">Main</a>
        </div>
        <br/>
        <br/>
        <h1>Edit Information</h1> 
        <h3><%=updated != null ? updated : "" %></h3>
        <h3><%=existErr != null ? existErr : "" %></h3>
         <form action="UpdateServlet" method="post">
            <input type="text" name="firstName" value="${user.firstName}" required>
            <input type="text" name="lastName" value="${user.lastName}" required>
            <input type="text" name="email" value="${user.email}" readonly="readonly">
            <input type="tel" name="phone" value="${user.phone}" pattern="[0]{1}[0-9]{9}" required>
            <input type="text" name="address" value="${user.address}" required>
            <input type="password" name="password" value="${user.password}" required>
            <input type="password" name="rePassword" placeholder="Re-enter Password" required>
            <button class="button" type="submit">Update</button>
            <button class="button" id="cancel-btn" type="button" onclick="window.location='main.jsp'">Cancel</button>
        </form>
            <br/>
            <form action="DeleteServlet?email='<%=user.getEmail()%>'" method="post">
                <button class="button" id="delete-btn"type="submit">Delete</button>
            </form>
    </body>
</html>
