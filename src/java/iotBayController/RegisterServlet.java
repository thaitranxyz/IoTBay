/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        int phone = Integer.parseInt(request.getParameter("phone"));
        String password = request.getParameter("password");
        String rePass = request.getParameter("rePassword");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
       
        
        if (!validator.validateEmail(email))
        {
            session.setAttribute("emailErr", "Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else if (password != rePass)
        {
            session.setAttribute("passErr", "Password does not match");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        else
        {
            try
            {
                User exist = manager.findUserByEmail(email);
                if (exist.getEmail().equals(email))
                {
                    session.setAttribute("existErr", "Email already exist!");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }
                else
                {
                   manager.addUser(firstName, lastName, email, password, phone, address);
                   User userToFind = manager.findUser(email, password);
                   int userId = userToFind.getUserId(); //get userId
                   User user = new User(userId, firstName, lastName, email, password, phone, address);
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
