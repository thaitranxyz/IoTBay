<%-- 
    Document   : savedOrderList
    Created on : 08/06/2020, 11:49:08 PM
    Author     : theod
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
                float: left;
                /*border: 1px solid #00b894;*/
                margin-right: 5px; 
                margin-bottom: 20px;
            }
            
            .button:hover {
                background-color: #b2bec3;
                color: white;
            }
            
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
            User user = (User)session.getAttribute("user");
            ArrayList<Order> orderList = (ArrayList)session.getAttribute("orderList");
            
        %>
        <div class="container">
                <a href="main.jsp" class='button'>Back</a>
            <h1>Saved Orders</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Date</th>
                        <th>Product ID</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%for (Order o: orderList){%>
                        <td><%=o.getOrderId()%></td>
                        <td><%=o.getDate()%></td>
                        <td><%=o.getProductId()%></td>
                        <td><%=o.getQuantity()%></td>
                        <td>
                            <a href="ResumeOrderServlet?orderId=<%=o.getOrderId()%>" class="button">Resume</a>
                            <a href="DeleteOrderServlet?orderId=<%=o.getOrderId()%>" class="button">Delete</a>
                        </td>
                        
                    </tr>
                    <%}%>
                    
                </tbody>
            </table>
        </div>
        
    </body>
</html>
