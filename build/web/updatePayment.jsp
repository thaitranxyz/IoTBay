<%-- 
    Document   : register
    Created on : 01/05/2020, 8:39:18 PM
    Author     : Wenbo Zhang
--%>

<%@page import="DAO.Model.Payment"%>
<%@page import="DAO.Model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>Update Payment Details</title>
    </head>
    <body>
        <h1>IoTBay</h1>
        <div class="top_right_link_div">
            <a href="logout.jsp">Logout</a>
            <a href="main.jsp">Home</a>
            <a href="PaymentServlet?action=viewList">View Payment list</a>
        </div>
        <hr>
        <%
            User user = (User)session.getAttribute("user");
            String CCNMsg = (String) session.getAttribute("CCNErr");
            String CCEMsg = (String) session.getAttribute("CCEErr");
            String CCCVCMsg = (String) session.getAttribute("CCCVCErr");
            String SuccessUpdate = (String) session.getAttribute("SuccessUpdate");
            String isUpdate = (String) session.getAttribute("isUpdate");
            Payment oldPayment = (Payment) session.getAttribute("oldPayment");
            %>
            <h3>Update Payment</h3>
        
        <form action="AddPaymentServlet" method="post">
            <%
                if(SuccessUpdate!=null){
            %>
            <h2><%=SuccessUpdate%></h2>
            <%
                }
            %>
            <table>
                <tr>
                    <td><label for="CCN">Credit Card Number</label></td>
                    <td>
                        <input class="form_input_box" type="text" id ="frame" name="CCN" placeholder="<%=(CCNMsg != null ? CCNMsg : oldPayment.getCreditCardNumber()) %>" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="CCE">Credit Card Expiry</label></td>
                    <td>
                        <input class="form_input_box" type="text" id ="frame" name="CCE" placeholder="<%=(CCEMsg != null ? CCEMsg : oldPayment.getCreditCardExpiry()) %>" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="CCCVC">Credit Card CVC</label></td>
                    <td>
                        <input class="form_input_box" type="text" id ="frame" name="CCCVC" placeholder="<%=(CCCVCMsg != null ? CCCVCMsg : oldPayment.getCreditCardCVC()) %>" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="isDefault">Make default</label></td>
                    <td><input type="checkbox" name="Checkbox"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><center>
                    <input type="hidden" name="isUpdate" value="true">
                    <input type="hidden" name="oldNumber" value="<%=oldPayment.getCreditCardNumber()%>">
                    <input type="hidden" name="origin"  value="1">
                    <input class="button" type="submit" value="Update" required>
                </center>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
