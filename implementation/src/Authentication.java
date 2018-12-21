import java.security.PublicKey;
import java.util.ArrayList;

public class Authentication {
    private String ContactNumber;
    private ArrayList<String> ListOfQuestions;
    private ArrayList<String>ListOfAnswers;
    public Authentication(){

    }
    public void setListOfQuestions(ArrayList<String> listOfQuestions){
        this.ListOfQuestions=listOfQuestions;
    }

    public void setListOfAnswers(ArrayList<String> listOfAnswers){
        this.ListOfAnswers=listOfAnswers;
    }

    public void setContactNumber(String ContactNumber){
        this.ContactNumber=ContactNumber;
    }
    public ArrayList<String> getListOfQuestions(){
        return ListOfQuestions;
    }
    public ArrayList<String> getListOfAnswers(){
        return ListOfAnswers;
    }
    public String getContactNumber(){
        return ContactNumber;
    }

}
