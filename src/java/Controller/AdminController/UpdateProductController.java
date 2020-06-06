/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AdminController;

import Controller.Validator;
import DAO.DBManager.ProductManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HK
 */
public class UpdateProductController extends HttpServlet{
    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String msg = "";
        Boolean boo = true;
        Validator validator = new Validator();
        HttpSession session = request.getSession();
        ProductManager productManager = (ProductManager) session.getAttribute("products");
        String price   = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        if(!validator.validateInteger(quantity)){
            msg = msg + "<div class='alert alert-danger' role='alert'>Quality is not valid</div>";
            boo = false;
        }
        if(!validator.validateDouble(price)){
            msg = msg + "<div class='alert alert-danger' role='alert'>Price is not valid</div>";
            boo = false;
        }
        if(boo){
            try {
                productManager.updateProduct(
                        id,
                        Double.parseDouble(price), 
                        Integer.parseInt(quantity),
                        request.getParameter("description"), 
                        request.getParameter("name")
                );
                msg = msg + "<div class='alert alert-success' role='alert'>Product updated</div>";
            } catch (SQLException ex) {
                msg = msg + "<div class='alert alert-danger' role='alert'>"+ex.getMessage()+"</div>";
            }
        }
        try {
            session.setAttribute("product",productManager.findById(id));
        } catch (SQLException ex) {
            msg = msg + "<div class='alert alert-danger' role='alert'>"+ex.getMessage()+"</div>";
        }
        session.setAttribute("msg",msg);
        
        request.getRequestDispatcher("admin/admin-update-product.jsp").include(request, response);
    }
    
}
