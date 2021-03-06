/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author theod
 */

import DAO.DBManager.OrderManager;
import DAO.Model.Order;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
public class TestDB {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            OrderManager db = new OrderManager(conn);
            
            String date = "07/06/2020";
            int userId = 1001;
            String email = "testemail@gmail.com";
            int productId = 2002;
            int quantity = 1;
            int transactionId = 1002;
            String address = "Test Road, Test";
            String trackingCode = "BN00002";
            String status = "Submitted";
            
            //db.addOrder("08/06/2020", 6, email, productId, quantity, transactionId, address, trackingCode, "Submitted");
            //db.updateOrder(5, "15/05/2020", userId, "byronb@gmail.com", productId, transactionId, address, trackingCode, "Submitted");
            //db.cancelOrder(3);
            
            Order temp = db.findOrderById(2, 0);
            
            ArrayList<Order> list = db.findOrderByDate("08/06/2020", 6);
            
            for(Order result:list){
                System.out.println(result.getOrderId());
            }
            
            System.out.println(temp.getEmail());
            //System.out.println("Order is added");
            connector.closeConnection();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
