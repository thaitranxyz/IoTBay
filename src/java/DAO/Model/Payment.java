/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

/**
 *
 * @author Wenbo Zhang
 */
public class Payment {
    private String creditCardNumber;
    private String creditCardExpiry;
    private String creditCardCVC;
    private int customerId;
    private int isDefault;
    public Payment(String creditCardNumber, String creditCardExpiry, String creditCardCVC, int isDefault, int customerId) {
        this.creditCardCVC = creditCardCVC;
        this.creditCardExpiry = creditCardExpiry;
        this.creditCardNumber = creditCardNumber;
        this.customerId = customerId;
        this.isDefault = isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCreditCardExpiry() {
        return creditCardExpiry;
    }

    public String getCreditCardCVC() {
        return creditCardCVC;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCreditCardExpiry(String creditCardExpiry) {
        this.creditCardExpiry = creditCardExpiry;
    }

    public void setCreditCardCVC(String creditCardCVC) {
        this.creditCardCVC = creditCardCVC;
    }
}
