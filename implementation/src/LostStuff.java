import java.util.ArrayList;

public class LostStuff {
    public String category;
    public String color;
    public String size;

    public LostStuff(String category, String color, String Size) {
        this.category = category;
        this.color = color;
        this.size = Size;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
