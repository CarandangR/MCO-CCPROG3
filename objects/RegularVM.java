package objects;
import java.util.ArrayList;
import java.util.Scanner;

public class RegularVM
{
    private Slots[] itemSlots;
    private Money vendBalance;
    private Money userBalance;
    private String vendName;
    private int slotCapacity;
    private int itemCapacity;
    private ArrayList<Transaction> transacHistory = new ArrayList<Transaction>();

    public RegularVM(String vendName, int slotCapacity, int itemCapacity)
    {
        int i;
        this.vendName = vendName;
        itemSlots = new Slots[slotCapacity];
        
        Scanner sc = new Scanner(System.in);
        for(i=0;i<slotCapacity;i++)
        {
            this.itemSlots[i] = getSlotInput(sc);
        }
        sc.close();
    }

    private Slots getSlotInput(Scanner sc)
    {
        return new Slots(getItemInput(sc),0);
    }   

    private Items getItemInput(Scanner sc)
    {
        String name;
        float calories;
        int price;
        System.out.print("Please Input the Name of the Item: ");
        name = sc.nextLine();
        System.out.print("Please Input the Calories of the Item: ");
        calories = sc.nextFloat();
        System.out.print("Please Input the Price of the Item: ");
        price = sc.nextInt();

        return new Items(name,calories,price);
    }

    public void maintenance(Scanner sc)
    {
        int control = 1, choice,i,restockChoice,priceChoice;

        while(control == 1)
        {
            System.out.println("[Maintenance Mode]");
            System.out.println("[1] Restock Item");
            System.out.println("[2] Set Price");
            System.out.println("[3] Collect Money and Transaction");
            System.out.println("[4] Restock");
            System.out.println("[5] Exit");
            choice = sc.nextInt();

            if(choice == 1)
            {
                for(i=0;i<slotCapacity;i++)
                {
                    displayItem(i);
                }
                do
                {
                    System.out.print("Please pick the item to restock: ");
                    restockChoice = sc.nextInt()-1;
                    if(restockChoice < 0 || restockChoice > slotCapacity)
                    {
                        System.out.println("Invalid Input");
                    }
                }while(restockChoice < 0 || restockChoice > slotCapacity);

                restockItem(restockChoice, sc);
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
                    if(priceChoice < 0 || priceChoice > slotCapacity)
                    {
                        System.out.println("Invalid Input");
                    }
                }while(priceChoice < 0 || priceChoice > slotCapacity);

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
        }
    }

    public void insertMoney(Scanner sc)
    {
        addMoney(inputMoney(sc),userBalance,sc);
    }

    public void vendTransaction(Scanner sc)
    {

    }

    private void restockMoney(Scanner sc)
    {
        addMoney(inputMoney(sc),vendBalance,sc);
    }

    private void collectMoney(Scanner sc)
    {
        int choice,i,j;
        do
        {
        System.out.println("Would you like to collect the money?");
        System.out.println("[1] Yes");
        System.out.println("[0] No");
        choice = sc.nextInt();
        if(choice != 1 || choice != 0)
        {
            System.out.println("invalid Input");
        }
        }while(choice != 1 || choice != 0);

        if(choice == 1)
        {
            System.out.println("Here is the list of transactions Made: ");
            for(i=0;i<transacHistory.size();i++)
            {
                System.out.println(transacHistory.get(i).getItem()+"  "+transacHistory.get(i).getQty());
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

    private int inputMoney(Scanner sc)
    {
        System.out.println("Please Enter the Denomination you want to restock: ");
        System.out.println("[1] 1 Php Coin");
        System.out.println("[2] 5 Php Coin");
        System.out.println("[3] 10 Php Coin");
        System.out.println("[4] 20 Php Coin");
        System.out.println("[5] 20 Php Bill");
        System.out.println("[6] 50 Php Bill");
        System.out.println("[7] 100 Php Bill");
        System.out.println("[8] 200 Php Bill");
        System.out.println("[9] 500 Php Bill");
        System.out.println("[10] 1000 Php Bill");
        System.out.println("[0] Exit");

        return sc.nextInt();
    }

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
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin1(balance.getCoin1()+quantity);
                    break;

                case(2):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin5(balance.getCoin5()+quantity);
                    break;

                case(3):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin10(balance.getCoin10()+quantity);
                    break;

                case(4):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setCoin20(balance.getCoin20()+quantity);
                    break;

                case(5):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill20(balance.getBill20()+quantity);
                    break;

                case(6):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill50(balance.getBill50()+quantity);
                    break;

                case(7):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill100(balance.getBill100()+quantity);
                    break;

                case(8):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill200(balance.getBill200()+quantity);
                    break;

                case(9):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill500(balance.getBill500()+quantity);
                    break;

                case(10):
                    do
                    {
                        System.out.print("Please Input the quantity you want to add");
                        quantity = sc.nextInt();
                        if(quantity < 0)
                        {
                            System.out.println("Invalid Input, please Try again.");
                        }
                    }while(quantity < 0);

                    balance.setBill1000(balance.getBill1000()+quantity);
                    break;

                case(0):
                    control = 0;
                    break;

                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
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

    private void restockItem(int slotNum, Scanner sc)
    {
        int restockAmount;
        if(itemSlots[slotNum].getStock()==itemCapacity)
        {
            System.out.println("The Slot is Currently Full");
        }
        else
        {
            System.out.print("The Slot has "+itemSlots[slotNum].getStock()+" Items, How much Would like to add?: ");
            do
            {
                restockAmount = sc.nextInt();
                if((itemSlots[slotNum].getStock()+restockAmount) < 0 || (itemSlots[slotNum].getStock()+restockAmount) >= itemCapacity)
                {
                    System.out.println("The Value Exceeds the limit or is invalid, please try again.");
                }

            }while((itemSlots[slotNum].getStock()+restockAmount) < 0 || (itemSlots[slotNum].getStock()+restockAmount) > itemCapacity);

            itemSlots[slotNum].setStock(restockAmount+itemSlots[slotNum].getStock());
        }
    }

    private void displayItem(int slotNum)
    {
        System.out.println("["+(slotNum+1)+"] "+itemSlots[slotNum].getItem().getItemName());
    }
}