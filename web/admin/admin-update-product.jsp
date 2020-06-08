<%@page import="DAO.Model.Product"%>
<jsp:include page = "_check.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String active = "Add Product";
    session.setAttribute("active", active);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page = "_meta.jsp"/>
    <title>Admin::<%= active%></title>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <jsp:include page = "_header.jsp"/>
    </nav>
    
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <jsp:include page = "_left.jsp" />
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Edit Product</h1>
          <%
              if(session.getAttribute("msg") != null){
                  out.println(session.getAttribute("msg"));
              }
              Product product = (Product)session.getAttribute("product");
          %>
          <div class="row">
              <form action="/IoTBayApp/UpdateProduct" method="post">
                  <input type="hidden" value="<%= product.getId()%>" name="id">
                <div class="form-group col-md-10 col-lg-12">
                  <label>Name</label>
                  <input type="text" class="form-control" value="<%= product.getName()%>" id="exampleInputEmail1" placeholder="Name" name="name" required autofocus>
                </div>
                <div class="form-group col-md-10 col-lg-6">
                  <label>Price</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" value="<%= product.getPrice()%>" placeholder="Price" name="price" required autofocus>
                </div>
                <div class="form-group col-md-10 col-lg-6">
                  <label>Quantity</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" value="<%= product.getQuantity()%>" placeholder="Quantity" name="quantity" required autofocus>
                </div>
                <div class="form-group col-md-10 col-lg-12">
                  <label>Description</label>
                  <!--<input type="text" class="form-control" id="exampleInputPassword1" placeholder="Tầm ảnh hưởng" name="impact" required>-->
                  <textarea class="jquery_ckeditor form-control"  name="description" cols="80" rows="6" placeholder="Description" ><%= product.getDescription()%></textarea>
                </div>
                <div class="form-group col-md-10 col-lg-12">
                <input class="btn btn-large btn-primary" type="submit" name="btn_submit" value="Submit">
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <jsp:include page = "_script.jsp"/>
  </body>
</html>
