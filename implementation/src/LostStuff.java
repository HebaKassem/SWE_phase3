import java.util.ArrayList;

public class LostStuff {
    public String category;
    private String color;
    private String size;
    public LostStuff(String category, String color){
        this.category=category;
        this.color=color;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getCategory(){
        return category;
    }


    public String getColor(){
        return color;
    }
}
