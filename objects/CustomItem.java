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

    @Override public int getCalories()
    {   

        return super.calories;
    }

    @Override public void setCalories(int calories)
    {
        super.calories = calories;
    }

    @Override public int getPrice()
    {
        return super.price;
    }

    @Override public void setPrice(int price)
    {
        super.price = price;
    }

    private void updateItem()
    {
        int i;
        for(i=0;i<ingredients.size();i++)
        {
            super.price += ingredients.get(i).getPrice();
            super.calories += ingredients.get(i).getCalories();
        }
    }

    public void addIngredient(Items item)
    {
        ingredients.add(item);
        updateItem();
    }
}
