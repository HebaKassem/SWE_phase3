import java.util.Scanner;

public class User {
    Database db = new Database();
    public int userid = db.users.size();
    private String name;
    private Account userAccount = new Account();
    AccountControl accControl = new AccountControl();

    Scanner s = new Scanner(System.in);


    public User() {
    }

    /* public User(int uid, String name, Account userAccount) {
         this.userid =uid;
         this.userAccount = userAccount;
         this.name = name;
     }*/
    public User(int uid, String name) {
        this.userid = uid;
        this.name = name;
    }


    public void createAccount() {
        boolean passVerification = false, usernameVerification = false;
        Database db = new Database();
        String username = "", password = "", Email = "", MobileNumber = "";

        // while (!passVerification||!usernameVerification) {
        while (!passVerification) {
            db = new Database();
            writeName();
            username = writeUsername();
            password = writePassword();
            Email = writeMail();
            MobileNumber = writeMobileNum();
            passVerification = verifyPassStrength(password);
            //  usernameVerification=verifyUsername(username);
        }


        userAccount = new Account();
        accControl.AccSendCode();
        boolean codeValidation = false;
        while (!codeValidation) {
            String code = writeCode();
            codeValidation = accControl.validateCode(code);
        }

        userAccount = new Account(username, password, Email, MobileNumber);
        int id = db.users.size() + 1;
        //User user = new User(userid,name, userAccount);
        // int usersCurrentSize = db.usersOldSize;

        User user = new User(id, name);

        db.accounts.add(userAccount);
        db.users.add(user);

        System.out.println();
          System.out.println("Account is successfully created ");

    }


    boolean verifyPassStrength(String pass) {

        if ((pass.length() <= 8) || (!pass.matches(".*[a-zA-Z]+.*")) || (!pass.matches(".*[0-9]+.*")))//correct check as it doesn't work
        {
            System.out.println("invalid password ");
            return false;
        }
        System.out.println("valid password ");
        return true;
    }

    public String writeUsername() {
        System.out.print("Enter UserName: ");
        String username = s.nextLine();
        return username;
    }

    public void writeName() {
        System.out.print("Enter Name: ");
        name = s.nextLine();
    }

    public String writePassword() {
        System.out.println("Enter Password: ");
        System.out.println("Make sure that its length is longer than 8 and contains at least one number & one alphabet... ");
        String Password = s.nextLine();
        return Password;
    }

    public String writeMail() {
        System.out.print("Enter mail: ");
        String mail = s.nextLine();
        return mail;
    }

    public String writeMobileNum() {
        System.out.print("Enter MobileNumber: ");
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

    public String writeCode() {
        System.out.println("Enter verification code");
        String code = s.nextLine();
        code = code.toUpperCase();
        return code;
    }

    public String takephoto() {
        System.out.println("Enter photoPath");
        String Path = s.nextLine();
        return Path;

    }

}
