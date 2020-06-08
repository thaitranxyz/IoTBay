package DAO.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Shipment implements java.io.Serializable {
    
    private int shipmentId;
    private int orderId;
    private int userId;
    private String address;
    private String status;
    
    public Shipment(int shipmentId, int orderId, int userId, String address, String status) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.userId = userId;
        this.address = address;
        this.status = status; 
    }
    
    public int getShipmentId() {
        return shipmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }


    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }
    
    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}