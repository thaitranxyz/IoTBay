
package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.Model.User;
import DAO.DBConnector;
import DAO.Model.Shipment;

@WebServlet(name = "ShippingServlet", urlPatterns = {"/ShippingServlet"})
public class ShippingServlet extends HttpServlet {
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {   
        
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("id"));
        user = (User) session.getAttribute("user");
        
        
       
            User user = user.findUser(userId);
            if (user != null) {
                session.setAttribute("user", user);
                System.out.println(user.getAddress());
                request.getRequestDispatcher("shipping.jsp").include(request,response);
            } else {
                session.setAttribute("existErr","User does not exist in the Database");
                request.getRequestDispatcher("shipping.jsp").include(request,response);
            }
        
        
       
        
        
    }

    

}
