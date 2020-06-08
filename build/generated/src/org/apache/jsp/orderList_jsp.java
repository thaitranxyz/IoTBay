package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import DAO.Model.*;

public final class orderList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>IoTBay</title>\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            .table {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                /*border-collapse: collaspe;*/\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .table th, .table td {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                padding: 8px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            User user = (User)session.getAttribute("user");
            ArrayList<Order> orderList = (ArrayList)session.getAttribute("orderList");
            
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form action=\"\" method=\"get\">\n");
      out.write("                <input name =\"search\" placeholder=\"Search by OrderId or Date\">\n");
      out.write("                <button type=\"submit\" class=\"button\" id=\"search\">Search</button>\n");
      out.write("            </form>\n");
      out.write("            <table class=\"table\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Order Id</th>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Transaction ID</th>\n");
      out.write("                        <th>Product ID</th>\n");
      out.write("                        <th>Quantity</th>\n");
      out.write("                        <th>Tracking Code</th>\n");
      out.write("                        <th>Status</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        ");
for (Order o: orderList){
      out.write("\n");
      out.write("                        <td>");
      out.print(o.getOrderId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getTransactionId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getProductId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getQuantity());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getTrackingCode());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getStatus());
      out.write("</td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
