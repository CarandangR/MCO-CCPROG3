import java.util.ArrayList;

public class SpecialVM extends RegularVM
{
    private ArrayList<AddOn> toppingsbag;
    private ArrayList<Slots> Itembag = new ArrayList<>();

    public SpecialVM(String vendName, int slotCapacity, int itemCapacity)
    {
        super(vendName,slotCapacity,itemCapacity);
    }

    public ArrayList<Slots> getItembag()
    {
        return Itembag;
    }

    public void addTopping(Items item)
    {
        toppingsbag.add(new AddOn(item.getItemName(), item.getCalories(), item.getPrice()));
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