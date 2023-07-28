/**
 * The Java file for the Object "Transaction" Which contains important variables.
 * This simulates a history/reciepts of the different transactions done in the
 * vending machine.
 * @author Matthew Ryan C. Carandang
 * @author Peter Benjamin A. Tan
 * @version 2.0
 * Section: X22A
 * 
 * The package objects contains all objects used to run the RegularVM object
 * and allows it to be used in main.
 */
package objects;

public class Transaction {
    private Items item;
    private int Qty;
    private int userPay;
    private int vendTotal;
    private int change;

    /**
     * Constructor for the Transaction object.
     * @param item
     * The Item that will be stored in the item variable of Transaction.
     * @param Qty
     * The integer that will be stored in the Qty variable.
     * @param userPay
     * The integer that will be stored in the userPay variable.
     * @param vendTotal
     * The integer that will be stored in the vendTotal variable.
     */
    public Transaction(Items item, int Qty, int userPay, int vendTotal)
    {
        this.Qty = Qty;
        this.item = item;
        this.userPay = userPay;
        this.vendTotal = vendTotal;
    }

    /**
     * Computes and returns the change.
     * @return change
     */
    public int computeChange()
    {
        this.change = userPay - item.getPrice()*Qty;
        return change;
    }

    /**
     * Prints the transaction.
     */
    public void printTransaction()
    {
        System.out.println("Item: "+ item.getItemName() +"  Qty: " + Qty + "  Change: " + change + "" +
                "  Vend Total left: " + vendTotal);
    }

    /**
     * Gets and returns the item of the transaction.
     * @return item
     */
    public Items getItem()
    {
        return item;
    }

    /**
     * Gets and returns the quantity of the transaction.
     * @return Qty
     */
    public int getQty()
    {
        return Qty;
    }

    /**
     * Gets and returns the userPay integer of the transaction.
     * @return userPay
     */
    public int getUserPay()
    {
        return userPay;
    }

    /**
     * Gets and returns the vendTotal integer of the transaction.
     * @return vendTotal
     */
    public int getVendTotal()
    {
        return vendTotal;
    }

    /**
     * Gets and returns the change of the transaction.
     * @return change
     */
    public int getChange()
    {
        return change;
    }

    /**
     * Sets the vendTotal variable of the transaction.
     * @param newTotal
     * The integer that will be assigned to vendTotal of the transaction.
     */
    public void setVendTotal(int newTotal)
    {
        vendTotal = newTotal;
    }
}
