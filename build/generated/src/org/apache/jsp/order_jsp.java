package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class order_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Order</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String emailErr = (String) session.getAttribute("emailErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String addressErr = (String) session.getAttribute("addressErr");
            String quantityErr = (String) session.getAttribute("quantityErr");
            String productErr = (String) session.getAttribute("productErr");
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class =\"title-header\"> \n");
      out.write("                <h1>Device Order Form</h1> \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <form action=\"SubmitOrderServlet\" method=\"post\">\n");
      out.write("                <h2>Order Details</h2>\n");
      out.write("                <table>\n");
      out.write("                    <tr><th><input type=\"text\" name =\"fullName\" placeholder =\"");
      out.print((nameErr != null ? nameErr: "FullName" ));
      out.write("\" required></th></tr>\n");
      out.write("                    <tr><th><input type=\"text\" name =\"email\" placeholder=\"");
      out.print((emailErr != null ? emailErr: "Email Address" ));
      out.write("\" required></th></tr>\n");
      out.write("                    <tr><th><input type=\"text\" name =\"address\" placeholder=\"");
      out.print((addressErr != null ? addressErr: "Residential Address" ));
      out.write("\" required></th></tr>\n");
      out.write("                </table>\n");
      out.write(" \n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <h2>Cart</h2>\n");
      out.write("                <table width =\"600px\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th><input type=\"text\" name=\"productId\" placeholder =\"");
      out.print((productErr != null ? productErr: "Product ID" ));
      out.write("\" required></th>\n");
      out.write("                        <th><input type=\"number\" name=\"productQty\" placeholder =\"");
      out.print((quantityErr != null ? quantityErr: "Quantity" ));
      out.write("\" required></th>\n");
      out.write("                        <th><button class=\"button\" type=\"button\">Add</button></th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>#ID</th>\n");
      out.write("                        <th>Product</th>\n");
      out.write("                        <th>Quantity</th>\n");
      out.write("                        <th>Price</th>\n");
      out.write("                        <th>Action</th>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                \n");
      out.write("                <button class=\"button\" type=\"submit\" formaction=\"SaveOrderServlet\">Save</button>\n");
      out.write("                <button class=\"button\" type=\"submit\">Checkout</button>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
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
