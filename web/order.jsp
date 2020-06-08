<%-- 
    Document   : order
    Created on : 07/06/2020, 1:49:29 PM
    Author     : theod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        
    </head>
    <body>
        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String addressErr = (String) session.getAttribute("addressErr");
            String quantityErr = (String) session.getAttribute("quantityErr");
            String productErr = (String) session.getAttribute("productErr");
        %>
        <div class="container">
            <div class ="title-header"> 
                <h1>Device Order Form</h1> 
            </div>
            
            <form action="SubmitOrderServlet" method="post">
                <h4>Customer Details</h4>
                <table>
                    <tr><th><input type="text" name ="fullName" placeholder ="<%=(nameErr != null ? nameErr: "FullName" )%>" required></th></tr>
                    <tr><th><input type="text" name ="email" placeholder="<%=(emailErr != null ? emailErr: "Email Address" )%>" required></th></tr>
                    <tr><th><input type="text" name ="address" placeholder="<%=(addressErr != null ? addressErr: "Residential Address" )%>" required></th></tr>
                </table>
 
                <br>
                <br>
                <h4>Cart</h4>
                <table width ="600px">
                    <tr>
                        <th><input type="text" name="productId" placeholder ="<%=(productErr != null ? productErr: "Product ID" )%>" required></th>
                        <th><input type="number" name="productQty" placeholder ="<%=(quantityErr != null ? quantityErr: "Quantity" )%>" required></th>
                        <th><button class="button" type="button">Add</button></th>
                    </tr>
                </table>
                <table width ="600px" cellpadding="0" cellspacing="0">
                    <tr>
                        <th>#ID</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </table>
                <br>
                <br>
                <button class="button" type="submit" formaction="SaveOrderServlet">Save</button>
                <button class="button" type="submit">Continue</button>
                
            </form>
            
        </div>
    </body>
</html>
