/**
 * The Java file for the Object "Money" Which contains important variables.
 * Money simulates a storage of a vending machine is composed of a coin box
 * and bill box which is organized through its denomination.
 * @author Matthew Ryan C. Carandang
 * @author Peter Benjamin A. Tan
 * @version 1.0
 * Section: X22A
 * 
 * The package objects contains all objects used to run the RegularVM object
 * and allows it to be used in main.
 */
package objects;

public class Money
{
    private int coin1;
    private int coin5;
    private int coin10;
    private int bill20;
    private int bill50;
    private int bill100;
    private int bill200;
    private int bill500;
    private int bill1000;
    private int totalMoney;

    /**
     * Constructor for Money which Insantiates all variables to 0.
     */
    public Money()
    {
        this.coin1 = 0;
        this.coin5 = 0;
        this.coin10 = 0;
        this.bill20 = 0;
        this.bill50 = 0;
        this.bill100 = 0;
        this.bill200 = 0;
        this.bill500 = 0;
        this.bill1000 = 0;
    }

    /**
     * Gets and returns the integer which contains the amount of 1 Php coins.
     * @return coin1
     */
    public int getCoin1()
    {
        return coin1;
    }

    /**
     * Sets the integer which contains the amount of 1 Php coins.
     * @param coin1
     * The integer value that will be stored into the coin1 variable.
     */
    public void setCoin1(int coin1)
    {
        this.coin1 = coin1;
    }

    /**
     * Gets and returns the integer which contains the amount of 5 Php coins.
     * @return coin5
     */
    public int getCoin5()
    {
        return coin5;
    }

    /**
     * Sets the integer which contains the amount of 5 Php coins.
     * @param coin5
     * The integer value that will be stored into the coin5 variable.
     */
    public void setCoin5(int coin5)
    {
        this.coin5 = coin5;
    }

    /**
     * Gets and returns the integer which contains the amount of 10 Php coins.
     * @return coin10
     */
    public int getCoin10()
    {
        return coin10;
    }

    /**
     * Sets the integer which contains the amount of 10 Php coins.
     * @param coin10
     * The integer value that will be stored into the coin10 variable.
     */
    public void setCoin10(int coin10)
    {
        this.coin10 = coin10;
    }

    /**
     * Gets and returns the integer which contains the amount of 20 Php bills.
     * @return bill20
     */
    public int getBill20()
    {
        return bill20;
    }

    /**
     * Sets the integer which contains the amount of 20 Php bills.
     * @param bill20
     * The integer value that will be stored into the bill20 variable.
     */
    public void setBill20(int bill20)
    {
        this.bill20 = bill20;
    }

    /**
     * Gets and returns the integer which contains the amount of 50 Php bills.
     * @return bill50
     */
    public int getBill50()
    {
        return bill50;
    }

    /**
     * Sets the integer which contains the amount of 50 Php bills.
     * @param bill50
     * The integer value that will be stored into the bill50 variable.
     */
    public void setBill50(int bill50)
    {
        this.bill50 = bill50;
    }

    /**
     * Gets and returns the integer which contains the amount of 100 Php bills.
     * @return bill100
     */
    public int getBill100()
    {
        return bill100;
    }

    /**
     * Sets the integer which contains the amount of 100 Php bills.
     * @param bill100
     * The integer value that will be stored into the bill100 variable.
     */
    public void setBill100(int bill100)
    {
        this.bill100 = bill100;
    }

    /**
     * Gets and returns the integer which contains the amount of 200 Php bills.
     * @return bill200
     */
    public int getBill200()
    {
        return bill200;
    }

    /**
     * Sets the integer which contains the amount of 200 Php bills.
     * @param bill200
     * The integer value that will be stored into the bill200 variable.
     */
    public void setBill200(int bill200)
    {
        this.bill200 = bill200;
    }

    /**
     * Gets and returns the integer which contains the amount of 500 Php bills.
     * @return bill500
     */
    public int getBill500()
    {
        return bill500;
    }

    /**
     * Sets the integer which contains the amount of 500 Php bills.
     * @param bill500
     * The integer value that will be stored into the bill500 variable.
     */
    public void setBill500(int bill500)
    {
        this.bill500 = bill500;
    }

    /**
     * Gets and returns the integer which contains the amount of 1000 Php bills.
     * @return bill1000
     */
    public int getBill1000()
    {
        return bill1000;
    }

    /**
     * Sets the integer which contains the amount of 1000 Php bills.
     * @param bill1000
     * The integer value that will be stored into the bill1000 variable.
     */
    public void setBill1000(int bill1000)
    {
        this.bill1000 = bill1000;
    }

    /**
     * Gets and returns the integer which contains the computed amount of total money.
     * @return totalMoney
     */
    public int getTotalMoney()
    {
        this.totalMoney = (getCoin1()*1) + (getCoin5()*5) + (getCoin10()*10) + (getBill20()*20) + (getBill50()*50) 
                     + (getBill100()*100) + (getBill200()*200) + (getBill500()*500) + (getBill1000()*1000);
        return totalMoney;
    }

    /**
     * Sets all denomination into the value of 0.
     */
    public void setToZero()
    {
        this.coin1 = 0;
        this.coin5 = 0;
        this.coin10 = 0;
        this.bill20 = 0;
        this.bill50 = 0;
        this.bill100 = 0;
        this.bill200 = 0;
        this.bill500 = 0;
        this.bill1000 = 0;
    }
}