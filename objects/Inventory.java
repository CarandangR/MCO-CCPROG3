import java.util.ArrayList;
public class Inventory {
    private String name;
    private ArrayList<Slots> itemSlots = new ArrayList<Slots>(); //

    public Inventory(String name, Slots firstSlot)
    {
       this.name = name;
    }
    public void addSlot(Slots slot)
    {
        itemSlots.add(slot);
    }
    public String getInvName()
    {
        return name;
    }
}
