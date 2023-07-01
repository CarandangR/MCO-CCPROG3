/**
 * The Java file for the Object "Slots" Which contains important variables.
 * Simulates a slot in the vending machine which contains a certain item 
 * and the stock of the item.
 * @author Matthew Ryan C. Carandang
 * @author Peter Benjamin A. Tan
 * @version 1.0
 * Section: X22A
 * 
 * The package objects contains all objects used to run the RegularVM object
 * and allows it to be used in main.
 */
package objects;

public class Slots {
    private Items item;
    private int stock;

    /**
     * Constructor for Slots which instantiates the item and stock.
     * variable
     * @param item
     * The Item objects that will be set to Item variable of Slots.
     * @param stock
     * The integer that will be set to the stock integer of Slots.
     */
    public Slots(Items item, int stock)
    {
        this.item = item;
        this.stock = stock;
    }

    /**
     * Gets and returns the Item which is assigned to that slot.
     * @return item
     */
    public Items getItem()
    {
        return item;
    }

    /**
     * Sets the Item object to the Item variable of Slots.
     * @param item
     * The item variable that will be stored in the Item variable of Slots.
     */
    public void setItem(Items item)
    {
        this.item = item;
    }

    /**
     * Gets and returns the stock of the Slots.
     * @return stock
     */
    public int getStock()
    {
        return stock;
    }

    /**
     * Sets the integer of the stock variable.
     * @param stock
     * The integer variable to be set to stock variable.
     */
    public void setStock(int stock)
    {
        this.stock = stock;
    }
}
