public class Money
{
    private int coin1;
    private int coin5;
    private int coin10;
    private int coin20;
    private int bill20;
    private int bill50;
    private int bill100;
    private int bill200;
    private int bill500;
    private int bill1000;
    private int totalMoney;

    public Money()
    {}

    public int getCoin1()
    {
        return coin1;
    }

    public void setCoin1(int coin1)
    {
        this.coin1 = coin1;
    }

    public int getCoin5()
    {
        return coin5;
    }

    public void setCoin5(int coin5)
    {
        this.coin5 = coin5;
    }

    public int getCoin10()
    {
        return coin10;
    }

    public void setCoin10(int coin10)
    {
        this.coin10 = coin10;
    }

    public int getCoin20()
    {
        return coin20;
    }

    public void setCoin20(int coin20)
    {
        this.coin20 = coin20;
    }

    public int getBill20()
    {
        return bill50;
    }

    public void setBill20(int bill20)
    {
        this.bill20 = bill20;
    }

    public int getBill50()
    {
        return bill50;
    }

    public void setBill50(int bill50)
    {
        this.bill50 = bill50;
    }

    public int getBill100()
    {
        return bill100;
    }

    public void setBill100(int bill100)
    {
        this.bill100 = bill100;
    }

    public int getBill200()
    {
        return bill200;
    }

    public void setBill200(int bill200)
    {
        this.bill200 = bill200;
    }

    public int getBill500()
    {
        return bill500;
    }

    public void setBill500(int bill500)
    {
        this.bill500 = bill500;
    }

    public int getBill1000()
    {
        return bill1000;
    }

    public void setBill1000(int bill1000)
    {
        this.bill1000 = bill1000;
    }

    public void getTotalMoney()
    {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney)
    {
        totalMoney += (getCoin1()*1);
        totalMoney += (getCoin5()*5);
        totalMoney += (getCoin10()*10);
        totalMoney += (getCoin20()*20);
        totalMoney += (getBill20()*20);
        totalMoney += (getBill50()*50);
        totalMoney += (getBill100()*100);
        totalMoney += (getBill200()*200);
        totalMoney += (getBill500()*500);
        totalMoney += (getBill1000()*1000);
        this.totalMoney = totalMoney;
    }
}