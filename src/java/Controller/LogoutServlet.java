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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        UserManager manager = (UserManager) session.getAttribute("manager");
        String email = request.getParameter("email");
        try 
        {
            User exist = manager.findUserByEmail(email);
            
            int userId = exist.getUserId();
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); //format date and later translate it to string
            DateFormat timeFormat = new SimpleDateFormat(" HH:mm:ss");
            
            Date date = new Date(); //date variable to hold current date time
            
            String logoutDate = dateFormat.format(date);//format date to string
            String logoutTime = timeFormat.format(date);//format time to string
            
            String loginDate = manager.findLoginDate(userId); //find user login date 
            String loginTime = manager.findLoginTime(userId); // find user login time where logout date and time is null
            
            System.out.println(loginDate);
            
            manager.updateAccessLogout(userId, loginDate, loginTime, logoutDate, logoutTime); //add value to logoutdatetime column
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (session.getAttribute("user") != null)
        {
            session.removeAttribute("user");
        }
        session.invalidate();
        session = request.getSession(false);
        
        
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
    

}
