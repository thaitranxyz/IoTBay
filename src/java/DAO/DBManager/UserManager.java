    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.DBManager;

import DAO.Model.User;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author trandamtrungthai
 */
public class UserManager {
    
    private Statement st;
    
    public UserManager(Connection conn) throws SQLException
    {
        st = conn.createStatement();
    }
    
    public User findUser(String email, String password) throws SQLException
    {
        String fetch = "SELECT * FROM IOTBAY.TBL_USER WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next())
        {
            String userEmail = rs.getString(4);
            String userPass = rs.getString(5);
            
            if (userEmail.equals(email) && userPass.equals(password))
            {
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String address = rs.getString("ADDRESS");
                String phone = rs.getString("PHONE");
                int userId = rs.getInt("ID");
                int role = rs.getInt("ROLE_ID");
                return new User(userId, firstName, lastName, email, password, phone, address, role);
            }
        }
        return null;
    }
    public User findUserByEmail(String email) throws SQLException
    {
        String fetch = "SELECT * FROM IOTBAY.TBL_USER WHERE EMAIL='" + email + "'";
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
        st.executeUpdate("INSERT INTO IOTBAY.TBL_USER (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PHONE, ADDRESS) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', '" + phone + "', '" + address + "')");
    }
    
    public void updateUser(String firstName, String lastName, String email, String password, String phone, String address) throws SQLException
    {
        st.executeUpdate("UPDATE IOTBAY.TBL_USER SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "', "
                + "PASSWORD='" + password + "', PHONE='" + phone + "', ADDRESS='" + address + "' WHERE EMAIL='" + email + "'");
    }
    
    public void deleteUser(String email) throws SQLException
    {
        st.executeUpdate("DELETE FROM IOTBAY.TBL_USER WHERE EMAIL='" + email + "'");
    }
    
    public void addAccessLogin(int userId, String loginDate, String loginTime) throws SQLException
    {
        st.executeUpdate("INSERT INTO IOTBAY.TBL_ACCESSLOG (USER_ID, LOGINDATETIME) VALUES (" + userId + ", '" + loginDate + " " + loginTime + "')");
        
    }
    
    public int getLatestLoginId(int userId) throws SQLException{
        String fetch = "SELECT * FROM TBL_ACCESSLOG WHERE USER_ID = " + userId +" ORDER BY ID DESC FETCH FIRST ROW ONLY";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            return rs.getInt("ID");
        }
        return 0;
    }
    
    public void updateAccessLogout(int userId, String logoutDate, String logoutTime) throws SQLException
    {
        st.executeUpdate("UPDATE TBL_ACCESSLOG SET LOGOUTDATETIME='" + logoutDate + " " + logoutTime + "' WHERE ID = "+getLatestLoginId(userId));
        
    }
 
}   
