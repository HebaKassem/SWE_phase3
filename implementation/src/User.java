import java.util.ArrayList;
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


}
