package iotBayController;

import Model.User;
import iotModelDAO.DBManager;
import java.io.IOException;
import java.sql.SQLException;
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
        User user = null;
        validator.clear(session);
        
        if (!validator.validateEmail(email))
        {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else if (!validator.validatePassword(password))
        {   
            session.setAttribute("passwordErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else
        {
            try
            {
                user = manager.findUser(email, password);
                if (user != null)
                {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                    
                }
                else if (user == null)
                {
                    session.setAttribute("existErr", "Error: Username or password incorrect");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            }
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
        
        
    }
}