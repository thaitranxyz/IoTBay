<%@page import="DAO.Model.Payment"%>
<%@page import="java.util.ArrayList"%>
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
            String DefaultString = "False";
         %>
        <h1>IotBay</h1>
        <hr>
        <div class="top_right_link_div">
            <a href="logout.jsp">Logout</a>
            <a href="">Catalogue</a>
            <a href="">Order List</a>
            <a href="main.jsp">Home</a>
        </div>
        <h2>Payment History</h2>
            <table class="payment_history">
                <tr>
                    <th>Credit Card Number</th>
                    <th>Credit Card Expiry</th>
                    <th>Credit Card CVC</th>
                    <th>Default</th>
                </tr>
                <%
                    if (paymentList.size() > 0){
                        for (int i = 0; i < paymentList.size(); i++){
                            if(paymentList.get(i).getIsDefault()==1){
                                DefaultString = "True";
                            }
                            else{
                                DefaultString = "False";
                            }
                            }
                    %>
                <tr>
                    <td><%=paymentList.get(i).getCreditCardNumber()%></td>
                    <td><%=paymentList.get(i).getCreditCardExpiry()%></td>
                    <td><%=paymentList.get(i).getCreditCardCVC()%></td>
                    <td><%=DefaultString%></td>
                    <td><a href="PaymentServlet?action=update&index=<%=i%>">Update</a></td>
                    <td><a href="PaymentServlet?action=delete&number=<%=i%>">Delete</a></td>
                </tr>
                <tr>
                    <td colspan="8"><a href="paymentDetail.jsp">Add new payment</a></td>
                </tr>
            </table>
                <%
                    }
                    catch (Exception ex) {
                        ;
                    }
                    %>
    </body>
</html>
