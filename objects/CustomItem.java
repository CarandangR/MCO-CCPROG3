package objects;

import java.util.ArrayList;

public class CustomItem extends Items 
{
    ArrayList<Items> ingredients;

    public CustomItem(String name)
    {
        super(name,0,0);
        ingredients = new ArrayList<>();
    }
}
