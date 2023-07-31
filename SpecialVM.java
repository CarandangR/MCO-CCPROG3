import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SpecialVM extends RegularVM
{
    private CustomItem customItem;
    private ArrayList<Rice> riceTypes;
    private ArrayList<Meat> meatTypes;
    private ArrayList<Side> sideTypes;
    private ArrayList<AddOn> toppings;

    public SpecialVM(String vendName, int slotCapacity, int itemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
    }

    public void addCustomItem(Items item)
    {
        if(item instanceof Rice)
        {
            riceTypes.add(new Rice(item.getItemName(), item.getCalories(), item.getPrice()));
        }

        else if(item instanceof Meat)
        {
            meatTypes.add(new Meat(item.getItemName(), item.getCalories(), item.getPrice()));
        }

        else if(item instanceof Side)
        {
            sideTypes.add(new Side(item.getItemName(), item.getCalories(), item.getPrice()));
        }
    }

    public void addTopping(Items item)
    {
        toppings.add(new AddOn(item.getItemName(), item.getCalories(), item.getPrice()));
    }
}