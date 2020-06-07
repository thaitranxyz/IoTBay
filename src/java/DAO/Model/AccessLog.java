/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

/**
 *
 * @author trandamtrungthai
 */
public class AccessLog {
    
    private int accessLogId;
    private int userId;
    private String loginDate;
    private String loginTime;
    private String logoutDate;
    private String logoutTime;
    
    public AccessLog() {}

    public AccessLog(int accessLogId, int userId, String loginDate, String loginTime, String logoutDate, String logoutTime) {
        this.accessLogId = accessLogId;
        this.userId = userId;
        this.loginDate = loginDate;
        this.loginTime = loginTime;
        this.logoutDate = logoutDate;
        this.logoutTime = logoutTime;
    }

    public int getAccessLogId() {
        return accessLogId;
    }

    public int getUserId() {
        return userId;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getLogoutDate() {
        return logoutDate;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setAccessLogId(int accessLogId) {
        this.accessLogId = accessLogId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public void setLogoutDate(String logoutDate) {
        this.logoutDate = logoutDate;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }
    
    
    
}
