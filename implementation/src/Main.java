import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        UserControl uc=new UserControl();

        boolean flag = true;
        int choice,t;

        do {
            System.out.println();
            System.out.println();
            System.out.println("Hello new User...");
            System.out.println();System.out.println();
            System.out.println("1) createAccount   2)Login  3)terminate Program");
            choice = sc.nextInt();

            if (choice == 1)
                uc.createAccount(db);

            else if (choice == 2) {
                t=uc.Login(db);
                if(t==1)
                {continue;}

            } else if (choice == 3)
                flag = false;

            while (choice != 3) {
                System.out.println();
                System.out.println();
                System.out.println("1) PostPhoto   2)searchItem   3)LogOut");
                choice = sc.nextInt();

                if (choice == 1)
                    uc.PostPhoto(db);

                else if (choice == 2) {
                     uc.searchItem(db);
                }
            }


        } while (flag);

        System.out.println("To show posts enter 1");
        int ans=sc.nextInt();
        if(ans==1) {
            postControl pc = new postControl();
            System.out.println("Posts are ");
            System.out.println();
            for (int i = 0; i < db.posts.size(); i++) {
                pc.showPost(i, db);
                System.out.println();
            }
        }
    }
}