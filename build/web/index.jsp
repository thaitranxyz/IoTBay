<%-- 
    Document   : index
    Created on : 22/04/2020, 11:38:16 AM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.Model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
            #register {
                text-align: right;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">IoTBay</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="register.jsp" tabindex="-1">Register</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="order.jsp" tabindex="-1">Order</a>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
<!--                <input class="form-control mr-sm-2" type="text" placeholder="Username">
                <input class="form-control mr-sm-2" type="password" placeholder="Password">-->
                <button class="btn btn-outline-success my-2 my-sm-0 mr-2" type="button" onclick="window.location='login.jsp'">Login</button>
                <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="window.location='register.jsp'">Register</button>
              </form>
            </div>
        </nav>
        
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
