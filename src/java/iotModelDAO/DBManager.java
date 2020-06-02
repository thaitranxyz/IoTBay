    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotModelDAO;

import Model.User;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author trandamtrungthai
 */
public class DBManager {
    
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException
    {
        st = conn.createStatement();
    }
    
    public User findUser(String email, String password) throws SQLException
    {
        String fetch = "SELECT * FROM IOTBAY.REGISTEREDUSER WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next())
        {
            String userEmail = rs.getString(4);
            String userPass = rs.getString(5);
            
            if (userEmail.equals(email) && userPass.equals(password))
            {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(7);
                String phone = rs.getString(6);
                int userId = rs.getInt(1);
                int role = rs.getInt(8);
                return new User(userId, firstName, lastName, email, password, phone, address, role);
            }
        }
        return null;
    }
    public User findUserByEmail(String email) throws SQLException
    {
        String fetch = "SELECT * FROM IOTBAY.REGISTEREDUSER WHERE EMAIL='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next())
        {
            String userEmail = rs.getString(4);
            
            if (userEmail.equals(email))
            {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(7);
                String phone = rs.getString(6);
                int userId = rs.getInt(1);
                String password = rs.getString(5);
                int role = rs.getInt(8);
                return new User(userId, firstName, lastName, email, password, phone, address, role);
            }
        }
        return null;
    }
    
    public void addUser(String firstName, String lastName, String email, String password, String phone, String address) throws SQLException
    {
        st.executeUpdate("INSERT INTO IOTBAY.REGISTEREDUSER (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PHONE, ADDRESS) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', '" + phone + "', '" + address + "')");
    }
    
}
