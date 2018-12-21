import java.util.Scanner;

public class User {
    private int userid;
    private String name;
    private Account userAccount;
    Scanner s = new Scanner(System.in);

    public User() {
    }

    public User(int userid, String name, Account userAccount) {
        this.userid = userid;
        this.userAccount = userAccount;
        this.name = name;
    }


    public String writeUsername() {
        System.out.println("Enter UserName: ");
        String username = s.nextLine();
        return username;
    }

    public String writePassword() {
        System.out.println("Enter Password: ");
        String Password = s.nextLine();
        return Password;
    }

    public String writeMail() {
        System.out.println("Enter mail: ");
        String mail = s.nextLine();
        return mail;
    }

    public String writeMobileNum() {
        System.out.println("Enter MobileNumber: ");
        String MobileNumber = s.nextLine();
        return MobileNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public String getName() {
        return name;
    }

    public int getUserid() {
        return userid;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public String sendcode() {
        System.out.println("Enter verification code");
        String code = s.nextLine();
        return code;
    }

    public String takephoto() {
        System.out.println("Enter photoPath");
        String Path = s.nextLine();
        return Path;

    }

}
