public class guiDriver 
{
    public static void main(String args[])
    {
        View VMview = new View();
        Model VMmodel = new Model();

        Controller VMcontroller = new Controller(VMview,VMmodel);
    }
}