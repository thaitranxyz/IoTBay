<%@page import="DAO.Model.User"%>
<%@page import="DAO.DBManager.UserManager"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Shipping Information</title>
        
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
            User user = (User) session.getAttribute("user");
            String updated = (String) session.getAttribute("updated");
        %>
        
        <jsp:include page="main.jsp" />

  
            
                <jsp:include page="profile.jsp" />
                
                    <% System.out.println(user.getAddress()); %>
                    <h1>My Dashboard</h1>
                    <p>Your shipping information is displayed in the field below.</p>
                    <form name="customersTable.sql" method="post" action="<%= user.getUserId()%>">
                        <h1><strong>Edit here  <span><%= (updated != null) ? updated : ""%></span></strong></h1>
                        <div>
                            <label for="address">Address</label>
                            <input type="text" name="address" value="<%= user.getAddress()%>" >
                        </div>
                        

                       <div><input type='submit' value='Update'>

                            </div>
                        
                     </form>
                
           
        
    </body>
</html>