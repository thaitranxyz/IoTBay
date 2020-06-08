<%@page import="DAO.Model.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="DAO.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>All Payments</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            ArrayList<Payment> paymentList = (ArrayList<Payment>) session.getAttribute("paymentList");
         %>
        <h1>IotBay</h1>
        <hr>
        <div class="top_right_link_div">
            <a href="logout.jsp">Logout</a>
        </div>
        <h2>Payment History</h2>
            <table class="payment_history">
                <tr>
                    <th>Credit Card Number</th>
                    <th>Credit Card Expiry</th>
                    <th>Credit Card CVC</th>
                </tr>
                <%
                    try{
                        System.out.print(paymentList);
                        if (paymentList.size() > 0){
                        for (int i = 0; i < paymentList.size(); i++){
                    %>
                <tr>
                    <td><%=paymentList.get(i).getCreditCardNumber()%></td>
                    <td><%=paymentList.get(i).getCreditCardExpiry()%></td>
                    <td><%=paymentList.get(i).getCreditCardCVC()%></td>
                    <td><a href="PaymentServlet?action=delete&number=<%=paymentList.get(i).getCreditCardNumber()%>">Delete</a></td>
                </tr>
                <%
                        }
                        }
                    }
                    catch (Exception ex) {
                        ;
                    }
                    %>
                    
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total Cost</td>
                </tr>
            </table>
    </body>
</html>
