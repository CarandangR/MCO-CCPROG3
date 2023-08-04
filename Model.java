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
    private int toppingPrice = 0;
    private int toppingCalories = 0;
    /**
     * Constructor for model.
     */
    public Model()
    {
    }
    /**
     * Constructor for generating Regular vending machine, includes validation for Slot number and sizes.
     *@param vendName
     *String of the name for the vending machine.
     * @param slotNum
     *String to be parsed for the amount of slots of the vending machine.
     *@param slotCap
     *String to be parsed for the limit of each slot.
     *  @return boolean
     */
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
    /**
     * Constructor for generating Special vending machine, includes validation for Slot number and sizes.
     * @param vendName
     * String of the name for the vending machine.
     * @param slotNum
     * String to be parsed for the amount of slots of the vending machine.
     * @param slotCap
     * String to be parsed for the limit of each slot.
     * @return boolean
     */
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
    /**
     * Checks vending machine type.
     * @return String
     */
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
    /**
     * Checks if special vending machine transaction is possible
     * @return boolean
     */
    private boolean checkVM()
    {
        if(RVM != null || SVM != null)
        {
            return true;
        }
        return false;
    }
    /**
     * Gets vending machine.
     * @return RegularVM
     */
    public RegularVM getVM()
    {
        if(vmType() == "regular")
        {
            return RVM;
        }

        return this.SVM;
    }
    /**
     * Gets didMaintenance from Vending Machine.
     * @return boolean
     */
    public boolean didMaintain()
    {
        return getVM().didMaintenance;
    }
    /**
     * Gets isNew from Vending Machine.
     * @return boolean
     */
    public boolean isNew()
    {
        return getVM().isNew;
    }
    /**
     * Checks if special vending machine transaction is possible
     * @return boolean
     */
    public String getFoodType()
    {
        return foodType;
    }
    /**
     * Sets food type.
     */
    public void setFoodType(String foodType)
    {
        this.foodType = foodType;
    }
    /**
     * Gets itemCounter.
     * @return Int
     */
    public int getItemCounter()
    {
        return itemCounter;
    }
    /**
     * Increments item counter.
     */
    public void addItemCounter()
    {
        this.itemCounter++;
    }
    /**
     * Resets the vending machines.
     */
    public void reset()
    {
        RVM = null;
        SVM = null;
        this.itemCounter=0;
    }
    /**
     * Displays the inventory of the vending machine.
     * @return boolean
     */
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
    /**
     * Displays the transaction history.
     * @return String
     */
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
    /**
     * Checks if input is valid
     * @param num
     * Integer number.
     * @return boolean
     */
    public boolean amountisValid(int num)
    {
        if(num>0)
        {
            return true;
        }

        return false;
    }
    /**
     * Displays the denominations of the given money.
     * @param balance
     * Money object for the denominations of the balance.
     * @return String
     */
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
    /**
     * Checks if transaction is possible to be made.
     * @param slotNum
     * Integer of slot number from display.
     * @param Qty
     * Integer of amount of items from that slot.
     * @return boolean
     */
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
    /**
     * Updates inventory of the vending machine.
     */
    public void updateInventory()
    {
        getVM().updateStartingInventory();
    }
    /**
     * Updates stockHistory using inventoryChanges
     * @return String
     */
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
    /**
     * Adds an item and its quantity to the Itembag and updates the stock of the vending machine
     * based on the stock taken.
     */
    public void addtoBag(int slotNum, int Qty)
    {
        SVM.getItembag().add(new Slots(SVM.itemSlots[slotNum-1].getItem(), Qty));
        getVM().itemSlots[slotNum-1].setStock(getVM().itemSlots[slotNum-1].getStock()-Qty);
    }
    /**
     * Gets temp transaction
     * @return Transaction
     */
    public Transaction getTempTransac()
    {
        return temptransaction;
    }
    /**
     * Gets the Special Vending Machine
     * @return SpecialVM
     */
    public SpecialVM getSVM()
    {
        return this.SVM;
    }
    /**
     * Checks if special vending machine transaction is possible
     * @return boolean
     */
    public boolean specialTransacPossible()
    {
        toppingPrice = 0;
        toppingCalories = 0;
        getVM().add2Balances(getVM().userBalance, getVM().vendBalance);

        if(multipleItemsTotal() > getVM().userBalance.getTotalMoney())
        {
            return false;
        }

        else if(getVM().compareDenom(getVM().vendBalance, getVM().getDenom(getVM().userBalance.getTotalMoney()-multipleItemsTotal())))
        {
            return false;
        }

        else if(SVM.getTopping() != null)
        {
            toppingPrice = SVM.getTopping().getPrice();
            toppingCalories = SVM.getTopping().getCalories();
        }
        tempItem = new Items("Rice Bowl",multipleItemsTotalCalories()+toppingCalories,multipleItemsTotal()+toppingPrice);
        temptransaction = new Transaction(tempItem, 1, getVM().userBalance.getTotalMoney(), getVM().vendBalance.getTotalMoney());
        getVM().userBalance.setToZero();
        getVM().transacHistory.add(temptransaction);
        SVM.resetItemBag();
        SVM.resetTopping();
        return true;
    }
    /**
     * Totals the items' prices from Itembag
     * @return int
     */
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
    /**
     * Totals the items' calories from itembag
     * @return int
     */
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
    /**
     * Gets custom item
     * @return Items
     */
    public Items getCustomItem()
    {
        return tempItem;
    }
    /**
     * Adds topping to the Special Vending Machine
     */
    public void addTopping(String name, int calories, int price)
    {
        SVM.addTopping(name, calories, price);
    }
}
