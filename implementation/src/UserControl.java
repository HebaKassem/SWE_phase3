import java.util.Scanner;

public class UserControl {
    User user=new User();
    private Account userAccount = new Account();

    public void createAccount(Database db) {
        AccountControl ac =new AccountControl();

        boolean passVerification = false, usernameVerification = false;
        String name="",username = "", password = "", Email = "", MobileNumber = "";
        while (!passVerification || !usernameVerification) {
            name= user.writeName();
            username = user.writeUsername();
            password = user.writePassword();
            Email = user.writeMail();
            MobileNumber =user.writeMobileNum();

            passVerification = ac.verifyPassStrength(password);
            usernameVerification = ac.verifyUsername(username, db);
        }


        userAccount = new Account();
        ac.AccSendCode();
        boolean codeValidation = false;
        while (!codeValidation) {
            String code = user.writeCode();
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


    public void searchItem(Database d) {
        SearchControl sc = new SearchControl();

        Scanner in = new Scanner(System.in);
        String category = user.choosecategory(d);
        String color = user.chooseColor();
        String size = user.chooseSize();

        sc.searchPost(category, color, size, d);


    }


    public void PostPhoto(Database d) {
        postControl c = new postControl();

        String photopath = user.takePhoto();
        String description = user.writeItemDescription();
        String cat = user.choosecategory(d);
        String color = user.chooseColor();
        String size = user.chooseSize();
        Authentication a = user.setQ_A();
        c.AskForConfirmation();

        int choice = user.sendConfirmation();
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


    public int Login( Database db)
    {  User u = new User(); AccountControl accControl= new AccountControl();

        String password = "", Email = "";
        int index;
        int t=0;
        boolean matching;
        boolean found=false;
        userAccount = new Account();
        Email=u.writeMail();//enterEmail
        for (int i = 0 ; i<db.accounts.size();i++)
        {
            if ((db.accounts.get(i).Email.equals(Email)))
            {
                found = true;
                index = i;
                password = u.writePassword(); //EnterPassword
                matching = accControl.Check_Password_match(db, password, index);
                if (matching == false)
                {
                    for (int in = 0; in < 3; in++)
                    {
                        accControl.sendIncorrectMSG(1);
                        password = u.writePassword();
                        matching = accControl.Check_Password_match(db, password, index);
                        if (matching) {
                            break;
                        }
                        if (in == 2) {
                            {accControl.sendIncorrectMSG(in);
                                t=1;}
                        }
                    }
                }
            }

        }
        if (found==false)
        {
            System.out.println("You don't have an account");
            System.out.println("Create one for FREE");
            createAccount(db);
        }
        return t;
    }

}
