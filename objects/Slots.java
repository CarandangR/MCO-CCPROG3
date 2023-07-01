package objects;

public class Slots {
    private Items item;
    private int stock;

    public Slots(Items item, int stock)
    {
        this.item = item;
        this.stock = stock;
    }

    public Items getItem()
    {
        return item;
    }

    public void setItem(Items item)
    {
        this.item = item;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }
}
