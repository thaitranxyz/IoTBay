    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotModelDAO;

import Model.User;
import java.sql.Statement;
import java.sql.Connection;
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
        String fetch = "SELECT * FROM IOTBAY.CUSTOMER WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'";
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
                int phone = rs.getInt(6);
                int customerId = rs.getInt(1);
                return new User(customerId, firstName, lastName, email, phone, password, address);
            }
        }
        return null;
    }    
    
    public void addUser(String firstName, String lastName, String email, int phone, String password, String address) throws SQLException
    {
        st.executeUpdate("INSERT INTO IOTBAY.CUSTOMER (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PHONE, ADDRESS)" + "VALUES ('" + customerId + "','" + firstName + "', '" + lastName + "', '" + email + "', '" + phone + "', '" + password + "', '" + address + "')");
    }
    
}
