/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.DBManager;

import DAO.Model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author HK
 */
public class ProductManager {

    private Statement st;

    public ProductManager(Connection conn) throws SQLException{
        st = conn.createStatement();
    }

    public LinkedList<Product> productSearch(String name) throws SQLException{
        LinkedList<Product> products = new LinkedList<Product>();
        String name_cond = "";
        if(name.equals("")){
            name_cond = "true";
        }
        else{
            name_cond = "NAME LIKE '%"+name+"%'";
        }
        String fetch = "SELECT * FROM TBL_PRODUCT WHERE " + name_cond;
        ResultSet rs = st.executeQuery(fetch);
        while(rs.next()){
            products.add(
                new Product(
                    rs.getInt("ID"),
                    rs.getDouble("PRICE"),
                    rs.getInt("QUANTITY"),
                    rs.getDouble("RATING"),
                    rs.getString("DESCRIPTION"),
                    rs.getString("NAME")
                )
            );
        }
        return products;
    }
    
    public Product findById(int id) throws SQLException{
        String fetch = "SELECT * FROM TBL_PRODUCT WHERE ID = " + id;
        ResultSet rs = st.executeQuery(fetch);
        while(rs.next()){
            return new Product(
                rs.getInt("ID"),
                rs.getDouble("PRICE"),
                rs.getInt("QUANTITY"),
                rs.getDouble("RATING"),
                rs.getString("DESCRIPTION"),
                rs.getString("NAME")
            );
        }
        return null;
    }
    
    public void addProduct(double price, int quantity, double rating, String description, String name) throws SQLException{
        st.executeUpdate("INSERT INTO IOTBAY.TBL_PRODUCT (PRICE,RATING,QUANTITY,DESCRIPTION,NAME) VALUES ("+ price +","+ rating +","+ quantity +",'"+ description +"','"+ name +"')");
    }
    
    public void deleteProductById(int id) throws SQLException{
        st.executeUpdate("DELETE FROM IOTBAY.TBL_PRODUCT WHERE ID = " + id);
    }
    
    public void updateProduct(int id, double price, int quantity, String description, String name) throws SQLException{
        st.executeUpdate("UPDATE IOTBAY.TBL_PRODUCT SET NAME = '"+name+"', PRICE = "+price+", QUANTITY = "+quantity+", DESCRIPTION = '"+description+"' WHERE ID = " + id);
    }
}
