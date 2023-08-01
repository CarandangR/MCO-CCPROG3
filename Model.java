import java.util.InputMismatchException;

public class Model 
{
    RegularVM RVM;
    SpecialVM SVM;

    public Model()
    {
    }

    public boolean generateRVM(String vendName, String slotNum, String slotCap)
    {
        int tempslotNum = Integer.parseInt(slotNum);
        int tempslotCap = Integer.parseInt(slotCap);
        if(!(tempslotNum>7 && tempslotNum<11))
        {
            return false;
        }

        else if(!(tempslotCap>5 && tempslotCap<21))
        {
            return false;
        }
        RVM = new RegularVM(vendName, tempslotCap, tempslotCap);
        return true;
    }

    public boolean generateSVM(String vendName, String slotNum, String slotCap)
    {
        int tempslotNum = Integer.parseInt(slotNum);
        int tempslotCap = Integer.parseInt(slotCap);
        if(!(tempslotNum>7 && tempslotNum<11))
        {
            return false;
        }

        else if(!(tempslotCap>5 && tempslotCap<21))
        {
            return false;
        }
        RVM = new SpecialVM(vendName, tempslotCap, tempslotCap);
        return true;
    }

}
