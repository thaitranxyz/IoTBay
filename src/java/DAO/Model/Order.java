/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author theod
 */
public class Order implements Serializable {
    
    private int orderId;
    private String date;
    private String email;
    private int userId;
    private int productId;
    private int transactionId;
    private String address;
    private String status;
    private String trackingCode;
    //ArrayList<String> cartItems = new ArrayList();

    public Order(int orderId, String date, String email, int userId, int productId, 
            int transactionId, String address, String trackingCode, String status) {
        this.orderId = orderId;
        this.date = date;
        this.email = email;
        this.userId = userId;
        this.productId = productId;
        this.transactionId = transactionId;
        this.address = address;
        this.trackingCode = trackingCode;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }
    
    
    
    
}
