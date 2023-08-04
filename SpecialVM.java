import java.util.ArrayList;

public class SpecialVM extends RegularVM
{
    private AddOn toppings;
    private ArrayList<Slots> Itembag = new ArrayList<>();
    /**
     * Constructor for special vending machine.
     *@param vendName
     *String of the name for the vending machine.
     *@param slotCapacity
     *Int for the amount of slots of the vending machine.
     *@param itemCapacity
     *Int for the limit of each slot.
     */
    public SpecialVM(String vendName, int slotCapacity, int itemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
    }

    public ArrayList<Slots> getItembag()
    {
        return Itembag;
    }
    /**
     * Adds a new topping.
     */
    public void addTopping(String name, int calories, int price)
    {
        toppings = new AddOn(name, calories, price);
    }
    /**
     * Gets toppings.
     */
    public AddOn getTopping()
    {
        return toppings;
    }
    /**
     * Resets the item bag to empty.
     */
    public void resetItemBag()
    {
        this.Itembag = new ArrayList<>();
    }
    /**
     * Resets toppings.
     */
    public void resetTopping()
    {
        this.toppings = null;
    }
    /**
     * Checks if complete with Rice, Meat, and Side.
     * @return boolean
     */
    public boolean isComplete()
    {
        if(checkRice())
        {
            return false;
        }

        else if(checkMeat())
        {
            return false;
        }

        else if(checkSide())
        {
            return false;
        }

        return true;
    }
    /**
     * Checks if there is Rice object
     * @return boolean
     */
    private boolean checkRice()
    {
        int i;

        for(i=0;i<Itembag.size();i++)
        {
            if(Itembag.get(i).getItem() instanceof Rice)
            {   
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if there is Meat object
     * @return boolean
     */
    private boolean checkMeat()
    {
        int i;

        for(i=0;i<Itembag.size();i++)
        {
            if(Itembag.get(i).getItem() instanceof Meat)
            {   
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if there is Side object
     * @return boolean
     */
    private boolean checkSide()
    {
        int i;

        for(i=0;i<Itembag.size();i++)
        {
            if(Itembag.get(i).getItem() instanceof Side)
            {   
                return false;
            }
        }
        return true;
    }
}