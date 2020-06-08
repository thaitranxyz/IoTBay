package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.Model.Customer;
import DAO.Model.Payment;

public final class paymentDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("        <title>Add Payment Details</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>IoTBay</h1>\n");
      out.write("        <div class=\"top_right_link_div\">\n");
      out.write("            <a href=\"logout.jsp\">Logout</a>\n");
      out.write("            <a href=\"main.jsp\">Home</a>\n");
      out.write("            <a href=\"PaymentServlet?action=viewList&origin=1\">View Payment history</a>\n");
      out.write("        </div>\n");
      out.write("        ");

            Customer customer = (Customer)session.getAttribute("customer");
            String CCNErr = (String) session.getAttribute("CCNErr");
            String CCEErr = (String) session.getAttribute("CCEErr");
            String CCCVCErr = (String) session.getAttribute("CCCVCErr");
            String Success = (String) session.getAttribute("Success");
            String isUpdate = (String) session.getAttribute("isUpdate");
        
      out.write("\n");
      out.write("        <h2>Add Payment</h2>\n");
      out.write("        <form action=\"AddPaymentServlet\" method=\"post\">\n");
      out.write("            ");

                if(Success!=null){
            
      out.write("\n");
      out.write("            <h2>");
      out.print(Success);
      out.write("</h2>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"CCN\">Credit Card Number</label></td>\n");
      out.write("                    <td><input class=\"form_input_box\" type=\"text\" id =\"frame\" name=\"CCN\" placeholder=\"");
      out.print((CCNErr != null ? CCNErr : "5236172635167576") );
      out.write("\" required></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"CCE\">Credit Card Expiry</label></td>\n");
      out.write("                    <td><input class=\"form_input_box\" type=\"text\" id =\"frame\" name=\"CCE\" placeholder=\"");
      out.print((CCEErr != null ? CCEErr : "20/20") );
      out.write("\" required></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"CCCVC\">Credit Card CVC</label></td>\n");
      out.write("                    <td><input class=\"form_input_box\" type=\"text\" id =\"frame\" name=\"CCCVC\" placeholder=\"");
      out.print((CCCVCErr != null ? CCCVCErr : "222") );
      out.write("\" required></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"isDefault\">As default payment</label></td>\n");
      out.write("                    <td><input type=\"checkbox\" name=\"Chkbox\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>\n");
      out.write("                <center>\n");
      out.write("                    <input type=\"hidden\" name=\"isUpdate\" value=\"false\">\n");
      out.write("                    <input type=\"hidden\" name=\"oldPayment\" value=\"null\">\n");
      out.write("                    <input type=\"hidden\" name=\"origin\" value=\"1\">\n");
      out.write("                    <input class=\"button\" type=\"submit\" value=\"Confirm\" required>\n");
      out.write("                </center>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
