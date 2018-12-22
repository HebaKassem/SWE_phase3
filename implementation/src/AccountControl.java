import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.Random;

public class AccountControl {

    Account acc = new Account();

    public static String generateRandomAlphaNumericCode() {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        int count = 5;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }


    //instead of sendVerifyCode !!
    public void AccSendCode() {
        acc.setVerifCode(generateRandomAlphaNumericCode());
        System.out.println("\nverification code is..." + acc.accountVerifCode);

    }

    public boolean validateCode(String code) {
        if (acc.accountVerifCode.equals(code)) {
            System.out.println("valid code :)");
            return true;
        } else {
            System.out.println("INVALID CODE !");
            return false;
        }
    }

    boolean verifyUsername(String uname, Database d) {
        boolean preExists = false;
        for (int i = 0; i < d.accounts.size(); i++) {
            if (d.accounts.get(i).getUsername().equals(uname))
                preExists = true;
        }

        if (preExists) {
            System.out.println("invalid username ");
            return false;

        } else {
            System.out.println("valid username");
            return !preExists;
        }
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

    public void sendIncorrectMSG() {
    }

    public void createAccount() {
    }

    public boolean checkEmail(String email)//correct it
    {
        return true;
    }

    public String sendEmail()//to be corrected
    {
        String email = "";
        return email;
    }

    public boolean Check_Password_match(Database db, String pass, int index) {
        if (db.accounts.get(index).password.equals(pass)) {
            System.out.println("Valid Password :)");
            System.out.println("you are logged in");
            return true;
        } else {
            return false;
        }

    }

    public void updateUsername(String uname) {
    }

    public void updatePassword(String uname) {
    }


}
