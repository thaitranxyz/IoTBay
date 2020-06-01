/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotModelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trandamtrungthai
 */
public class DBConnector extends DB {
    
    public DBConnector() throws ClassNotFoundException, SQLException  
    {
        Class.forName(driver); //create object for driver
        conn = DriverManager.getConnection(URL+db, dbUser, dbPassword);
    }
    
    public Connection openConnection() {
        return this.conn;
    }
    
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
