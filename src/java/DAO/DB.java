/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author trandamtrungthai
 */
public class DB {

    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db =  "User";
    protected String dbUser = "IoTBay";
    protected String dbPassword = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
    
}
