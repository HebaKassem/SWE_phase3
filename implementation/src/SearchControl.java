public class SearchControl {

    public void searchPost(String category, String color, String size, Database d)
    {
        int index=-1;
        for(int i=0;i<d.posts.size();i++){
            if(d.posts.get(i).getLostStuff().getCategory().equals(category))
                if(d.posts.get(i).getLostStuff().getColor().equals(color))
                    if(d.posts.get(i).getLostStuff().getSize().equals(size))
                        index=i;
        }
        if(index==-1)
            showNotFoundMsg();
        else
            showMatchingPost(index,d);
    }

    public void showMatchingPost(int index, Database d)
    {
        System.out.println("A matching post is found ..");
        postControl pc=new postControl();
        pc.showPost(index,d);

    }

    public String showNotFoundMsg()
    {
        return "item not found :( ";
    }

}

