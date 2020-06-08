/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.DBManager;

import DAO.Model.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author theod
 */
public class OrderManager {
    
    private Statement st;
    
    public OrderManager(Connection conn) throws SQLException
    {
        st = conn.createStatement();
    }
    //add reduce quantity in product table, add quantity field in ordertable / change to cartitems
    //test for null userid case (anonymous user) -- > DONE
    public void addOrder(String date, int userId, String email, int productId, int quantity, int transactionId, String address, String trackingCode, String status) throws SQLException
    {
        st.executeUpdate("INSERT INTO IOTBAY.ORDERS (EMAIL, DATE, USERID, PRODUCTID, QUANTITY, TRANSACTIONID, ADDRESS, STATUS, TRACKINGCODE) VALUES ('" + email + "', '" 
                + date + "', " + userId + ", " + productId + ", " + quantity + ", " + transactionId + ", '" + address + "', '" + status + "', '" + trackingCode + "')");    
    }
    
    //test to see if this works
    public void updateOrder(int orderId, String date, int userId, String email, int productId, int transactionId, String address, String trackingCode, String status) throws SQLException
    {
        st.executeUpdate("UPDATE IOTBAY.ORDERS SET EMAIL='" + email + "', DATE ='" + date + "', USERID =" +userId+", TRANSACTIONID =" + transactionId + ", ADDRESS ='"
                + address + "', TRACKINGCODE ='" + trackingCode + "', STATUS ='" + status + "' WHERE ORDERID=" + orderId);
    }
    //changes order status to cancelled
    //add increase quantity back into the product table for cancelled orders
    public void cancelOrder(int orderId) throws SQLException 
    {
        st.executeUpdate("UPDATE IOTBAY.ORDERS SET STATUS = 'Cancelled' WHERE ORDERID=" + orderId);
       //TODO: add remaining quantity to product table
    }
    
    //returns all saved orders by the userid
    //TODO: test 
    public ArrayList<Order> fetchSavedOrders(int userId) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.ORDERS WHERE USERID =" + userId +"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()){
            String status = rs.getString(8);
            int resultId = rs.getInt(4);
            
            if ((status.equals("Saved")) && (resultId == userId)){
                int orderId = rs.getInt(1);
                String email = rs.getString(2);
                String date = rs.getString(3);
                int productId = rs.getInt(5);
                int transactionId = rs.getInt(6);
                String address = rs.getString(7);
                String trackingCode = rs.getString(9);
                temp.add(new Order(orderId, date, email, resultId, productId, transactionId, address, trackingCode, status));
            }
        }
        
        return temp;
    }
    
    //returns all orders made by the user, saved, submitted, cancelled
    //TODO: test 
    public ArrayList<Order> fetchOrderList(int userId) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.ORDERS WHERE USERID =" + userId +""; 
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()){
            int resultId = rs.getInt(4);
            
            if (resultId == userId){
                int orderId = rs.getInt(1);
                String email = rs.getString(2);
                String date = rs.getString(3);
                int productId = rs.getInt(5);
                int transactionId = rs.getInt(6);
                String address = rs.getString(7);
                String status = rs.getString (8);
                String trackingCode = rs.getString(9);   
                temp.add(new Order(orderId, date, email, resultId, productId, transactionId, address, trackingCode, status));
            }
        }
        return temp;
    }
    
    //todo add date search as well 
    public Order findOrderById(int orderId) throws SQLException {
        String fetch = "SELECT * FROM IOTBAY.ORDERS WHERE ORDERID =" + orderId + "";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            int resultId = rs.getInt(1);
            
            if(resultId == orderId){
                String email = rs.getString(2);
                String date = rs.getString(3);
                int userId = rs.getInt(4);
                int productId = rs.getInt(5);
                int transactionId = rs.getInt(6);
                String address = rs.getString(7);
                String status = rs.getString (8);
                String trackingCode = rs.getString(9);
                return new Order(resultId, date, email, userId, productId, transactionId, address, trackingCode, status);
            }
            
        }
        return null;
    }
    
    public Order findOrderByDate(String date) throws SQLException {
        return null;
    }
    
}