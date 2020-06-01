<%-- 
    Document   : edit
    Created on : 01/05/2020, 4:55:26 PM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserBean userBean = (UserBean)session.getAttribute("UserBean");
        %>
        <h1>Edit Information</h1>
         <form action="RegisterServlet" method="post">
            <input type="text" name="firstName" placeholder="First Name" required>
            <input type="text" name="lastName" placeholder="Last Name" required>
            <input type="text" name="email" placeholder="Email Address" required>
            <input type="tel" name="phone" placeholder="Phone Number" pattern="[0]{1}[0-9]{9}" required>
            <input type="text" name="address" placeholder="Address" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="password" name="rePassword" placeholder="Re-enter Password" required>
            <button class="button" type="submit">Submit</button>
            <button class="button" id="cancel-btn" type="button" onclick="window.location='index.jsp'">Cancel</button>
        </form>
        <a href="main.jsp">Go back</a>
    </body>
</html>
