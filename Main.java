import objects.RegularVM;
import java.util.Scanner;
public class Main 
{   
    public static void main(String[] args)
    {
        RegularVM regularVending = null;
        Scanner sc = new Scanner(System.in);
        int control = 1;
        int choice;
        boolean hasVend = false;

        while(control > 0)
        {
            System.out.println("[1] Create Vending Machine");
            System.out.println("[2] Test Vending Machine");
            System.out.println("[3] Maintenance");
            System.out.println("[4] Exit");
            do
            {
                choice = sc.nextInt();
                if(choice < 1 || choice > 4)
                {
                    System.out.println("Invalid Input");
                }
            }while(choice < 1 || choice > 4);

            if(choice == 1)
            {
                int slotCap,itemCap;
                String vendName;
                do
                {
                    sc.nextLine();
                    System.out.print("Vend name: ");
                    vendName = sc.nextLine();
                    System.out.print("Number of Slots (Min: 8): ");
                    slotCap = sc.nextInt();
                    System.out.print("Max Number of Items per Slot (Min: 10): ");
                    itemCap = sc.nextInt();

                    if(slotCap < 8 || itemCap < 10)
                    {
                        System.out.println("Invalid Input");
                    }

                }while(slotCap < 8 || itemCap < 10);

                regularVending = new RegularVM(vendName, slotCap, itemCap);
                sc.nextLine();
                regularVending.setSlots(sc);
                hasVend = true;
                
            }

            else if(choice == 2)
            {
                control = 2;

                if(hasVend)
                {
                    if(regularVending.didMaintain())
                    {
                        regularVending.vendTransaction(sc);
                    }

                    else
                    {
                        System.out.println("Please Do Maintenance Mode first");
                    }
                }

                else
                {
                    System.out.println("Please Create a vending machine first");
                }
            }

            else if(choice == 3)
            {
                control = 3;

                if(hasVend)
                {
                    regularVending.maintenance(sc);
                    regularVending.setMaintain(true);
                }

                else
                {
                    System.out.println("Please Create a vending machine first");
                }
            }

            else if(choice == 4)
            {
                control = 0;
                System.out.println("Terminating Program");
            }
        }
        sc.close();
    }
}