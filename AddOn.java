public class AddOn extends Items
{
    int stock;
    public AddOn(String itemName, int calories, int price, int stock)
    {
        super(itemName, calories, price);
        this.stock = stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getStock()
    {
        return this.stock;
    }
}