import java.util.ArrayList;
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


    public void createAccount(Database db) {
        boolean passVerification = false, usernameVerification = false;
        String username = "", password = "", Email = "", MobileNumber = "";
        // while (!passVerification||!usernameVerification) {
        while (!passVerification) {
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

    public String takePhoto(){
        Scanner a = new Scanner(System.in);
        System.out.print("Enter photoPath: ");
        String Path = a.nextLine();
        return Path;
    }
    public String writePhotoInfo(){
        Scanner b = new Scanner(System.in);
        System.out.print("enter photo info: ");
        String desc= b.nextLine();
        return desc;
    }
    public String choosecategory(Database d){
        Scanner c = new Scanner(System.in);
        System.out.print("choose category : "+d.categories);
        int cat = c.nextInt();
        return d.categories.get(cat-1);
    }
    public String chooseColor(){
        Scanner d = new Scanner(System.in);
        System.out.print("choose color : ");
        String color = d.nextLine();
        return color;
    }
    public Authentication setQ_A(){
        Scanner e = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        Scanner w = new Scanner(System.in);
        postControl c=new postControl();
        Authentication a= new Authentication();
        ArrayList<String> ques = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        System.out.print("Enter number of questions: ");
        int n = w.nextInt();
        for(int i=0 ; i<n ; i++){
            System.out.println("Enter question: ");
            String qu = e.nextLine();
            ques.add(qu);
            System.out.println("Enter answer: ");
            String an = f.nextLine();
            ans.add(an);
        }
        a.setListOfQuestions(ques);
        a.setListOfAnswers(ans);
        c.AskForConfirmation();
        return a;
    }

    public void PostPhoto(Database d){
        postControl c = new postControl();
        String photopath = takePhoto();
        String description =writePhotoInfo();
        String cat = choosecategory(d);
        String color = chooseColor();
        Authentication a = setQ_A();
        c.AskForConfirmation();
        int choice = s.nextInt();
        switch (choice){
            case 1:
            {

                LostStuff l = new LostStuff(cat, color);
                Post newPost = new Post(photopath, description,color , l, a);

                d.posts.add(newPost);
                newPost.setId(d.posts.indexOf(newPost));
                break;
            }
            default:
            {
                System.out.println("Submission failed");
            }
        }

    }
    public void Login( Database db)
    {
        String password = "", Email = "";
        int index;
        boolean matching;
        boolean found=false;
        userAccount = new Account();
        Email=writeMail();
        for (int i = 0 ; i<db.accounts.size();i++)
        {
            if ((db.accounts.get(i).Email.equals(Email)))
            {
                found = true;
                index = i;
                password = writePassword();
                matching = accControl.Check_Password_match(db, password, index);
                if (matching == false)
                {
                    for (int in = 0; in < 3; in++)
                    {
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

            if (i==db.accounts.size()-1)
            {
                User u = new User();
                System.out.println("You don't have an account");
                System.out.println("Create one for FREE");
                u.createAccount(db);
                break;


            }
        }


    }


}
