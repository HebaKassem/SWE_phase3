import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.Random;

public class Account {
    public String username;
    public String password;
    public String Email;
    public String MobileNumber;
    public String accountCode;
    Scanner s = new Scanner(System.in);

    public Account() {
    }

    public Account(String username, String password, String Email, String MobileNumber) {
        this.MobileNumber = MobileNumber;
        this.Email = Email;
        this.password = password;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCode(String code) {
        this.accountCode = code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.MobileNumber = mobileNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getCode() {
        return accountCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

}
