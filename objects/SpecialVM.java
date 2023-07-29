package objects;

import java.util.Scanner;

public class SpecialVM extends RegularVM
{
    CustomItem[] customitemSlots;
    CustomItem[] customShoppingcart;

    public SpecialVM(String vendName, int slotCapacity, int itemCapacity, int customItemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
        customitemSlots = new CustomItem[customItemCapacity];
    }

    public void addCustomItem(Scanner sc)
    {
        int i;
        for(i=0;i<customitemSlots.length;i++)
        {
            customitemSlots[i] = customItemInput(sc);
        }
    }

    private CustomItem customItemInput(Scanner sc)
    {
        String name="";
        return new CustomItem(name);
    }

    public boolean isComplete(CustomItem customItem)
    {
        int i;
        return false;
    }
}