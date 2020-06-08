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
  import java.sql.Connection;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import javax.servlet.http.HttpSession;
  import DAO.DBManager.PaymentManager;
  import DAO.DBConnector;
  import DAO.Model.Payment;

     public class AddPaymentServlet extends HttpServlet {
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             HttpSession session = request.getSession();
             Validator validator = new Validator();
             String CCN = request.getParameter("CCN");
             String isUpdate = request.getParameter("isUpdate");
             String CCE = request.getParameter("CCE");
             String CCCVC = request.getParameter("CCCVC");
             String Checkbox = request.getParameter("Checkbox");
             int isDefault = 0;
             if (Checkbox!=null){
                 isDefault = 1;
             }
             int origin = Integer.parseInt(request.getParameter("origin"));
             try {
                DBConnector connector = new DBConnector();
                Connection conn = connector.openConnection();
                PaymentManager db = new PaymentManager(conn);
           
                if(isUpdate.equals("true")){
                    String oldNumber = request.getParameter("oldNumber");
                 if (!validator.validateCreditCardNumber(CCN)) {
                        session.setAttribute("CCNMsg", "Error:Credit card format incorrect");
                        request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                 }
                 else if (!validator.validateCreditCardExpiry(CCE)){
                     session.setAttribute("CCEMsg", "Error:Credit Card Expiry format incorrect");
                     request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                 }
                 else if (!validator.validateCreditCardCVC(CCCVC)){
                     session.setAttribute("CCCVCMsg", "Error:Credit Card CVC format incorrect");
                     request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                 }
                 else{
                     try{
                         if(isDefault==1){
                             Payment defaultPaymentId = db.getDefaultPayment(origin);
                             try {
                                 db.updatePaymentDetails(defaultPaymentId.getCreditCardNumber(), defaultPaymentId.getCreditCardNumber(), defaultPaymentId.getCreditCardExpiry(), defaultPaymentId.getCreditCardCVC(), 0);
                             }
                             catch (Exception e){
                                 System.out.print("Unable to remove default payment:" + e);
                             }
                         }
                         db.updatePaymentDetails(oldNumber,CCN, CCE, CCCVC, isDefault);
                         session.setAttribute("SuccessUpdate", "Successfully updated payment details");
                         session.setAttribute("CCNMsg", CCN);
                         session.setAttribute("CCEMsg", CCE);
                         session.setAttribute("CCCVCMsg", CCCVC);
                         request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                     }
                     catch(Exception e){
                         System.out.print(e);
                         session.setAttribute("Success", "Unable to add payment details");
                         request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                     }
                 }
                }
                else{
                 if (!validator.validateCreditCardNumber(CCN)) {
                     session.setAttribute("CCNErr", "Error:Credit card format incorrect");
                     request.getRequestDispatcher("paymentDetail.jsp").include(request, response);
                 }
                 else if (!validator.validateCreditCardExpiry(CCE)){
                     session.setAttribute("CCEErr", "Error:Credit Card Expiry format incorrect");
                     request.getRequestDispatcher("paymentDetail.jsp").include(request, response);
                 }
                 else if (!validator.validateCreditCardCVC(CCCVC)){
                     session.setAttribute("CCCVCErr", "Error:Credit Card CVC format incorrect");
                     request.getRequestDispatcher("paymentDetail.jsp").include(request, response);
                 }
                 else{
                     try{
                         if(isDefault==1){
                             Payment defaultPaymentId = db.getDefaultPayment(origin);
                             try {
                                 db.updatePaymentDetails(defaultPaymentId.getCreditCardNumber(), defaultPaymentId.getCreditCardNumber(), defaultPaymentId.getCreditCardExpiry(), defaultPaymentId.getCreditCardCVC(), 0);
                             }
                             catch (Exception e){
                                 System.out.print("Unable to remove default payment:" + e);
                             }
                         }
                         db.addPaymentDetails(CCN, CCE, CCCVC, isDefault, origin);
                         session.setAttribute("Success", "Successfully added payment details");
                         request.getRequestDispatcher("paymentDetail.jsp").include(request, response);
                     }
                     catch(Exception e){
                         System.out.print(e);
                         session.setAttribute("Success", "Unable to add payment details");
                         request.getRequestDispatcher("paymentDetail.jsp").include(request, response);
                     }
                 }
                }
             }
             catch (Exception ex){
                 System.out.print(ex);
             }
     }
     }
