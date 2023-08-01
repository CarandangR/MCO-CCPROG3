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
    protected boolean isNew = true;
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
    }

    /**
     * Method that asks for user input for each Item Slots.
     * @param sc
     * Scanner that will be used for inputs.
     */
    public void setSlots(Items item, int i)
    {
        this.itemSlots[i] = new Slots(item,0);
        this.originalInventory[i] = this.itemSlots[i];
    }

    /**
     * A method to run maintenance of the vending machine.
     * @param sc
     * Scanner that will be used for inputs.
     */
    public void maintenance(Scanner sc)
    {
        int control = 1, choice,i,restockChoice,priceChoice;

        while(control == 1)
        {
            System.out.println("[Maintenance Mode:"+vendName+"]");
            System.out.println("[1] Restock Item");
            System.out.println("[2] Set Price");
            System.out.println("[3] Collect Money and Transaction");
            System.out.println("[4] Restock");
            System.out.println("[5] Exit");
            choice = sc.nextInt();

            if(choice == 1)
            {
                displayStocks();
                do
                {
                    System.out.print("Please pick the item to restock: ");
                    restockChoice = sc.nextInt()-1;
                    if(restockChoice < 0 || restockChoice > slotCapacity-1)
                    {
                        System.out.println("Invalid Input");
                    }
                }while(restockChoice < 0 || restockChoice > slotCapacity-1);

                restockItem(restockChoice, 0);
            }

            if(choice == 2)
            {
                for(i=0;i<slotCapacity;i++)
                {
                    displayItem(i);
                }
                do
                {
                    System.out.print("Please pick the item to set the price: ");
                    priceChoice = sc.nextInt()-1;
                    if(priceChoice < 0 || priceChoice > slotCapacity-1)
                    {
                        System.out.println("Invalid Input");
                    }
                }while(priceChoice < 0 || priceChoice > slotCapacity-1);

                setPrice(priceChoice, sc);
            }

            if(choice == 3)
            {
                collectMoney(sc);
            }

            if(choice == 4)
            {
                restockMoney(sc);
            }

            if(choice == 5)
            {
                control = 0;
            }
        }
    }

    /**
     * A helper method that accepts user input for money.
     * @param sc
     * Scanner that will be used for inputs.
     */
    private void insertMoney(Scanner sc)
    {
        int i = inputMoney(sc);
        addMoney(i,userBalance,sc);
        add2Balances(userBalance,vendBalance);
    }

    /**
     * A Method the processes the transaction of the vending machine.
     * @param sc
     * Scanner that will be used for inputs.
     */
    public void vendTransaction(Scanner sc)
    {
        System.out.println("Testing Vending Machine: "+vendName);
        int i, choice, itemQty,control=1;
        while(control == 1)
        {
            int decision;
            do
            {
                insertMoney(sc);
                System.out.println("Would you like add more?");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                decision = sc.nextInt();
            }while(decision != 2);
            System.out.println("What Item Would You Like to Buy:");
            for(i=0; i < slotCapacity;i++)
            {
                displayItem(i);
            }
            choice = sc.nextInt()-1;

            if(itemSlots[choice].getStock()>0)
            {
                if(choice > 0 || choice <= slotCapacity)
                {
                    shoppingCart = itemSlots[choice];
                    do
                    {
                        System.out.print("Please Input the quantity, [0] to cancel item: ");
                        itemQty = sc.nextInt();

                        if(itemQty < 0 || choice > itemCapacity)
                        {
                            System.out.println("Invalid Input");
                        }

                        if(itemQty == 0)
                        {
                            control = 0;
                        }

                        if(itemQty*shoppingCart.getItem().getPrice() > userBalance.getTotalMoney())
                        {
                            System.out.println("Not enough inserted Money");
                            itemQty = -1;
                        }
                    }while(itemQty < 0 || choice > itemCapacity);

                    shoppingCart.setStock(itemQty);
                    Transaction tempTransaction = new Transaction(shoppingCart.getItem(), shoppingCart.getStock(), userBalance.getTotalMoney(), vendBalance.getTotalMoney());
                    tempTransaction.computeChange();
                    transacHistory.add(tempTransaction);
                    if(compareDenom(vendBalance, getDenom(tempTransaction.computeChange())))
                    {
                        System.out.println("Transaction cancelled, not enough change from the machine.");
                        transacHistory.remove(transacHistory.size()-1);
                    }
                    else 
                    {
                        System.out.println("Dispensing item");
                        itemSlots[choice].setStock(itemSlots[choice].getStock() - shoppingCart.getStock());
                        System.out.println("Dispensing Money");
                        compareDenom(vendBalance, getDenom(transacHistory.get(transacHistory.size() - 1).getChange()));
                        tempTransaction.setVendTotal(vendBalance.getTotalMoney());
                        userBalance.setToZero();
                        int ab;
                        for(ab = 0; ab < transacHistory.size(); ab++)
                        {
                            transacHistory.get(ab).printTransaction();
                        }
                    }
                }
            }

            else if(choice == -1)
            {
                control = 0;
            }
            
            else
            {
                System.out.println("Invalid Input/Item Out of Stock");
            }

            control = 0;
        }
    }

    /**
     * A helper method that restocks the vending machine's balance.
     * @param sc
     * Scanner that will be used for inputs.
     */
    private void restockMoney(Scanner sc)
    {
        int i = inputMoney(sc);
        addMoney(i,vendBalance,sc);
    }

    /**
     * A helper method that collects the vending machine's balance.
     * @param sc
     * Scanner that will be used for inputs.
     */
    private void collectMoney(Scanner sc)
    {
        int choice,i;
        do
        {
        System.out.println("Would you like to collect the money?");
        System.out.println("[1] Yes");
        System.out.println("[0] No");
        choice = sc.nextInt();
        if(choice > 1 || choice < 0)
        {
            System.out.println("invalid Input");
        }
        }while(choice > 1 || choice < 0);

        if(choice == 1)
        {
            System.out.println("Here is the list of transactions Made: ");
            for(i=0;i<transacHistory.size();i++)
            {
                System.out.println(transacHistory.get(i).getItem().getItemName()+"  "+transacHistory.get(i).getQty());
                System.out.println("Total Amount: "+transacHistory.get(i).getVendTotal()+"  User Paid: "+transacHistory.get(i).getUserPay()+"  ");
                System.out.println("Change: "+transacHistory.get(i).getChange());
            }
            System.out.println("Vending Machine Emptied, Total Amount collected is: "+vendBalance.getTotalMoney());
            vendBalance.setToZero();
        }
        else
        {
            System.out.println("Returning to main menu");
        }

    }

    /**
     * A helper method that gets input from the user.
     * @param sc
     * Scanner that will be used for inputs.
     * @return denomInput
     */
    private int inputMoney(Scanner sc)
    {
        int denomInput;
        do {
            System.out.println("Please Enter the Denomination");
            System.out.println("[1] 1 Php Coin");
            System.out.println("[2] 5 Php Coin");
            System.out.println("[3] 10 Php Coin");
            System.out.println("[4] 20 Php Bill");
            System.out.println("[5] 50 Php Bill");
            System.out.println("[6] 100 Php Bill");
            System.out.println("[0] Continue");
            denomInput = sc.nextInt();
            if(denomInput < 0 || denomInput > 6){
                System.out.println("Invalid Choice.");
            }
        } while(denomInput < 0 || denomInput > 6);
        return denomInput;
    }

    /**
     * A helper method that Adds money to the specified money object.
     * @param choice
     * An integer that acts as the decision of the user.
     * @param balance
     * The money object to be updated.
     * @param sc
     * Scanner that will be used for inputs.
     */
    private void addMoney(int choice, Money balance, Scanner sc)
    {
        int quantity, control = 1;

        while(control == 1)
        {
            switch(choice)
            {
                case(1):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add: ");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin1(balance.getCoin1()+quantity);
                    control = 0;
                    break;

                case(2):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add: ");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin5(balance.getCoin5()+quantity);
                    control = 0;
                    break;

                case(3):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add: ");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin10(balance.getCoin10()+quantity);
                    control = 0;
                    break;

                case(4):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add: ");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill20(balance.getBill20()+quantity);
                    control = 0;
                    break;

                case(5):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add: ");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill50(balance.getBill50()+quantity);
                    control = 0;
                    break;

                case(6):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add: ");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill100(balance.getBill100()+quantity);
                    control = 0;
                    break;

                case(0):
                    control = 0;
                    break;

                default:
                    System.out.println("Invalid Input!");
            }
        }
    }

    /**
     * A helper method that sets the price of each item.
     * @param slotNum
     * An integer that represents which slot to edit.
     * @param sc
     * Scanner that will be used for inputs.
     */
    private void setPrice(int slotNum, Scanner sc)
    {
        int repriceValue;
        System.out.println("The Item has a price of: "+itemSlots[slotNum].getItem().getPrice()+" php");
        do
        {
            System.out.print("What will be the new price?: ");
            repriceValue = sc.nextInt();
            if(repriceValue < 0)
            {
                System.out.println("Invalid Input, Please Try again.");
            }
        }while(repriceValue < 0);
        itemSlots[slotNum].getItem().setPrice(repriceValue);
        System.out.println("The new price of "+itemSlots[slotNum].getItem().getItemName()+" is "+itemSlots[slotNum].getItem().getPrice());
    }

    /**
     * A helper method that restocks a specified item.
     * @param slotNum
     * An integer that represents which slot to edit.
     * @param sc
     * Scanner that will be used for inputs.
     */
    public boolean restockItem(int slotNum, int restockAmount)
    {
        if(itemSlots[slotNum].getStock()==itemCapacity)
        {
            return false;
        }

        else if((itemSlots[slotNum].getStock()+restockAmount) < 0 || (itemSlots[slotNum].getStock()+restockAmount) > itemCapacity)
        {
            return false;
        }

        itemSlots[slotNum].setStock(restockAmount+itemSlots[slotNum].getStock());
        originalInventory[slotNum] = itemSlots[slotNum];

        return true;
    }

    /**
     * A helper method that displays a specific slot.
     * @param slotNum
     * An intger that represents which slot to display.
     */
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
    private Money getDenom(int change)
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
    private void add2Balances(Money userBalance, Money vendBalance)
    {
        vendBalance.setCoin1(vendBalance.getCoin1()+userBalance.getCoin1());
        vendBalance.setCoin5(vendBalance.getCoin5()+userBalance.getCoin5());
        vendBalance.setCoin10(vendBalance.getCoin10()+userBalance.getCoin10());
        vendBalance.setBill20(vendBalance.getBill20()+userBalance.getBill20());
        vendBalance.setBill50(vendBalance.getBill50()+userBalance.getBill50());
        vendBalance.setBill100(vendBalance.getBill100()+userBalance.getBill100());
    }

    /**
     * A helper method which displays the before and after stock of items.
     */
    private void displayStocks()
    {
        int i;

        System.out.println("These are how the Items Were Updated Since Last Restock: ");
        for(i=0;i < this.slotCapacity;i++)
        {
            System.out.println("["+(i+1)+"] "+this.itemSlots[i].getItem().getItemName()+": "+this.itemSlots[i].getStock()+" ---> "+this.originalInventory[i].getStock());
        }
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
     * @return
     */
    private boolean compareDenom(Money vendMoney, Money changeMoney)
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

}