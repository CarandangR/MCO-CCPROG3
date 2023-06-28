package mco1.source;

public class Slots {
    Item item;
    int stock, slotLimit;

    public Slots()
    {}

    public boolean changeStock(Item item)
    {
        return false;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
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

    public int getSlotLimit()
    {
        return slotLimit;
    }

    public void setSlotLimit(int slotLimit)
    {
        this.slotLimit = slotLimit;
    }
}
