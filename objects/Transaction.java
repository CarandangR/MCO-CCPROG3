package objects;

public class Transaction {
    private Items item;
    private int Qty;
    private int userPay;
    private int vendTotal;
    private int change;

    public Transaction(Items item, int Qty, int userPay, int vendTotal)
    {
        this.Qty = Qty;
        this.item = item;
        this.userPay = userPay;
        this.vendTotal = vendTotal;
    }

    public int computeChange()
    {
        this.change = userPay - item.getPrice()*Qty;
        return change;
    }

    public void printTransaction()
    {
        System.out.println("Item: "+ item.getItemName() +"  Qty: " + Qty + "  Change: " + change + "" +
                "  Vend Total left: " + vendTotal);
    }

    public Items getItem()
    {
        return item;
    }

    public int getQty()
    {
        return Qty;
    }

    public int getUserPay()
    {
        return userPay;
    }

    public int getVendTotal()
    {
        return vendTotal;
    }

    public int getChange()
    {
        return change;
    }
    
}
