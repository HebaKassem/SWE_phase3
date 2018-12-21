import java.util.ArrayList;

public class LostStuff {
    private String category;
    private String color;
    private String size;
    public LostStuff(String category, String color, String size){
        this.size=size;
        this.category=category;
        this.color=color;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setSize(String size){
        this.size=size;
    }
    public String getCategory(){
        return category;
    }

    public String getSize(){
        return size;
    }

    public String getColor(){
        return color;
    }
}
