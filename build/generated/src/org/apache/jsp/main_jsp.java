package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.Model.User;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            .button {\n");
      out.write("                padding: 8px 17px;\n");
      out.write("                background-color: #00b894;\n");
      out.write("                color: white;\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                border: 0;\n");
      out.write("                font-size: 15px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                position: relative;\n");
      out.write("                text-decoration: none;\n");
      out.write("                float: right;\n");
      out.write("                /*border: 1px solid #00b894;*/\n");
      out.write("                margin-right: 5px; \n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .button:hover {\n");
      out.write("                background-color: #b2bec3;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #user {\n");
      out.write("                position: fixed;\n");
      out.write("                /*float: right;*/\n");
      out.write("                \n");
      out.write("                top: 2.5em;\n");
      out.write("                right: 1em;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            User user = (User) session.getAttribute("user");
        
      out.write("\n");
      out.write("        <!--<a href=\"welcome.jsp\" class=\"button\">Go back</a>-->\n");
      out.write("        <a href=\"LogoutServlet?email=");
      out.print(user.getEmail());
      out.write("\" class=\"button\">Logout</a>\n");
      out.write("        <a href=\"EditServlet?email='");
      out.print(user.getEmail());
      out.write("'&password='");
      out.print(user.getPassword());
      out.write("'\" class=\"button\">Edit</a>\n");
      out.write("        <a href=\"AccessLogServlet?email='");
      out.print(user.getEmail());
      out.write("'&password='");
      out.print(user.getPassword());
      out.write("'\" class=\"button\">Access Log</a>\n");
      out.write("        <div>\n");
      out.write("            <p id=\"user\">You are logged in as <b>&lt");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&gt</b></p>\n");
      out.write("           \n");
      out.write("             \n");
      out.write("        </div>\n");
      out.write("        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(',');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(',');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "profile.jsp", out, true);
      out.write("\n");
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
