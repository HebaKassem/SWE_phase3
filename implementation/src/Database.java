import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Database {
    User user;
    int usersOldSize;
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Account> accounts = new ArrayList<Account>();
    public static ArrayList<Post> posts = new ArrayList<Post>();
    public static ArrayList<Authentication> authentications = new ArrayList<Authentication>();
    public static ArrayList<String> categories = new ArrayList<String>(Arrays.asList("Wallet","Id", "charger", "cat","dog","mobile", "laptop","watch","money","others"));

    public void saveDB() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Heba\\Desktop\\FCI =)\\3rd\\SW_Engineering_1\\Projects\\Phase_3\\implementation\\users.txt", true));

            for (int i = usersOldSize; i < users.size(); i++) {
                writer.write(users.get(i).getUserid() + "  " + users.get(i).getName());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDB() {
        try {
            usersOldSize = -1;
            File f = new File("C:\\Users\\Heba\\Desktop\\FCI =)\\3rd\\SW_Engineering_1\\Projects\\Phase_3\\implementation\\users.txt");
            FileReader fr = new FileReader(f);
            BufferedReader reader = new BufferedReader(fr);

            if (f.length() != 0) {
                String line = reader.readLine();
                while (line != null) {
                    usersOldSize += 1;
                    String[] parameters = line.split(" ");
                    int uid = Integer.parseInt(parameters[0]);
                    String name = parameters[1];
                    user = new User(uid, name);
                    users.add(user);

                    // read next line
                    line = reader.readLine();
                }
                System.out.println("usersOldSize is " + usersOldSize);
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
