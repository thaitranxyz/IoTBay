/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AdminController;

import DAO.DBManager.ProductManager;
import DAO.Model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HK
 */
public class AdminController extends HttpServlet {

    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String msg = "";
        LinkedList<Product> products;
        HttpSession session = request.getSession();
        String searchParam  = request.getParameter("name");
        ProductManager productManager = (ProductManager) session.getAttribute("products");
        try {
            if(searchParam != null){
                products = productManager.productSearch(searchParam);
            }
            else
            {
                products = productManager.productSearch("");
            }
            session.setAttribute("productList", products);
        } catch (SQLException ex) {
            msg = msg + "<div class='alert alert-danger' role='alert'>"+ex.getMessage()+"</div>";
        }
        request.getRequestDispatcher("admin/index.jsp").include(request, response);
    }
}
