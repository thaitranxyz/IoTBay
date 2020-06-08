/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Wenbo Zhang
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.Model.User;
import DAO.Model.Payment;
import DAO.DBConnector;
import DAO.DBManager.PaymentManager;

public class PaymentServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaymentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
               HttpSession session = request.getSession();
        String action = request.getParameter("action");
            
            try {
                DBConnector connector = new DBConnector();
                Connection conn = connector.openConnection();
                PaymentManager manager = new PaymentManager(conn);
                
                    if (action.equalsIgnoreCase("viewList")){
                        try {
                            User user = (User)session.getAttribute("user");
                            ArrayList<Payment> paymentList = (ArrayList<Payment>) manager.getPaymentList(user.getUserId());
                            session.setAttribute("paymentList", paymentList);
                            request.getRequestDispatcher("viewPaymentList.jsp").forward(request, response);
                        } 
                        catch (Exception ex) {
                            System.out.print(ex);
                        }
                    }
                    else if(action.equalsIgnoreCase("delete")){
                        int number = Integer.parseInt(request.getParameter("number"));
                        ArrayList<Payment> paymentList = (ArrayList<Payment>)session.getAttribute("paymentList");
                        manager.deletePaymentDetails(paymentList.get(number).getCreditCardNumber());
                        paymentList.remove(paymentList.get(number));
                        session.setAttribute("paymentList", paymentList);
                        request.getRequestDispatcher("viewPaymentList.jsp").forward(request, response);
                    }
                    else if(action.equalsIgnoreCase("update")){
                        System.out.print("Executed update if statemetn");
                        int index = Integer.parseInt(request.getParameter("index"));
                        ArrayList<Payment> paymentList = (ArrayList<Payment>)session.getAttribute("paymentList");
                        session.setAttribute("oldPayment", paymentList.get(index));
                        session.setAttribute("CCNMsg", null);
                        session.setAttribute("CCEMsg", null);
                        session.setAttribute("CCCVCMsg", null);
                        session.setAttribute("SuccessUpdate", null);
                        request.getRequestDispatcher("updatePayment.jsp").forward(request, response);
                    }
            }
            catch (Exception ex){
                System.out.print("Payment Servlet Database access error: " + ex);
            }
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
