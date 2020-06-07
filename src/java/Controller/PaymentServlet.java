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
                //
                    if (action.equalsIgnoreCase("viewList")){
                        try {
                            int origin = Integer.parseInt(request.getParameter("origin"));
                            ArrayList<Payment> paymentList = (ArrayList<Payment>) manager.getPaymentList(origin);
                            System.out.print("retrieved list");
                            System.out.print(paymentList);
                            session.setAttribute("paymentList", paymentList);
                            System.out.print("Set attribute");
                            request.getRequestDispatcher("viewPaymentList.jsp").forward(request, response);
                            System.out.print("get request");
                        } 
                        catch (Exception ex) {
                            System.out.print(ex);
                        }
                    }
                    else if(action.equalsIgnoreCase("delete")){
                        String number = request.getParameter("number");
                        manager.deletePaymentDetails(number);
                    }
                //
            }
            catch (Exception ex){
                System.out.print(ex);
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
