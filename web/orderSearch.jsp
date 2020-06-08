<%-- 
    Document   : orderSearch
    Created on : 09/06/2020, 1:18:21 AM
    Author     : theod
--%>

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
            Order order = (Order)session.getAttribute("resultOrder");
            String resultErr = (String) session.getAttribute("resultErr");
            
        %>
        <div class="container">
            <h1><%=resultErr != null ? resultErr : ""%></h1>
            <a href="orderList.jsp">Back</a>
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
                        
                        <td><%=order.getOrderId()%></td>
                        <td><%=order.getDate()%></td>
                        <td><%=order.getTransactionId()%></td>
                        <td><%=order.getProductId()%></td>
                        <td><%=order.getQuantity()%></td>
                        <td><%=order.getTrackingCode()%></td>
                        <td><%=order.getStatus()%></td>
                        
                    </tr>
                    
                    
                </tbody>
            </table>
        </div>
    </body>
</html>
