package Controller;

import DAO.Model.User;
import DAO.DBManager.UserManager;
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
        UserManager manager = (UserManager) session.getAttribute("manager");
        validator.clear(session);
        
        if (!validator.validateEmail(email))
        {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else
        {
            try
            {
                User user = manager.findUser(email, password);
                if (user != null)
                {
                    session.setAttribute("user", user);
                    int userId = user.getUserId(); //get userId
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); //format date and later translate it to string
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    
                    Date date = new Date(); //date variable to hold current date time
                    
                    String loginDate = dateFormat.format(date);//format date to string
                    String loginTime = timeFormat.format(date);
                    
                    manager.addAccessLogin(userId, loginDate, loginTime);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
                else
                {
                    session.setAttribute("loginErr", "Error: Username or password incorrect");
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