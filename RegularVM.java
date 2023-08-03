/**
 * The Java file for the Object "RegularVM" Which contains important variables.
 * This simulates the Vending machine itself. Which makes use of all objects such as slots,
 * items, and money.
 * @author Matthew Ryan C. Carandang
 * @author Peter Benjamin A. Tan
 * @version 2.0
 * Section: X22A
 * 
 * The package objects contains all objects used to run the RegularVM object
 * and allows it to be used in main.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class RegularVM
{
    protected Slots[] itemSlots;
    protected Slots[] originalInventory;
    protected Slots shoppingCart;
    protected Money vendBalance = new Money();
    protected Money userBalance = new Money();
    protected String vendName;
    protected int slotCapacity;
    protected int itemCapacity;
    protected boolean didMaintenance = false;
    protected boolean isNew = false; //Edit for testing
    protected ArrayList<Transaction> transacHistory = new ArrayList<Transaction>();

    /**
     * Constructor for the RegularVM object. Which sets values for the
     * variables of the RegularVM
     * @param vendName
     * A String that sets the name of the Vending Machine.
     * @param slotCapacity
     * Sets the integer of the maximum capacity of individual Slots.
     * @param itemCapacity
     * Sets the integer of the mximum capacity of the Stock of each Slot.
     */
    public RegularVM(String vendName, int slotCapacity, int itemCapacity)
    {
        this.vendName = vendName;
        this.itemCapacity = itemCapacity;
        this.slotCapacity = slotCapacity;
        itemSlots = new Slots[slotCapacity];
        originalInventory = new Slots[slotCapacity];

        setSlots(new Rice("White Rice", 155, 8), 0);
        setSlots(new Rice("Brown Rice", 188, 160), 1);
        setSlots(new Rice("Black Rice", 313, 320), 2);
        setSlots(new Meat("Spam", 205, 30), 3);
        setSlots(new Meat("Pork", 180, 200), 4);
        setSlots(new Meat("Chicken", 130, 100), 5);
        setSlots(new Meat("Beef", 250, 50), 6);
        setSlots(new Side("Cabbage", 155, 8), 7);
        setSlots(new Side("Egg", 150, 70), 8);
        setSlots(new Side("Nori", 5, 5), 9);
    }

    public void setSlots(Items item, int i)
    {
        this.itemSlots[i] = new Slots(item,0);
        this.originalInventory[i] = new Slots(item,0);
    }

    public Boolean checkTransac()
    {
        if(transacHistory.size() > 0)
        {
            return true;
        }

        return false;
    }

    public boolean setPrice(int slotNum, int repriceAmount)
    {
        if(repriceAmount < 0)
        {
            return false;
        }

        itemSlots[slotNum-1].getItem().setPrice(repriceAmount);
        return true;
    }

    public boolean restockItem(int slotNum, int restockAmount)
    {
        if(itemSlots[slotNum-1].getStock()==itemCapacity)
        {
            return false;
        }

        else if((itemSlots[slotNum-1].getStock()+restockAmount) < 0 || (itemSlots[slotNum-1].getStock()+restockAmount) > itemCapacity)
        {
            return false;
        }

        itemSlots[slotNum-1].setStock(restockAmount+itemSlots[slotNum-1].getStock());

        return true;
    }

    public String displayItem(int slotNum)
    {
        return "["+(slotNum+1)+"] "+itemSlots[slotNum].getItem().getItemName()+" [ Calories: "+itemSlots[slotNum].getItem().getCalories()+" | Price: "+itemSlots[slotNum].getItem().getPrice()+" | Stock: "+itemSlots[slotNum].getStock()+" ]";
    }

    /**
     * A helper method that processes the given change into 
     * denominations and stores and returns them into a Money object.
     * @param change
     * An integer that represents the change of the transaction which will be turned
     * into denominations.
     * @return Money
     */
    public Money getDenom(int change)
    {
        Money tempMoney = new Money();
        int[] notes = new int[]{1000,500,200,100,50,20,10,5,1};
        int[] notesCounter = new int[9];
        int i;

        for(i=0; i<9;i++)
        {
            if(change >= notes[i])
            {
                notesCounter[i] = change / notes[i];
                change = change % notes[i];
            }
        }

        for(i=0; i<9;i++)
        {
            if(notesCounter[i] != 0)
            {
                if(notes[i]==100)
                {
                    tempMoney.setBill100(notesCounter[i]);
                }
                else if(notes[i]==50)
                {
                    tempMoney.setBill50(notesCounter[i]);
                }
                else if(notes[i]==20)
                {
                    tempMoney.setBill20(notesCounter[i]);
                }
                else if(notes[i]==10)
                {
                    tempMoney.setCoin10(notesCounter[i]);
                }
                else if(notes[i]==5)
                {
                    tempMoney.setCoin5(notesCounter[i]);
                }
                else if(notes[i]==1) {
                    tempMoney.setCoin1(notesCounter[i]);
                }
            }
        }
        return tempMoney;
    }   

    /**
     * A helper method which adds the contents of the Money objects.
     * @param userBalance
     * A money object which represents the user's balance.
     * @param vendBalance
     * A money object whcih represents the vending machine's balance.
     */
    public void add2Balances(Money userBalance, Money vendBalance)
    {
        vendBalance.setCoin1(vendBalance.getCoin1()+userBalance.getCoin1());
        vendBalance.setCoin5(vendBalance.getCoin5()+userBalance.getCoin5());
        vendBalance.setCoin10(vendBalance.getCoin10()+userBalance.getCoin10());
        vendBalance.setBill20(vendBalance.getBill20()+userBalance.getBill20());
        vendBalance.setBill50(vendBalance.getBill50()+userBalance.getBill50());
        vendBalance.setBill100(vendBalance.getBill100()+userBalance.getBill100());
    }

    /**
     * A helper method to determine if the vending machine has underwent maintenance.
     * @return boolean
     */
    public boolean didMaintain()
    {
        return this.didMaintenance;
    }

    /**
     * Sets the status of a vending machine's didMaintenance variable.
     * @param didMaintain
     */
    public void setMaintain(boolean didMaintain)
    {
        this.didMaintenance = didMaintain;
    }

    /**
     * A helper method which compares to money objects.
     * Used for checking if the vending machine has enough bills/coins
     * to provide change.
     * @param vendMoney
     * Represents the money object of the vending machine.
     * @param changeMoney
     * Represents the money object of the change produced.
     * @return flag
     */
    public boolean compareDenom(Money vendMoney, Money changeMoney)
    {
        boolean flag = false;
        if(vendMoney.getBill100() < changeMoney.getBill100())
        {
            flag = true;
        }
        else if(vendMoney.getBill50() < changeMoney.getBill50())
        {
            flag = true;
        }
        else if(vendMoney.getBill20() < changeMoney.getBill20())
        {
            flag = true;
        }
        else if(vendMoney.getCoin10() < changeMoney.getCoin10())
        {
            flag = true;
        }
        else if(vendMoney.getCoin5() < changeMoney.getCoin5())
        {
            flag = true;
        }
        else if(vendMoney.getCoin1() < changeMoney.getCoin1())
        {
            flag = true;
        }
        else if(!flag)
        {
            vendMoney.setBill100(vendMoney.getBill100()-changeMoney.getBill100());
            vendMoney.setBill50(vendMoney.getBill50()-changeMoney.getBill50());
            vendMoney.setBill20(vendMoney.getBill20()-changeMoney.getBill20());
            vendMoney.setCoin10(vendMoney.getCoin10()-changeMoney.getCoin10());
            vendMoney.setCoin5(vendMoney.getCoin5()-changeMoney.getCoin5());
            vendMoney.setCoin1(vendMoney.getCoin1()-changeMoney.getCoin1());
        }
        return flag;
    }

    public void setIsNew(boolean bool)
    {
        this.isNew = bool;
    }

    public void updateStartingInventory()
    {
        int i;
        for(i=0;i<slotCapacity;i++)
        {
            this.originalInventory[i] = new Slots(itemSlots[i].getItem(),itemSlots[i].getStock());
        }
    }

    public String inventoryChanges(int slotNum)
    {
        return "["+(slotNum+1)+"] "+originalInventory[slotNum].getItem().getItemName()+" "+originalInventory[slotNum].getStock()+" ---> "+itemSlots[slotNum].getStock()+"\n";
    }
}