package objects;
import java.util.Scanner;

public class RegularVM
{
    private Slots[] itemSlots;
    private Money vendBalance;
    private Money userBalance;
    private String vendName;
    private int slotCapacity;
    private int itemCapacity;

    public RegularVM(String vendName, int slotCapacity, int itemCapacity)
    {
        int i;
        this.vendName = vendName;
        itemSlots = new Slots[slotCapacity];
        
        for(i=0;i<slotCapacity;i++)
        {
            this.itemSlots[i] = getSlotInput();
        }
    }

    private Slots getSlotInput()
    {
        Slots tempSlots = new Slots();
        tempSlots.setItem(getItemInput());
        tempSlots.setStock(0);

        return tempSlots;
    }   

    private Items getItemInput()
    {
        Items tempItems = new Items();
        Scanner sc = new Scanner(System.in);
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

    public void acceptMoney()
    {

    }

    private void restockMoney()
    {

    }

    private void collectMoney()
    {

    }

    private void setPrice(int slotNum)
    {
        int repriceValue;
        Scanner sc = new Scanner(System.in);
        System.out.println("The Item has a price of: "+itemSlots[slotNum].getItem().getPrice()+" php");
        do
        {
            repriceValue = sc.nextInt();
        }while(repriceValue < 0);
        itemSlots[slotNum].getItem().setPrice(repriceValue);
    }

    private void restockItem(int slotNum)
    {
        int restockAmount;
        Scanner sc = new Scanner(System.in);
        if(itemSlots[slotNum].getStock()==itemCapacity)
        {
            System.out.println("The Slot is Currently Full");
        }
        else
        {
            System.out.println("The Slot has "+itemSlots[slotNum].getStock()+" Items, How much Would like to add?");
            do
            {
                restockAmount = sc.nextInt();
                if((itemSlots[slotNum].getStock()+restockAmount) < 0 || (itemSlots[slotNum].getStock()+restockAmount) >= itemCapacity)
                {
                    System.out.println("The Value Exceeds the limit or is invalid, please try again.");
                }

            }while((itemSlots[slotNum].getStock()+restockAmount) < 0 || (itemSlots[slotNum].getStock()+restockAmount) >= itemCapacity);

            itemSlots[slotNum].setStock(restockAmount+itemSlots[slotNum].getStock());
        }
    }
}