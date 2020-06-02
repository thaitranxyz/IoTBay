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
             
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            
        %>
        <!--<a href="MainServlet?email='<%= user.getEmail()%>'&password='<%=user.getPassword()%>'">Go back</a>-->
        
        <h1>Edit Information</h1>
         <form action="UpdateServlet" method="post">
            <input type="text" name="firstName" placeholder="${user.getFirstName()}" required>
            <input type="text" name="lastName" placeholder="${user.getLastName()}" required>
            <input type="text" name="email" placeholder="${user.getEmail()}" required>
            <input type="tel" name="phone" placeholder="${user.getPhone()}" pattern="[0]{1}[0-9]{9}" required>
            <input type="text" name="address" placeholder="${user.getAddress()}" required>
            <input type="password" name="password" placeholder="${user.getPassword()}" required>
            <input type="password" name="rePassword" placeholder="Re-enter Password" required>
            <button class="button" type="submit">Submit</button>
            <button class="button" id="cancel-btn" type="button" onclick="window.location='index.jsp'">Cancel</button>
        </form>
        
    </body>
</html>
