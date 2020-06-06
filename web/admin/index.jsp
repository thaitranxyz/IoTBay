<%-- 
    Document   : AdminMain
    Created on : Jun 6, 2020, 5:28:06 PM
    Author     : HK
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="DAO.Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String active = "Manage Products";
    session.setAttribute("active", active);
%>

<!DOCTYPE html>
<html>
    <head>
        <!-- meta tag / script let -->
        <jsp:include page = "_meta.jsp" />
        <title>Admin::<%= active%></title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <jsp:include page = "_header.jsp" />
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                     <jsp:include page = "_left.jsp" />
                </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Product Manager</h1>
            <%
                if(session.getAttribute("msg") != null)
                    out.println(session.getAttribute("msg"));
            %>
            <div class="row placeholders">
                <form class="form-horizontal" action="/IoTBayApp/AdminController" method="get">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Product Name:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" placeholder="Product Name" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-6">
                            <button type="submit" class="btn btn-success" name="btn_submit">Search</button>
                        </div>
                    </div>
                </form>
            </div>
            <% 
                if(session.getAttribute("productList")!=null){
                LinkedList<Product> products = (LinkedList<Product>)session.getAttribute("productList");
            %>
            <p class="text-error">Number of product:  <%=products.size()%></p>
            <table class="table table-hover table-bordered">
            <thead>
                <tr class="info">
                    <th>#</th>
                    <th colspan="3">Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <%
                for(Product product : products){
                    %>
                    <tr>
                        <td><%= product.getId()%></td>
                        <td colspan="3"><%= product.getName()%></td>
                        <td>
                            <a href="EditProduct?id=<%= product.getId()%>" title="Edit"><i class="icon-edit"></i></a>
                            <a href="DeleteProduct?id=<%= product.getId()%>" title="Delete"><i class="icon-delete"></i></a>
                        </td>
                    </tr>
                    <%
                }
                }
            %>
            </table>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <jsp:include page = "_script.jsp" />
    </body>
</html>
