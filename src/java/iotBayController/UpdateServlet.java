/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotBayController;

import Model.User;
import iotModelDAO.DBManager;
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
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String rePassword = request.getParameter("rePassword");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try {
            User info = manager.findUserByEmail(email);
            int userId = info.getUserId();
            int role = info.getRole();
            User user = new User(userId, firstName, lastName, email, password, phone, address, role);
            if (user != null)
            {
                session.setAttribute("user", user);
                manager.updateUser(firstName, lastName, email, password, phone, address);
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
            else
            {
                 session.setAttribute("updated", "Update was not successful");
                 request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }       

}
