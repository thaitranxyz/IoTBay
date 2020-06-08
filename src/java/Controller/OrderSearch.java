/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBManager.OrderManager;
import DAO.DBManager.UserManager;
import DAO.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author theod
 */
public class OrderSearch extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        int search = Integer.parseInt(request.getParameter("search"));
        String email = request.getParameter("email");
        UserManager userManager = (UserManager) session.getAttribute("manager");
        OrderManager orderManager = (OrderManager) session.getAttribute("orderManager");
        System.out.println("past here");
        try
        {
         User user = userManager.findUserByEmail(email);
         System.out.println("past user");
         System.out.println(user.getEmail());
         int userId = user.getUserId();
         System.out.println("found user");
         Order order = orderManager.findOrderById(search, userId);
         
         if(order != null)
         {
             session.setAttribute("resultOrder", order);
             request.getRequestDispatcher("orderSearch.jsp").include(request, response);
         }
         else
         {
             session.setAttribute("resultErr", "No result");
             request.getRequestDispatcher("orderSearch.jsp").include(request, response);
         }
        }
        catch (SQLException | NullPointerException ex)
        {
            Logger.getLogger(OrderSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
