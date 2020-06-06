<%@page import="DAO.Model.User"%>
<%
    //check admin value in the session
    if(session.getAttribute("user") != null){
        User user = (User)session.getAttribute("user");
        if(user.getRole() != 1){
             response.sendRedirect("main.jsp");
        }
    }
    response.sendRedirect("index.jsp");
%>