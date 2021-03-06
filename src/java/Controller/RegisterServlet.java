/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author trandamtrungthai
 */
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String rePass = request.getParameter("rePassword");
        UserManager manager = (UserManager) session.getAttribute("manager");
        validator.clear(session);
       
        
        if (!validator.validateEmail(email))
        {
            session.setAttribute("emailErr", "Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else if (!validator.validateFirstName(firstName))
        {
            session.setAttribute("firstNameErr", "First Name format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else if (!validator.validateLastName(lastName))
        {
            session.setAttribute("lastNameErr", "Last Name format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else if (!validator.validatePhone(phone))
        {
            session.setAttribute("phoneErr", "Please enter valid phone number");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else if (!validator.validatePassword(password))
        {
            session.setAttribute("passwordErr", "Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else if (!password.equals(rePass))
        {
            session.setAttribute("passwordErr", "Password does not match");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else
        {
            try
            {
                User exist = manager.findUserByEmail(email);
                if (exist != null)
                {
                    session.setAttribute("existErr", "Email already exist!");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }
                else
                {
                   manager.addUser(firstName, lastName, email, password, phone, address);
                   
                   User userToFind = manager.findUser(email, password);
                   int userId = userToFind.getUserId(); //get userId
                   int role = userToFind.getRole();
                   
                   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); //format date and later translate it to string
                   DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    
                   Date date = new Date(); //date variable to hold current date time
                    
                   String loginDate = dateFormat.format(date);//format date to string
                   String loginTime = timeFormat.format(date);
                    
                   manager.addAccessLogin(userId, loginDate, loginTime);
                   
                   User user = new User(userId, firstName, lastName, email, password, phone, address, role);
                   
                   session.setAttribute("user", user);
                   request.getRequestDispatcher("main.jsp").include(request, response);
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
        
    

}
