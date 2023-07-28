package objects;


public class SpecialVM extends RegularVM
{
    CustomItem[] customitemSlots;

    public SpecialVM(String vendName, int slotCapacity, int itemCapacity, int customItemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
        customitemSlots = new CustomItem[customItemCapacity];
    }
}
