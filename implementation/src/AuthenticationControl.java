import java.util.ArrayList;

public class AuthenticationControl {
    Authentication auth = new Authentication();

    public ArrayList<String> sendOwnershipQuestions() {
        ArrayList<String> q = new ArrayList<String>();
        return q;
    }

    public boolean checkAnswersCorrectness(ArrayList<String> ans) {
        return true;
    }

    public String showContactNumber() {
        return auth.getContactNumber();
    }

    public void sendIncorrectAnsMsg() {
        System.out.println("incorrect answers");
    }

    public void removePost(Post p) {

    }

}


