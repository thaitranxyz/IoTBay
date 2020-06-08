/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBManager.*;
import DAO.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author theod
 */
public class SubmitOrderServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int product = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("productQty"));
        OrderManager ordManager = (OrderManager) session.getAttribute("orderManager");
        UserManager userManager = (UserManager) session.getAttribute("manager");
        //ProductManager prodManager = (ProductManager) session.getAttribute("prodManager");
        validator.clear(session);
        log("Init done");
        
        
        if (!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("order.jsp").include(request, response);
        }
        else if (!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: Name format incorrect");
            request.getRequestDispatcher("order.jsp").include (request, response);
        }
       // else if (!validator.validateAddress(address)){
      //      session.setAttribute("addressErr", "Error: Address format incorrect");
       //     request.getRequestDispatcher("order.jsp").include (request, response);
      //  }
        //TODO add product code validation
        else if (quantity < 1){
            session.setAttribute("quantityErr", "Error: Quantity is invalid");
            request.getRequestDispatcher("order.jsp").include (request, response);
        }
        else {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            System.out.println("Past date");
            
            User user = (User)session.getAttribute("user");
            int userId = 0;
            if (user != null){
                userId = user.getUserId();
            }
            else 
            {
                userId = 0;
            }      
            
            int transactionId = 0;
            String trackingCode = "BN0001";
            String status = "Submitted";
            
            ordManager.addOrder(sdf.format(date), userId, email, product, quantity, transactionId, address, trackingCode, status);
            request.getRequestDispatcher("orderSuccess.jsp").include(request, response);
                
            }
            catch (SQLException | NullPointerException ex)
            {
                log(ex.getMessage());
            }

            
            
        }
    }
    
}
