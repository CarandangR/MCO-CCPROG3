package objects;
import java.util.ArrayList;
import java.util.Scanner;

public class RegularVM
{
    private Slots[] itemSlots;
    private Money vendBalance;
    private Money userChange;
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
        Slots tempSlots = new Slots();
        tempSlots.setItem(getItemInput(sc));
        tempSlots.setStock(0);

        return tempSlots;
    }   

    private Items getItemInput(Scanner sc)
    {
        Items tempItems = new Items();
        System.out.print("Please Input the Name of the Item: ");
        tempItems.setItemName(sc.nextLine());
        System.out.print("Please Input the Calories of the Item: ");
        tempItems.setCalories(sc.nextFloat());
        System.out.print("Please Input the Price of the Item: ");
        tempItems.setPrice(sc.nextInt());

        return tempItems;
    }

    public void maintenance()
    {

    }

    public void insertMoney(Scanner sc)
    {

    }

    public void payVending(Scanner sc)
    {

    }

    private void restockMoney(Scanner sc)
    {
        int choice, quantity;

        choice = inputMoney(sc);
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

            vendBalance.setCoin1(vendBalance.getCoin1()+quantity);
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

            vendBalance.setCoin5(vendBalance.getCoin5()+quantity);
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

            vendBalance.setCoin10(vendBalance.getCoin10()+quantity);
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

            vendBalance.setCoin20(vendBalance.getCoin20()+quantity);
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

            vendBalance.setBill20(vendBalance.getBill20()+quantity);
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

            vendBalance.setBill50(vendBalance.getBill50()+quantity);
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

            vendBalance.setBill100(vendBalance.getBill100()+quantity);
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

            vendBalance.setBill200(vendBalance.getBill200()+quantity);
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

            vendBalance.setBill500(vendBalance.getBill500()+quantity);
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

            vendBalance.setBill1000(vendBalance.getBill1000()+quantity);
            break;

            case(0):
            break;

            default:
                System.out.println("Invalid Input!");
        }

    }

    private void collectMoney(Scanner sc)
    {

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
}