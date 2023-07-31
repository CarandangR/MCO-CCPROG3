import java.util.ArrayList;
import java.util.Scanner;

public class SpecialVM extends RegularVM
{
    CustomItem[] customitemSlots;
    ArrayList<Slots> customCart;
    AddOn[] AddOns;
    int AddOnCap;


    public SpecialVM(String vendName, int slotCapacity, int itemCapacity, int customItemCapacity, int AddOnCap)
    {
        super(vendName,slotCapacity,itemCapacity);
        customitemSlots = new CustomItem[customItemCapacity];
        customCart = new ArrayList<>();
        AddOns = new AddOn[AddOnCap];
        this.AddOnCap = AddOnCap;
    }

    public void addCustomItem(Scanner sc)
    {
        int i, j, ingredientcount;
        String name;
        for(i=0;i<customitemSlots.length;i++)
        {
            System.out.print("Name of the Custom item: ");
            name = sc.nextLine();
            customitemSlots[i] = new CustomItem(name);

            System.out.print("How Many Ingredients does "+name+" has?: ");
            ingredientcount = sc.nextInt();

            for(j=0;j<ingredientcount;j++)
            {
                customitemSlots[i].addIngredient(customSlotInput(sc));
            }
        }
    }

    private Slots customSlotInput(Scanner sc)
    {
        int i,slotNum;

        for(slotNum=0;slotNum<slotCapacity;slotNum++)
        {
            displayItem(slotNum);
        }
        System.out.print("Enter which ingreadient to add: ");
        i = sc.nextInt();
        Items tempItem = itemSlots[i].getItem();
        System.out.print("Enter the Amount needed: ");
        int tempStock = sc.nextInt();

        return new Slots(tempItem, tempStock);
    }

    public boolean isComplete(CustomItem customItem)
    {
        int i,j;
        int check=0;

        if(!(checkStock(customItem)))
        {
            return false;
        }

        for(i=0;i<customItem.getIngredients().size();i++)
        {
            for(j=0;j<customCart.size();j++)
            {
                if(customItem.getIngredients().get(i).getItem().itemName.equals(customCart.get(j).getItem().getItemName()))
                {
                    if(customItem.getIngredients().get(i).getStock() <= customCart.get(j).getStock())
                    {
                        check++;
                    }
                }
            }
        }

        if(check == customItem.getIngredients().size())
        {
            return true;
        }

        return false;
    }

    private boolean checkStock(CustomItem customItem)
    {
        int i,j;
        int check=0;

        for(i=0;i<customItem.getIngredients().size();i++)
        {
            for(j=0;j<slotCapacity;j++)
            {
                if(customItem.getIngredients().get(i).getItem().itemName.equals(itemSlots[j].getItem().getItemName()))
                {
                    if(customItem.getIngredients().get(i).getStock() <= itemSlots[j].getStock())
                    {
                        check++;
                    }
                }
            }
        }

        if(check == customItem.getIngredients().size())
        {
            return true;
        }

        return false;
    }

    public void updateCart(Slots purchased)
    {
        customCart.add(purchased);
    }

    public void makeAddOn(Scanner sc)
    {
        int i;
        String name;
        int calories;
        int price;

        for(i=0;i<AddOnCap;i++)
        {
            System.out.print("Please Input the Name of the Item: ");
            name = sc.nextLine();
            do
            {
                System.out.print("Please Input the Calories of the Item: ");
                calories = sc.nextInt();
            }while(calories < 1);

            do
            {
                System.out.print("Please Input the Price of the Item: ");
                price = sc.nextInt();
            }while(price < 1);

            do
            {
                System.out.print("Please Input the Price of the Item: ");
                price = sc.nextInt();
            }while(price < 1);

            sc.nextLine();

            AddOns[i].setItemName(name);
            AddOns[i].setCalories(calories);
            AddOns[i].setPrice(price);
            AddOns[i].setStock(0);
        }
    }

    public void restockAddOn(int slotNum)
    {
        int stock;
        do
        {   
            
        }
    }
}