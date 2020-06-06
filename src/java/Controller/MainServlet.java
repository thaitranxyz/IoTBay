/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Model.User;
import DAO.DBManager.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trandamtrungthai
 */
public class MainServlet extends HttpServlet {

    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String address = request.getParameter("address");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String password = request.getParameter("password");
//        UserManager manager = (UserManager) session.getAttribute("manager");
        request.getRequestDispatcher("main.jsp").include(request, response);
        
//        try
//        {
//            
//            User exist = manager.findUserByEmail(email);
//            int userId = exist.getUserId();
//            int role = exist.getRole();
//            User user = new User(userId, firstName, lastName, email, password, phone, address, role);
//            System.out.print(user.getEmail() + user.getPassword());
//            if (user != null)
//            {
//                session.setAttribute("user", user);
//                request.getRequestDispatcher("main.jsp").include(request, response);
//            }
//            else
//            {
//                session.setAttribute("existErr", "User not exist");
//                request.getRequestDispatcher("edit.jsp").include(request, response);
//            }
//        }
//        catch (SQLException | NullPointerException ex) 
//        {
//            System.out.println(ex.getMessage());
//        }
    }

}
