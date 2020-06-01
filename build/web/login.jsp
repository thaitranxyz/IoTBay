<%-- 
    Document   : register
    Created on : 22/04/2020, 1:30:27 AM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
            .form-group {
                width: 40%;
                margin: 0 auto;
            }

/*            #login {
                margin: 0 auto;
                margin-left: 520px;
                margin-top: 30px;
            }*/

            h1 {
                font-family: sans-serif;
                text-align: center;
                margin-top: 15px;
                padding: 5px;
            }
            
            .button-container {
                text-align: center;
                margin-top: 30px;
            }
            
            .button {
                background-color: #00b894;
                padding: 15px 30px;
                color: white;
                border: 0; 
            }
            
            #cancel-btn {
                background-color: grey;
            }
           
        </style>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passwordErr= (String) session.getAttribute("passwordErr");
        %>
        <h1>
            <%=(existErr != null ? existErr: "")%>
        </h1>
        <div class="container">
            <h1>Login</h1>
            <form action="LoginServlet" method="post">
                <div class="form-group mt-5">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" id="exampleInputEmail1" name="email" required>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" placeholder="<%=(passwordErr != null ? passwordErr : "Enter password")%>" id="exampleInputPassword1" name="password" required>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <div class="button-container">
                    <button type="submit" class="button" id="login">Login</button>
                    <button type="button" class="button" id="cancel-btn" onclick="window.location='index.jsp'">Cancel</button>
                </div>
            </form>

        </div>

    </body>
</html>
