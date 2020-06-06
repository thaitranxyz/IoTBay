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
          <h1 class="page-header">Add new product</h1>
          <%
              if(session.getAttribute("msg") != null){
                  out.println(session.getAttribute("msg"));
              }
          %>
          <div class="row">
              <form action="/IoTBay/AddProductController" method="post">
                <div class="form-group col-md-10 col-lg-12">
                  <label>Name</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Name" name="name" required autofocus>
                </div>
                <div class="form-group col-md-10 col-lg-6">
                  <label>Price</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Price" name="price" required autofocus>
                </div>
                <div class="form-group col-md-10 col-lg-6">
                  <label>Quantity</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Quantity" name="quantity" required autofocus>
                </div>
                <div class="form-group col-md-10 col-lg-12">
                  <label>Description</label>
                  <!--<input type="text" class="form-control" id="exampleInputPassword1" placeholder="Tầm ảnh hưởng" name="impact" required>-->
                  <textarea class="jquery_ckeditor form-control" name="description" cols="80" rows="6" placeholder="Description"></textarea>
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
