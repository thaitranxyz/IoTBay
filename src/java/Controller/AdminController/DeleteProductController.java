/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AdminController;

import DAO.DBManager.ProductManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HK
 */
public class DeleteProductController extends HttpServlet{
    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String msg = "";
        HttpSession session = request.getSession();
        int id  = Integer.parseInt(request.getParameter("id"));
        ProductManager productManager = (ProductManager) session.getAttribute("products");
        try {
            productManager.deleteProductById(id);
            msg = msg + "<div class='alert alert-success' role='alert'>Product deleted</div>";
        } catch (SQLException ex) {
            msg = msg + "<div class='alert alert-danger' role='alert'>"+ex.getMessage()+"</div>";
        }
        session.setAttribute("msg",msg);
        request.getRequestDispatcher("/AdminController").include(request, response);
    }
}
