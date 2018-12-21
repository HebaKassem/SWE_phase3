import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.Random;
public class AccountControl {

    Account acc=new Account();

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
        System.out.println("cooddee is " + generateRandomAlphaNumericCode());
        acc.setCode( generateRandomAlphaNumericCode());
        System.out.println("\nverification code is..." + acc.accountCode);

    }

    public boolean validateCode(String code) {
        if (acc.accountCode.equals(code)) {
            System.out.println("valid code :)");
            return true;
        } else {
            System.out.println("INVALID CODE !");
            return false;
        }
    }
     /*
        boolean verifyUsername(String uname) {

            // System.out.println("pass is "+pass);
            if ()
            {
                System.out.println("invalid password ");
                return false;
            }
            System.out.println("valid password ");
            return true;
        }
    */


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

    public boolean Check_Password_match(Database db,String pass, int index)
    {
        if(db.accounts.get(index).password.equals(pass))
        {
            System.out.println("Valid Password :)");
            System.out.println("you are logged in");
            return true;
        }
        else
        {
            return false;
        }

    }

    public void updateUsername(String uname) {
    }

    public void updatePassword(String uname) {
    }


}
