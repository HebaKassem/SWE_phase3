public class postControl {

    Post p;

    public Boolean checkPhotoExistance(String photoPath) {
        return true;
    }

    public void AskForConfirmation() {
        System.out.println("1)confirm posting...2)cancel");
    }

    public void askForPhoto() {

    }

    public void SendSubmissionFailedMsg() {
        System.out.println("SubmissionFailed");
    }

    public void CreatePost() {
    }

    public void showPost(int i, Database db) {
        System.out.println("Post #"+db.posts.get(i).getId());
        System.out.println("Photopath  : " + db.posts.get(i).getPhotoPath());
        System.out.println("Description: " + db.posts.get(i).getDescription());
        System.out.println("Category   : " + db.posts.get(i).getLostStuff().getCategory());
        System.out.println("Color      : " + db.posts.get(i).getLostStuff().getColor());
        System.out.println("Size       : " + db.posts.get(i).getLostStuff().getSize());

    }
}
