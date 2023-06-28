package objects;

public class Items {
    private String itemName;
    private float calories;
    private int price;

    public Items()
    {}

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public float getCalories()
    {
        return calories;
    }

    public void setCalories(float calories)
    {
        this.calories = calories;
    }
}

