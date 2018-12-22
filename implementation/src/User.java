import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public int userid;
    private String name;
    private Account userAccount = new Account();

    Scanner s = new Scanner(System.in);

    public User() {
    }

    public User( String name, Account userAccount) {
         this.userAccount = userAccount;
         this.name = name;
     }

    public String writeUsername() {
        System.out.print("Enter UserName: ");
        String username = s.nextLine();
        return username;
    }

    public String writeName() {
        System.out.print("Enter Name: ");
        name = s.nextLine();
        return name;
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

    public String takePhoto() {
        Scanner a = new Scanner(System.in);
        System.out.print("Enter photoPath: ");
        String Path = a.nextLine();
        return Path;
    }

    public String writeItemDescription() {
        Scanner b = new Scanner(System.in);
        System.out.print("enter item description: ");
        String desc = b.nextLine();
        return desc;
    }

    public String choosecategory(Database d) {
        Scanner c = new Scanner(System.in);
        System.out.print("enter number of  category : " + d.categories + ": ");
        int cat = c.nextInt();
        return d.categories.get(cat - 1);
    }

    public String chooseColor() {
        Scanner d = new Scanner(System.in);
        System.out.print("write color : ");
        String color = d.nextLine();
        return color;
    }

    public String chooseSize() {
        Scanner d = new Scanner(System.in);
        System.out.print("write size : [large ,  medium  , small]: ");
        String size = d.nextLine();
        while (!(size.equals("large") || size.equals("medium") || size.equals("small"))) {
            System.out.println(" please enter a valid size");
            size = d.nextLine();
        }
        return size;
    }

    public Authentication setQ_A() {
        Scanner e = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        Scanner w = new Scanner(System.in);

        postControl c = new postControl();
        Authentication a = new Authentication();

        ArrayList<String> ques = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();

        System.out.print("Enter number of questions: ");
        int n = w.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter question: ");
            String qu = e.nextLine();
            ques.add(qu);
            System.out.println("Enter answer: ");
            String an = f.nextLine();
            ans.add(an);
        }
        a.setListOfQuestions(ques);
        a.setListOfAnswers(ans);
        return a;
    }

    public int sendConfirmation() {
        int choice = s.nextInt();
        return choice;
    }

}
