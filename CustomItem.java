import java.util.ArrayList;

public class CustomItem extends Items 
{
    private Side side;
    private Rice rice;
    private Meat meat;
    ArrayList<AddOn> Toppings;

    public CustomItem(String name)
    {
        super(name,0,0);
        Toppings = new ArrayList<>();;
    }

    @Override public int getCalories()
    {

        int toppingCal=0;
        int i;

        for(i=0;i<Toppings.size();i++)
        {
            toppingCal += Toppings.get(i).getPrice();
        }

        return super.price + side.getCalories() + rice.getCalories() + meat.getCalories() + toppingCal;
    }

    @Override public int getPrice()
    {
        int toppingPrice=0;
        int i;

        for(i=0;i<Toppings.size();i++)
        {
            toppingPrice += Toppings.get(i).getPrice();
        }

        return super.price + side.getPrice() + rice.getPrice() + meat.getPrice() + toppingPrice;
    }

    public void updateIngredient(Items item)
    {
        if(item instanceof Rice)
        {
            rice = new Rice(item.getItemName(),item.getCalories(),item.getPrice());
        }

        else if(item instanceof Meat)
        {
            meat = new Meat(item.getItemName(),item.getCalories(),item.getPrice());
        }

        else if(item instanceof Side)
        {
            side = new Side(item.getItemName(),item.getCalories(),item.getPrice());
        }
    }

    public void addTopping(AddOn item)
    {
        Toppings.add(item);
    }

    public Rice getRice()
    {
        return rice;
    }

    public void setRice(Rice rice) 
    {
        this.rice = rice;
    }

    public Side getSide() 
    {
        return side;
    }

    public void setSide(Side side) 
    {
        this.side = side;
    }

    public Meat getMeat() 
    {
        return meat;
    }

    public void setMeat(Meat meat) 
    {
        this.meat = meat;
    }

    public ArrayList<AddOn> getToppings() 
    {
        return Toppings;
    }

    public void setToppings(ArrayList<AddOn> toppings) 
    {
        Toppings = toppings;
    }
}
