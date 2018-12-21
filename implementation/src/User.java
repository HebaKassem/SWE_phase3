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
    public String writePhotoInfo(){
        System.out.println("enter photo info");
        String desc= s.nextLine();
        return desc;
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

    public void PostPhoto(Database d){
        Scanner s = new Scanner(System.in);
        Scanner a0 = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        Scanner c0 = new Scanner(System.in);
        Scanner e = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        Scanner g = new Scanner(System.in);
        postControl c=new postControl();
        System.out.print("Enter photoPath: ");
        String Path = s.nextLine();
        System.out.print("enter photo info: ");
        String desc= a0.nextLine();
        System.out.print("choose category : "+d.categories);
        int cat = b.nextInt();
        System.out.print("choose color : ");
        String color = c0.nextLine();
        Authentication a= new Authentication();
        ArrayList<String> ques = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        System.out.print("Enter number of questions: ");
        int n = g.nextInt();
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
        int choice = s.nextInt();
        switch (choice){
            case 1:
            {
                //
                LostStuff l = new LostStuff(d.categories.get(cat-1), color);
                Post newPost = new Post(Path, desc,color , l, a);
                d.posts.add(newPost);
                newPost.setId(d.posts.indexOf(newPost));
                break;
            }
            default:
            {
                System.out.println("Submission failed");
            }
        }


/**
        String photoPath =takephoto();
        String description =writePhotoInfo();
        String cat = chooseCategory(d);
        String color = chooseColor();
        LostStuff l = new LostStuff(cat, color);
        setOwnerShipQ_A();
        c.AskForConfirmation();
        int choice = s.nextInt();
        switch (choice){
            case 1:
            {
                //
                Post newPost = new Post(photoPath, description,color , l);
                d.posts.add(newPost);
                newPost.setId(d.posts.indexOf(newPost));
                break;
            }
            default:
            {
                System.out.println("Submission failed");
            }
        }
 **/
    }

}
