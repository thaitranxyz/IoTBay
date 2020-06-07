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
public class SearchServlet extends HttpServlet {

    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String search = request.getParameter("search");
        String email = request.getParameter("email");
        UserManager manager = (UserManager) session.getAttribute("manager");
        validator.clear(session);
        User user = null;
        try 
        {
            user = manager.findUserByEmail(email);
            System.out.println(user.getEmail() + " " + user.getAddress());
            int userId = user.getUserId();

            ArrayList<AccessLog> list = manager.findAccessLogByDate(search, userId);
            
           
            if (list != null)
            {
                 session.setAttribute("list", list);
                 request.getRequestDispatcher("search.jsp").include(request, response);
            }
            else
            {
                session.setAttribute("resultErr", "No result");
                request.getRequestDispatcher("search.jsp").include(request, response);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
