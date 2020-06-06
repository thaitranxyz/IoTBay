package Controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {

    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
//   private String passwordPattern = "[a-z0-9]{4,}";
    private String passwordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private String phonePattern = "[0]{1}[0-9]{9}";
    private String firstNamePattern = "^[A-Za-z]+$";
    private String lastNamePattern = "[A-Za-z]+$";
    private String addressPattern = "";
    private String doublePattern = "/^[0-9]+(\\.[0-9]+)?$";
    private String integerPattern = "^[-+]?\\d+$";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }

    public boolean validatePhone(String phone) {
        return validate(phonePattern, phone);
    }

    public boolean validateFirstName(String firstName) {
        return validate(firstNamePattern, firstName);
    }

    public boolean validateLastName(String lastName) {
        return validate(lastNamePattern, lastName);
    }

    public boolean validateAddress(String address) {
        return validate(addressPattern, address);
    }

    public boolean validateInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean validateDouble(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Email Address");
        session.setAttribute("passwordErr", "Password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "");
        session.setAttribute("phoneErr", "Phone");
        session.setAttribute("addressErr", "Address");
        session.setAttribute("lastNameErr", "Last Name");
        session.setAttribute("firstNameErr", "First Name");
        session.setAttribute("updated", "");
    }
}
