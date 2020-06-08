/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

     import java.sql.SQLException;
     import java.util.logging.Level;
     import java.util.logging.Logger;
     import javax.servlet.ServletException;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     import javax.servlet.http.HttpSession;
     import DAO.Model.User;
     import DAO.DBConnector;
     import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author Jack
 */
public class ShippingController extends HttpServlet {
    
    private User user;
    
    @Override //Create and instance of DBConnector for the deployment session
    public void init() {
        try {
            DBConnector db = new DBConnector();
            Connection conn = db.openConnection();
            user = new User(conn);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
         
         response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession();
         String address = request.getParameter("address");
         int userId = Integer.parseInt(request.getParameter("Id"));
         
             
         
             User user = user.findUser(userId);
             
             if(user != null) {
                 user.setAddress(address);
                 session.setAttribute("user", user);
                 user.updateShipping(userId, address);
                 System.out.println(user.getAddress());
                 session.setAttribute("updated","Update was successful");
                 request.getRequestDispatcher("shipping.jsp").include(request,response);
             }
             else {
                     session.setAttribute("updated","Update was not successful");
                     request.getRequestDispatcher("shipping.jsp").include(request,response);
                     }
             }
        
         
         response.sendRedirect("shipment.jsp");
}
}

