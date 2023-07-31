/**
 * The Java file for the Object "Items" Which contains important variables.
 * Item is a class which simulates a real life item found in the grocery where
 * it displays its name, calories, and its price.
 * @author Matthew Ryan C. Carandang
 * @author Peter Benjamin A. Tan
 * @version 2.0
 * Section: X22A
 * 
 * The package objects contains all objects used to run the RegularVM object
 * and allows it to be used in main.
 */

public class Items {
    protected String itemName;
    protected int calories;
    protected int price;

    /**
     * Constructor for the class "Items". Sets values for variables under "Items".
     * @param itemName
     * This is the string that sets the name of the object.
     * @param calories
     * This is the float that sets the amount calories the item has.
     * @param price
     * this is teh integer that sets the price of the item.
     */
    public Items(String itemName, int calories, int price)
    {
        this.itemName = itemName;
        this.calories = calories;
        this.price = price;
    }

    /**
     * Gets and returns the String in which the name of the item is contained.
     * @return itemName
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Sets the String that contains the name of the item.
     * @param itemName
     * The String that will be stored to name of the item.
     */
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * Gets and returns the integer which contains the price of the item.
     * @return price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Sets the integer which contains the price of the item.
     * @param price
     * The integer value that will be stored into the price variable.
     */
    public void setPrice(int price)
    {
        this.price = price;
    }

    /**
     * Gets and returns the float in which the amount of calories of the item is stored.
     * @return calories
     */
    public int getCalories()
    {
        return calories;
    }

    /**
     * Sets the float which contains the calories of the item.
     * @param calories
     * The float value that will be stored into the calories variable.
     */
    public void setCalories(int calories)
    {
        this.calories = calories;
    }
}

