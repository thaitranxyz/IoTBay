package iotBayController;

import Model.User;
import iotModelDAO.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


public class LoginServlet extends HttpServlet
{    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
//        User user = null;
        validator.clear(session);
        
        if (!validator.validateEmail(email))
        {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
//        else if (!validator.validatePassword(password))
//        {   
//            session.setAttribute("passwordErr", "Error: Password format incorrect");
//            request.getRequestDispatcher("login.jsp").include(request, response);
//        }
        else
        {
            try
            {
                User user = manager.findUser(email, password);
                if (user != null)
                {
                    session.setAttribute("user", user);
                    int userId = user.getUserId();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //format date and later translate it to string
                    Date date = new Date(); //date variable to hold current date time
                    String loginDate = dateFormat.format(date);//format date to string
                    
                    manager.addAccessLogin(userId, loginDate);
                    
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
                else
                {
                    session.setAttribute("existErr", "Error: Username or password incorrect");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            }
            catch (SQLException | NullPointerException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}