import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database db=new Database();
//        db.readDB();


        Scanner in=new Scanner(System.in);
        System.out.println("how many accounts to create ?");
        User u=new User();

        int numOfAcc=in.nextInt();
        for(int i=0;i<numOfAcc;i++)
            u.createAccount();

        db.saveDB();


    }

}
