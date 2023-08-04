/**
 * The java file that acts as a main file or driver to run the gui implementation.
 * @author Matthew Ryan C. Carandang
 * @author Peter Benjamin A. Tan
 * @version 2.0
 * Section: X22A
 */
public class guiDriver 
{
    public static void main(String args[])
    {
        View VMview = new View();
        Model VMmodel = new Model();

        Controller VMcontroller = new Controller(VMview,VMmodel);
    }
}