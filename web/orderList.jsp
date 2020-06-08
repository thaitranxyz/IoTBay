<%-- 
    Document   : orderList
    Created on : 08/06/2020, 8:41:54 PM
    Author     : theod
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay</title>
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
            User user = (User)session.getAttribute("user");
            ArrayList<Order> orderList = (ArrayList)session.getAttribute("orderList");
            
        %>
        <div class="container">
            <form action="OrderSearch?email='<%=user.getEmail()%>'" method="get">
                <input name ="search" placeholder="Search by OrderId">
                <button type="submit" class="button" id="search">Search</button>
            </form>
            <table class="table">
                <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Date</th>
                        <th>Transaction ID</th>
                        <th>Product ID</th>
                        <th>Quantity</th>
                        <th>Tracking Code</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%for (Order o: orderList){%>
                        <td><%=o.getOrderId()%></td>
                        <td><%=o.getDate()%></td>
                        <td><%=o.getTransactionId()%></td>
                        <td><%=o.getProductId()%></td>
                        <td><%=o.getQuantity()%></td>
                        <td><%=o.getTrackingCode()%></td>
                        <td><%=o.getStatus()%></td>
                        
                    </tr>
                    <%}%>
                    
                </tbody>
            </table>
        </div>
        
    </body>
</html>
