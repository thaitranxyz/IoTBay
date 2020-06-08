package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Register Page</title>\n");
      out.write("        <style>\n");
      out.write("            form {\n");
      out.write("               display: grid;\n");
      out.write("               width: 50%;   \n");
      out.write("               /*padding: 2spx;*/\n");
      out.write("               margin: 0 auto;\n");
      out.write("               margin-top: -20px;\n");
      out.write("               /*border-spacing: 5px;*/\n");
      out.write("               /*border: 1px solid black;*/\n");
      out.write("             }\n");
      out.write("            \n");
      out.write("             input {\n");
      out.write("                 padding: 30px;\n");
      out.write("                 font-size: 18px;\n");
      out.write("                 margin-top: 10px;\n");
      out.write("             }\n");
      out.write("             \n");
      out.write("             .button {\n");
      out.write("                 width: 100%;\n");
      out.write("                 padding: 20px;\n");
      out.write("                 margin: 0 auto; \n");
      out.write("                 margin-top: 10px;\n");
      out.write("                 background-color: #00b894;\n");
      out.write("                 color: white;\n");
      out.write("                 border: 0;\n");
      out.write("                 font-size: 20px;\n");
      out.write("                 cursor: pointer;\n");
      out.write("             }\n");
      out.write("             \n");
      out.write("             #cancel-btn {\n");
      out.write("                 background-color: grey;\n");
      out.write("             }\n");
      out.write("             \n");
      out.write("             .title-header {\n");
      out.write("                 font-family: sans-serif;\n");
      out.write("                 font-size: 25px;\n");
      out.write("                 text-align: center;\n");
      out.write("                 padding: 10px;\n");
      out.write("                 color: #00b894;   \n");
      out.write("             }\n");
      out.write("             \n");
      out.write("             .text {\n");
      out.write("                 text-align: center;\n");
      out.write("                 font-family: sans-serif;\n");
      out.write("             }\n");
      out.write("             \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String existErr = (String) session.getAttribute("existErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String phoneErr = (String) session.getAttribute("phoneErr");
        
      out.write("\n");
      out.write("         \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"title-header\">\n");
      out.write("                <h1>Register Account</h1>\n");
      out.write("<!--                <h4>");
      out.print((passErr != null ? passErr: ""));
      out.write("</h4>\n");
      out.write("                <h4>");
      out.print((emailErr != null ? emailErr : ""));
      out.write("</h4>-->\n");
      out.write("                <p class=\"text\">Password must be at least 8 characters and containing: uppercase, lowercase and number</p>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <form action=\"RegisterServlet\" method=\"post\">\n");
      out.write("                <input type=\"text\" name=\"firstName\" placeholder=\"");
      out.print((firstNameErr != null ? firstNameErr: "First Name"));
      out.write("\" required>\n");
      out.write("                <input type=\"text\" name=\"lastName\" placeholder=\"");
      out.print((lastNameErr != null ? lastNameErr: "Last Name"));
      out.write("\" required>\n");
      out.write("                <input type=\"text\" name=\"email\" placeholder=\"");
      out.print((emailErr != null ? emailErr : "Email Address"));
      out.write("\" required>\n");
      out.write("                <input type=\"tel\" name=\"phone\" placeholder=\"");
      out.print((phoneErr != null ? phoneErr : "Phone Number"));
      out.write("\" required>\n");
      out.write("                <input type=\"text\" name=\"address\" placeholder=\"Address\" required>\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"");
      out.print((passErr != null ? passErr :  "Password"));
      out.write("\" required>\n");
      out.write("                <input type=\"password\" name=\"rePassword\" placeholder=\"Re-enter Password\" required>\n");
      out.write("                <button class=\"button\" type=\"submit\">Submit</button>\n");
      out.write("                <button class=\"button\" id=\"cancel-btn\" type=\"button\" onclick=\"window.location='index.jsp'\">Cancel</button>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("   \n");
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
