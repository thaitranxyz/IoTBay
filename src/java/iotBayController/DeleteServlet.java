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
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        try
        {
            System.out.println(email);
            
            manager.deleteUser(email);
//            User user = manager.findUserByEmail(email);
//            if (user == null)
//            {
//                System.out.println("NULL");
//            }
            request.getRequestDispatcher("index.jsp").include(request, response);
//            User user = manager.findUserByEmail(email);
//            if (user != null)
//            {
//                manager.deleteUser(email);
//                request.getRequestDispatcher("index.jsp").include(request, response);
//            }
//            else
//            {
//                session.setAttribute("existErr", "User not exist");
//                request.getRequestDispatcher("edit.jsp").include(request, response);
//            }
            
//           
        }
//        catch (SQLException ex)
//        {
//            System.out.println(ex.getMessage());
        catch (SQLException ex) 
        {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
