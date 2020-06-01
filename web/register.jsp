<%-- 
    Document   : register
    Created on : 22/04/2020, 12:33:01 PM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <style>
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
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
         
        <div class="container">
            <div class="title-header">
                <h1>Register Account</h1>
                <h4><%=(passErr != null ? passErr: "")%></h4>
                <h4><%=(emailErr != null ? emailErr : "")%></h4>
            </div>
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
        </div>
   
    </body>
</html>
