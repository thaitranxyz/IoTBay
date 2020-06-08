<%
    String active = "";
    if(session.getAttribute("active") != null){
        active = (String) session.getAttribute("active");
    } 
%>
<ul class="nav nav-sidebar">
    <li <% if(active == "Add Product") {out.println("class = 'active'");}%>><a href="/IoTBayApp/admin/admin-add-product.jsp">Add new product</a></li>
    <li <% if(active == "Manage Products") {out.println("class = 'active'");}%>><a href="/IoTBayApp/AdminController?name=">Manage product</a></li>
</ul>
          <!--<ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>-->