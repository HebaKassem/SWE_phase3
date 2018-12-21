public class Post {
    private int id;
    private String photoPath;
    private String description;
    public Post(){
    }
    public Post(int id, String photoPath, String description){
        this.id=id;
        this.photoPath=photoPath;
        this.description=description;
    }
    public void setId(int id){
        this.id=id;
    }

    public void setPhotoPath(String photoPath){
        this.photoPath=photoPath;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getPhotoPath(){
        return photoPath;
    }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }


}
