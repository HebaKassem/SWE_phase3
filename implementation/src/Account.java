import java.util.Scanner;

public class Account {
    private String username;
    private String password;
    private String Email;
    private String MobileNumber;
    private String code;
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
        this.code = code;
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
        return code;
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
