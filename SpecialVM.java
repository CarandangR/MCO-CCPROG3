import java.util.ArrayList;

public class SpecialVM extends RegularVM
{
    private CustomItem customItem;
    private ArrayList<AddOn> toppings;

    public SpecialVM(String vendName, int slotCapacity, int itemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
    }

    public void addComponent(Items item)
    {
        if(item instanceof Rice)
        {
            customItem.setRice(new Rice(item.getItemName(), item.getCalories(), item.getPrice()));
        }

        else if(item instanceof Meat)
        {
            customItem.setMeat(new Meat(item.getItemName(), item.getCalories(), item.getPrice()));
        }

        else if(item instanceof Side)
        {
            customItem.setSide(new Side(item.getItemName(), item.getCalories(), item.getPrice()));
        }
    }

    public void addTopping(Items item)
    {
        toppings.add(new AddOn(item.getItemName(), item.getCalories(), item.getPrice()));
    }
}