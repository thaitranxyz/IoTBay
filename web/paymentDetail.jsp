<%-- 
    Document   : PaymentDetail
    Created on : 06/06/2020, 4:29:47 PM
    Author     : pikachu125
--%>

<%@page import="DAO.Model.Payment"%>
<%@page import="DAO.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>Add Payment Details</title>
    </head>
    <body>
        <h1>IoTBay</h1>
        <div class="top_right_link_div">
            <a href="logout.jsp">Logout</a>
            <a href="main.jsp">Home</a>
            <a href="PaymentServlet?action=viewList">View Payment history</a>
        </div>
        <%
            User user = (User)session.getAttribute("user");
            String CCNErr = (String) session.getAttribute("CCNErr");
            String CCEErr = (String) session.getAttribute("CCEErr");
            String CCCVCErr = (String) session.getAttribute("CCCVCErr");
            String Success = (String) session.getAttribute("Success");
            String isUpdate = (String) session.getAttribute("isUpdate");
        %>
        <h2>Add Payment</h2>
        <form action="AddPaymentServlet" method="post">
            <%
                if(Success!=null){
            %>
            <h3><%=Success%></h3>
            <%
                }
            %>
            <table>
                <tr>
                    <td><label for="CCN">Credit Card Number</label></td>
                    <td>
                        <input class="form_input_box" type="text" id ="frame" name="CCN" placeholder="<%=(CCNErr != null ? CCNErr : "5236172635167576") %>" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="CCE">Credit Card Expiry</label></td>
                    <td>
                        <input class="form_input_box" type="text" id ="frame" name="CCE" placeholder="<%=(CCEErr != null ? CCEErr : "20/20") %>" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="CCCVC">Credit Card CVC</label></td>
                    <td>
                        <input class="form_input_box" type="text" id ="frame" name="CCCVC" placeholder="<%=(CCCVCErr != null ? CCCVCErr : "222") %>" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="isDefault">As default payment</label></td>
                    <td><input type="checkbox" name="Checkbox"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                <center>
                    <input type="hidden" name="isUpdate" value="false">
                    <input type="hidden" name="oldPayment" value="null">
                    <input type="hidden" name="origin" value=${user.getUserId()}>
                    <input class="button" type="submit" value="Confirm" required>
                </center>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
