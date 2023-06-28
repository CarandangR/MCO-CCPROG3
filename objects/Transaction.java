public class Transaction {
    private Item item;
    private int Qty;
    private int userPay;
    private int vendTotal;
    private int change;

    public Transaction(Item item, int Qty, int userPay, int vendTotal)
    {
        this.Qty = Qty;
        this.item = item;
        this.userPay = userPay;
        this.vendTotal = vendTotal;
    }

    public void computeChange()
    {
        this.change = userPay - item.getPrice();
        this.vendTotal -= this.change;

    }

    public void printTransaction()
    {
        System.out.println("Item: "+ item.getName() +"  Qty: " + Qty + "  Change: " + change + "" +
                "  Vend Total left: " + vendTotal);
    }
    public int getChange()
    {
        return change; // can use to produce change  
    }
}
