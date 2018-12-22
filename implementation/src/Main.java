import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        db.readDB();
        User u = new User();
        boolean flag = true;
        int choice;
        do {
            System.out.println("1) createAccount   2)Login  3)terminate Program");
            choice = sc.nextInt();

            if (choice == 1)
                u.createAccount(db);

            else if (choice == 2) {
                u.Login(db);

            } else if (choice == 3)
                flag = false;

            while (choice != 3) {
                System.out.println("1) PostPhoto   2)searchPost   3)LogOut");
                choice = sc.nextInt();

                if (choice == 1)
                    u.PostPhoto(db);

                else if (choice == 2) {
                    u.searchPost(db);
                }
            }


        } while (flag);
        db.saveDB();


    }
