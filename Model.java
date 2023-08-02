public class Model 
{
    private RegularVM RVM;
    private SpecialVM SVM;
    private String foodType;
    private int itemCounter=0;
    String items="";
    String history="";
    String money="";
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
        items="";

        for(i=0;i<getVM().slotCapacity;i++)
        {
            items += getVM().displayItem(i);
            items += "\n";
        }

        return items;
    }

    public String displayHistory()
    {
        int i;
        history="";

        for(i=0;i<getVM().transacHistory.size();i++)
        {
            history += getVM().transacHistory.get(i).getItem().getItemName()+" | "+getVM().transacHistory.get(i).getQty()+
            " | Total Amount: "+getVM().transacHistory.get(i).getVendTotal()+" | User Paid: "+getVM().transacHistory.get(i).getUserPay()+
            " | Change: "+getVM().transacHistory.get(i).getChange();
            history += "\n";
        }

        getVM().vendBalance.setToZero();
        getVM().transacHistory.clear();
        return history;
    }

    public boolean amountisValid(int num)
    {
        if(num>0)
        {
            return true;
        }

        return false;
    }

    public String displayMoney(Money balance)
    {
        money="";
        money += "Php 1   qty: "+balance.getCoin1()+"\n";
        money += "Php 5   qty: "+balance.getCoin5()+"\n";
        money += "Php 10  qty: "+balance.getCoin10()+"\n";
        money += "Php 20  qty: "+balance.getBill20()+"\n";
        money += "Php 50  qty: "+balance.getBill50()+"\n";
        money += "Php 100 qty: "+balance.getBill100()+"\n";
        return money;
    }
}
