public class Main {

    public static void main(String[] args) {
        Database d = new Database();
        User u = new User();
        int i=0;
        while( i<2) {
            u.PostPhoto(d);
            i++;
        }
        for(int j=0 ; j<2 ;j++)
        System.out.println(d.posts.get(j).getPhotoPath()+" "+d.posts.get(j).getDescription()+" "+d.posts.get(j).lS.getCategory()+" "+d.posts.get(j).lS.getColor()+" "+d.posts.get(j).a.getListOfQuestions()+" "+d.posts.get(j).a.getListOfAnswers()+" ");


    }
}
