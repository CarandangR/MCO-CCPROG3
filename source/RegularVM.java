package mco1.source;
import java.util.Scanner;

public class RegularVM
{
    Slots[] itemSlots;
    Money vendBalance;
    Money userBalance;
    String vendName;
    int slotCapacity;
    int itemCapacity;

    public RegularVM(String vendName, int slotCapacity, int itemCapacity)
    {
        int i;
        this.vendName = vendName;
        itemSlots = new Slots[slotCapacity];
        
        for(i=0;i<slotCapacity;i++)
        {
            itemSlots[i].setSlotLimit(itemCapacity);
        }
    }

    private Slots getSlotInput()
    {
        Scanner sc = new Scanner(System.in);
    }
}