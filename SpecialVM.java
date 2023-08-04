import java.util.ArrayList;

public class SpecialVM extends RegularVM
{
    private AddOn toppings;
    private ArrayList<Slots> Itembag = new ArrayList<>();

    public SpecialVM(String vendName, int slotCapacity, int itemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
    }

    public ArrayList<Slots> getItembag()
    {
        return Itembag;
    }

    public void addTopping(String name, int calories, int price)
    {
        toppings = new AddOn(name, calories, price);
    }

    public AddOn getTopping()
    {
        return toppings;
    }

    public void resetItemBag()
    {
        this.Itembag = new ArrayList<>();
    }

    public void resetTopping()
    {
        this.toppings = null;
    }

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