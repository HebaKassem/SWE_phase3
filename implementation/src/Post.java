public class Post {
    private int id;
    private String photoPath;
    private String description;
    public Authentication a = new Authentication();
    public LostStuff lS;
    public Post(){
    }
    public Post( String photoPath, String description, String color, LostStuff lS, Authentication a){
        this.photoPath=photoPath;
        this.description=description;
        this.lS=lS;
        this.a=a;
        //lS.setCategory(cat);
        //lS.setColor(color);
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
