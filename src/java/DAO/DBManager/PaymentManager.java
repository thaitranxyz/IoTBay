/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.DBManager;

/**
 *
 * @author Wenbo Zhang
 */
import DAO.Model.Customer;
import DAO.Model.Payment;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class PaymentManager {

	private Statement st;

	public PaymentManager(Connection conn) throws SQLException {       
	   st = conn.createStatement();   
	}
		
	public void addPaymentDetails(String creditCardNumber, String creditCardExpiry, String creditCardCVC, int isDefaultValue, int customerId) throws SQLException {
           st.executeUpdate("INSERT INTO IOTBAY.PAYMENT (creditCardNumber, creditCardExpiry, creditCardCVC, isDefault, customerId) VALUES ('" + creditCardNumber + "', '" + creditCardExpiry + "', '" + creditCardCVC + "'," + isDefaultValue + "," + customerId + ")");
        }
        public void deletePaymentDetails(String id) throws SQLException {
           st.executeUpdate("DELETE FROM IOTBAY.PAYMENT WHERE creditCardNumber='" + id + "'");
        }
        public void updatePaymentDetails(String id, String newId, String newExpiry, String newCVC, int isDefaultValue) throws SQLException {
           st.executeUpdate("UPDATE IOTBAY.PAYMENT SET creditCardNumber='" + newId + "', creditCardExpiry='" + newExpiry + "', creditCardCVC='" + newCVC + "', isDefault=" + isDefaultValue + " WHERE creditCardNumber='" + id + "'");
        }
        public Payment getPaymentDetails(String CCN, int customerId) throws SQLException {
        try {
            ResultSet results = st.executeQuery("SELECT * FROM IOTBAY.PAYMENT WHERE creditCardNumber = '" + CCN + "'");
            return new Payment(results.getString("creditCardNumber"), results.getString("creditCardExpiry"), results.getString("creditCardCVC"), results.getInt("isDefault"), results.getInt("customerId"));
        }
        catch (Exception ex){
            return null;
            }
        }
        public ArrayList<Payment> getPaymentList(int customerId) throws SQLException {
            try {
                ResultSet results = st.executeQuery("SELECT * FROM IOTBAY.PAYMENT WHERE CUSTOMERID=" + customerId);
                ArrayList<Payment> paymentList = new ArrayList<Payment>();
            while (results.next()) {
                paymentList.add(new Payment(results.getString("creditCardNumber"), results.getString("creditCardExpiry"), results.getString("creditCardCVC"), results.getInt("isDefault"), results.getInt("customerId")));
            }
            return paymentList;
        }
        catch (Exception ex){
            return null;
        }
    }
        public Payment getDefaultPayment(int customerId) throws SQLException {
            try{
                ResultSet results = st.executeQuery("SELECT * FROM IOTBAY.PAYMENT WHERE isDefault=1 and customerId=" + customerId);
            while (results.next()){
                if (results.getInt("isDefault")==1){
                    return new Payment(results.getString("creditCardNumber"), results.getString("creditCardExpiry"), results.getString("creditCardCVC"), results.getInt("isDefault"), results.getInt("customerId"));
                }
            }
            return null;
        }
        catch (Exception ex){
            return null;
        }
    }

    //update a user details in the database   
    public void UpsertCustomer(Customer customer) throws SQLException {        
       String query = "INSERT INTO IOTBAY.CUSTOMER ("
               + "customerName,"
               + "customerAddress,"
               + "customerEmail,"
               + "customerPhone,"
               + "customerPassword) VALUES (" + 
               
               customer.getName() + "," + 
                customer.getAddress() + "," + 
                customer.getEmail() + "," + 
                customer.getPhoneNumber() + "," +
                customer.getPassword() + ")";
        st.executeUpdate(query);   
    }

}
