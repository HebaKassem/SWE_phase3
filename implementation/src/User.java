import java.util.ArrayList;
import java.util.Scanner;

public class User {
   // public int userid = db.users.size();
    public int userid;//DO
    private String name;
    private Account userAccount = new Account();

    Scanner s = new Scanner(System.in);


    public User() {
    }

    public User( String name, Account userAccount) {
         this.userAccount = userAccount;
         this.name = name;
     }


    public void createAccount(Database db) {
        AccountControl ac =new AccountControl();

        boolean passVerification = false, usernameVerification = false;
        String name="",username = "", password = "", Email = "", MobileNumber = "";
        while (!passVerification || !usernameVerification) {
            name= writeName();
            username = writeUsername();
            password = writePassword();
            Email = writeMail();
            MobileNumber = writeMobileNum();

            passVerification = ac.verifyPassStrength(password);
            usernameVerification = ac.verifyUsername(username, db);
        }


        userAccount = new Account();
        ac.AccSendCode();
        boolean codeValidation = false;
        while (!codeValidation) {
            String code = writeCode();
            codeValidation = ac.validateCode(code);
        }

        userAccount = new Account(username, password, Email, MobileNumber);


        db.accounts.add(userAccount);

        User user = new User(name,userAccount);
        db.users.add(user);
        user.setUserid(db.users.indexOf(user));



        System.out.println();
        System.out.println("Account is successfully created ");

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

    public void searchItem(Database d) {
        SearchControl sc = new SearchControl();

        Scanner in = new Scanner(System.in);
        String category = choosecategory(d);
        String color = chooseColor();
        String size = chooseSize();

        sc.searchPost(category, color, size, d);


    }

    public int sendConfirmation() {
        int choice = s.nextInt();
        return choice;
    }

    public void PostPhoto(Database d) {
        postControl c = new postControl();

        String photopath = takePhoto();
        String description = writeItemDescription();
        String cat = choosecategory(d);
        String color = chooseColor();
        String size = chooseSize();
        Authentication a = setQ_A();
        c.AskForConfirmation();

        int choice = sendConfirmation();
        switch (choice) {
            case 1: {

                LostStuff ls = new LostStuff(cat, color, size);
                Post newPost = new Post(photopath, description, ls, a);

                d.posts.add(newPost);
                newPost.setId(d.posts.indexOf(newPost));
                break;
            }
            default: {
                c.SendSubmissionFailedMsg();
            }
        }

    }

    //use other classes for login fn!
    public void Login(Database db) {
        AccountControl accControl =new AccountControl();

        String password = "", Email = "";
        int index;
        boolean matching;
        boolean found = false;
        userAccount = new Account();
        Email = writeMail();
        for (int i = 0; i < db.accounts.size(); i++) {
            if ((db.accounts.get(i).Email.equals(Email))) {
                found = true;
                index = i;
                password = writePassword();
                matching = accControl.Check_Password_match(db, password, index);
                if (matching == false) {
                    for (int in = 0; in < 3; in++) {
                        System.out.println("Invalid Password! ");
                        System.out.println("ReEnter Your Password: ");
                        password = writePassword();
                        matching = accControl.Check_Password_match(db, password, index);
                        if (matching) {
                            break;
                        }
                        if (in == 2) {
                            System.out.println(" Retry Later");

                        }
                    }
                }
            }
            if (i == db.accounts.size() - 1) {
                User u = new User();
                System.out.println("You don't have an account");
                System.out.println("Create one for FREE");
                u.createAccount(db);
                break;
            }
        }
    }


}
