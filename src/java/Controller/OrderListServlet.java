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
import java.util.ArrayList;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author theod
 */
public class OrderListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        UserManager userManager = (UserManager) session.getAttribute("manager");
        OrderManager orderManager = (OrderManager) session.getAttribute("orderManager");
                
        try
        {
            
            User user = userManager.findUserByEmail(email);
            if (user!= null){
                int userId = user.getUserId();
                ArrayList<Order> orderList = orderManager.fetchOrderList(userId);
                session.setAttribute("orderList", orderList);
                request.getRequestDispatcher("orderList.jsp").include(request, response);  
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(OrderListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
