public class Model 
{
    private RegularVM RVM;
    private SpecialVM SVM;
    private String foodType;
    private int itemCounter=0;
    String items="";
    public Model()
    {
    }

    public boolean generateRVM(String vendName, String slotNum, String slotCap)
    {
        int tempslotNum = Integer.parseInt(slotNum);
        int tempslotCap = Integer.parseInt(slotCap);
        if(!(tempslotNum>7 && tempslotNum<11))
        {
            return false;
        }

        else if(!(tempslotCap>5 && tempslotCap<21))
        {
            return false;
        }
        SVM = null;
        RVM = new RegularVM(vendName, tempslotCap, tempslotCap);
        return true;
    }

    public boolean generateSVM(String vendName, String slotNum, String slotCap)
    {
        int tempslotNum = Integer.parseInt(slotNum);
        int tempslotCap = Integer.parseInt(slotCap);
        if(!(tempslotNum>7 && tempslotNum<11))
        {
            return false;
        }

        else if(!(tempslotCap>9 && tempslotCap<21))
        {
            return false;
        }
        RVM = null;
        SVM = new SpecialVM(vendName, tempslotCap, tempslotCap);
        return true;
    }

    public String vmType()
    {
        if(checkVM())
        {
            if(RVM != null)
            {
                return "regular";
            }

            if(SVM != null)
            {
                return "special"; 
            }
        }
        return null;
    }

    private boolean checkVM()
    {
        if(RVM != null || SVM != null)
        {
            return true;
        }
        return false;
    }

    public RegularVM getVM()
    {
        if(vmType() == "regular")
        {
            return RVM;
        }
        return SVM;
    }

    public boolean didMaintain()
    {
        return getVM().didMaintenance;
    }

    public boolean isNew()
    {
        return getVM().isNew;
    }

    public String getFoodType()
    {
        return foodType;
    }

    public void setFoodType(String foodType)
    {
        this.foodType = foodType;
    }

    public int getItemCounter()
    {
        return itemCounter;
    }

    public void addItemCounter()
    {
        this.itemCounter++;
    }

    public void reset()
    {
        RVM = null;
        SVM = null;
        this.itemCounter=0;
    }

    public String displayInventory()
    {
        int i;

        for(i=0;i<getVM().slotCapacity;i++)
        {
            items += getVM().displayItem(i);
            items += "\n";
        }

        return items;
    }

    public void resetItemString()
    {
        items="";
    }
}
