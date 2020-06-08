    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.DBManager;

import DAO.Model.AccessLog;
import DAO.Model.User;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            System.out.println(userEmail);
            System.out.println(email);
            System.out.println(userEmail.equals(email));
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
    
    public void updateUser(String firstName, String lastName, String email, String password, String phone, String address) throws SQLException
    {
        st.executeUpdate("UPDATE IOTBAY.REGISTEREDUSER SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "', "
                + "PASSWORD='" + password + "', PHONE='" + phone + "', ADDRESS='" + address + "' WHERE EMAIL='" + email + "'");
    }
    
    public void deleteUser(String email) throws SQLException
    {
        st.executeUpdate("DELETE FROM IOTBAY.REGISTEREDUSER WHERE EMAIL='" + email + "'");
    }
    
    public void addAccessLogin(int userId, String loginDate, String loginTime) throws SQLException
    {
        st.executeUpdate("INSERT INTO IOTBAY.ACCESSLOG (USERID, LOGINDATE, LOGINTIME) VALUES (" + userId + ", '" + loginDate + "', '" + loginTime + "')");
        
    }
    
    public void updateAccessLogout(int userId, String loginDate, String loginTime, String logoutDate, String logoutTime) throws SQLException
    {
        st.executeUpdate("UPDATE ACCESSLOG SET LOGOUTDATE='" + logoutDate +"', LOGOUTTIME='" + logoutTime + "' WHERE USERID=" + userId + " AND LOGINDATE='" + loginDate + "' AND LOGINTIME='" + loginTime + "'");
        
    }
    
    public String findLoginDate(int userId) throws SQLException //find loginDate using userId and logoutdatetime
    {
        String fetch = "SELECT * FROM ACCESSLOG WHERE USERID=" + userId + " AND LOGOUTDATE IS NULL AND LOGOUTTIME IS NULL";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next())
        {
            String loginDate = rs.getString(3);
//            String loginTime = rs.getString(4);
            return loginDate;
        }
        return null;
    }
    
    public String findLoginTime(int userId) throws SQLException //find loginDate using userId and logoutdatetime
    {
        String fetch = "SELECT * FROM ACCESSLOG WHERE USERID=" + userId + " AND LOGOUTDATE IS NULL AND LOGOUTTIME IS NULL";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next())
        {
            String loginTime = rs.getString(4);
            return loginTime;
        }
        return null;
    }
    
    public ArrayList findAccessLog(int userId) throws SQLException
    {
        ArrayList<AccessLog> accessLog = new ArrayList<AccessLog>();
        String fetch = "SELECT * FROM IOTBAY.ACCESSLOG WHERE USERID=" + userId;
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next())
        {
            int accessLogId = rs.getInt("accesslogid");
            int UserId = rs.getInt("userid");
            String loginDate = rs.getString("logindate");
            String loginTime = rs.getString("logintime");
            String logoutDate = rs.getString("logoutdate");
            String logoutTime = rs.getString("logouttime");
            accessLog.add(new AccessLog(accessLogId, UserId, loginDate, loginTime, logoutDate, logoutTime));
        }
        
        return accessLog;
    }
    
    public ArrayList findAccessLogByDate(String date, int userId) throws SQLException
    {
        
        ArrayList<AccessLog> accessLog = new ArrayList<AccessLog>();
        String fetch = "SELECT * FROM IOTBAY.ACCESSLOG WHERE USERID=" + userId + " AND LOGINDATE='" + date + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next())
        {
            int accessLogId = rs.getInt("accesslogid");
            int UserId = rs.getInt("userid");
            String loginDate = rs.getString("logindate");
            String loginTime = rs.getString("logintime");
            String logoutDate = rs.getString("logoutdate");
            String logoutTime = rs.getString("logouttime");
            accessLog.add(new AccessLog(accessLogId, UserId, loginDate, loginTime, logoutDate, logoutTime));
        }
        return accessLog;
    }
    
}
