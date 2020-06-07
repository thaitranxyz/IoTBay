/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBManager.UserManager;
import DAO.Model.AccessLog;
import DAO.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class AccessLogServlet extends HttpServlet {

    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
//        String password = request.getParameter("password");
        UserManager manager = (UserManager) session.getAttribute("manager");
        
        try 
        {
            User user = manager.findUserByEmail(email);
            int userId = user.getUserId();
            if (user != null)
            {
                ArrayList<AccessLog> list = manager.findAccessLog(userId);
                session.setAttribute("list", list);
                request.getRequestDispatcher("accesslog.jsp").include(request, response);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(AccessLogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
