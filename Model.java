public class Model 
{
    private RegularVM RVM;
    private SpecialVM SVM;
    private String foodType;
    private int itemCounter=0;
    private String items="";
    private String history="";
    private String money="";
    private Transaction temptransaction;
    private String stockHistory="";
    private Items tempItem;

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
            if(RVM != null && SVM == null)
            {
                return "regular";
            }

            if(SVM != null & RVM == null)
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

        return this.SVM;
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
            history += getVM().transacHistory.get(i).getItem().getItemName()+" | Qty: "+getVM().transacHistory.get(i).getQty()+
            "\nTotal Amount in Vend: "+getVM().transacHistory.get(i).getVendTotal()+"\n User Paid: "+getVM().transacHistory.get(i).getUserPay()+
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

    public boolean transacPossible(int slotNum, int Qty)
    {
        getVM().add2Balances(getVM().userBalance, getVM().vendBalance);

        if(getVM().itemSlots[slotNum-1].getStock() < Qty)
        {
            return false;
        }

        else if((getVM().itemSlots[slotNum-1].getItem().price * Qty) > getVM().userBalance.getTotalMoney())
        {
            return false;
        }

        else if(getVM().compareDenom(getVM().vendBalance, getVM().getDenom(getVM().userBalance.getTotalMoney()-(getVM().itemSlots[slotNum-1].getItem().price * Qty))))
        {
            return false;
        }

        temptransaction = new Transaction(getVM().itemSlots[slotNum-1].getItem(), Qty, getVM().userBalance.getTotalMoney(), getVM().vendBalance.getTotalMoney());
        getVM().transacHistory.add(temptransaction);
        getVM().userBalance.setToZero();
        getVM().itemSlots[slotNum-1].setStock(getVM().itemSlots[slotNum-1].getStock() - Qty);

        return true;
    }

    public void updateInventory()
    {
        getVM().updateStartingInventory();
    }

    public String stockHistory()
    {
        int i;
        stockHistory="";

        for(i=0;i<getVM().slotCapacity;i++)
        {
            stockHistory += getVM().inventoryChanges(i);
        }

        return stockHistory;
    }

    public void addtoBag(int slotNum, int Qty)
    {
        SVM.getItembag().add(new Slots(SVM.itemSlots[slotNum-1].getItem(), Qty));
        getVM().itemSlots[slotNum-1].setStock(getVM().itemSlots[slotNum-1].getStock()-Qty);
    }

    public Transaction getTempTransac()
    {
        return temptransaction;
    }

    public SpecialVM getSVM()
    {
        return this.SVM;
    }

    public boolean specialTransacPossible()
    {
        getVM().add2Balances(getVM().userBalance, getVM().vendBalance);

        if(multipleItemsTotal() > getVM().userBalance.getTotalMoney())
        {
            System.out.println("here1");
            return false;
        }

        else if(getVM().compareDenom(getVM().vendBalance, getVM().getDenom(getVM().userBalance.getTotalMoney()-multipleItemsTotal())))
        {
            System.out.println("here2");
            return false;
        }

        System.out.println(multipleItemsTotal());
        tempItem = new Items("Rice Bowl",multipleItemsTotalCalories(),multipleItemsTotal());
        temptransaction = new Transaction(tempItem, 1, getVM().userBalance.getTotalMoney(), getVM().vendBalance.getTotalMoney());
        getVM().userBalance.setToZero();
  
        return true;
    }

    private int multipleItemsTotal()
    {
        int total = 0;
        int i;

        for(i=0;i<SVM.getItembag().size();i++)
        {
            total += (SVM.getItembag().get(i).getItem().getPrice()*SVM.getItembag().get(i).getStock());
        }

        return total;
    }

    private int multipleItemsTotalCalories()
    {
        int total = 0;
        int i;

        for(i=0;i<SVM.getItembag().size();i++)
        {
            total += (SVM.getItembag().get(i).getItem().getCalories()*SVM.getItembag().get(i).getStock());
        }

        return total;
    }

    public Items getCustomItem()
    {
        return tempItem;
    }
}
