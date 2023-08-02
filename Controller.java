import java.util.ArrayList;

import javax.swing.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller 
{
    private View view; 
    private Model model;
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;

        this.view.exitVMListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        this.view.RVMListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.clearstartTA();
                if(!(view.isEmpty()))
                {
                    if(model.generateRVM(view.getvendName(), view.getslotNum(), view.getslotCap()))
                    {
                        view.startDisplay("Created RVM "+view.getvendName());
                        view.clearTF();
                    }

                    else
                    {
                        view.startDisplay("Incorrect Input Values!");
                        view.clearTF();
                    }
                }

                else
                {
                    view.startDisplay("Text Fields are Empty");
                }
            }
        });

        this.view.SVMListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.clearstartTA();
                if(!(view.isEmpty()))
                {
                    if(model.generateSVM(view.getvendName(), view.getslotNum(), view.getslotCap()))
                    {
                        view.startDisplay("Created SVM "+view.getvendName());
                        view.clearTF();
                    }

                    else
                    {
                        view.startDisplay("Incorrect Input Values!");
                        view.clearTF();
                    }
                }

                else
                {
                    view.startDisplay("Text Fields are Empty");
                }
            }
        });

        this.view.TestListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.vmType() == null)
                {
                    view.startDisplay("VM not yet created");
                }

                else
                {
                    view.setStatus(view.getVMStart(), false);
                    view.setvendTitle(model.getVM().vendName);
                    view.setStatus(view.getVMMenu(), true);
                }
            }
        });

        this.view.menuExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMenu(), false);
                view.setStatus(view.getVMStart(), true);
                model.reset();
            }
        });

        this.view.menuTestListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!(model.didMaintain()))
                {
                    view.clearMenuTA();
                    view.menuDisplay("Do maintenance to the Machine First");
                }   
            }
        });

        this.view.menuMaintainListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.isNew())
                {
                    view.setStatus(view.getVMMenu(), false);
                    view.setStatus(view.getVMInput(), true);
                }

                else
                {
                    view.setStatus(view.getVMMenu(), false);
                    view.setStatus(view.getVMMaintain(), true);
                }
            }
        });

        this.view.inputItem(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if(model.getFoodType()=="rice")
                {
                    model.getVM().setSlots(new Rice(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                    view.inputDisplay("Added(Rice): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                    model.addItemCounter();
                    model.setFoodType("");
                }

                else if(model.getFoodType()=="meat")
                {
                    model.getVM().setSlots(new Meat(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                    view.inputDisplay("Added(Meat): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                    model.addItemCounter();
                    model.setFoodType("");
                }

                else if(model.getFoodType()=="side")
                {
                    model.getVM().setSlots(new Side(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                    view.inputDisplay("Added(Side): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                    model.addItemCounter();
                    model.setFoodType("");
                }

                else
                {
                    view.inputDisplay("You did not select the type of item");
                }

                if(model.getItemCounter() == model.getVM().slotCapacity)
                {
                    model.getVM().setIsNew(false);
                    view.setStatus(view.getVMInput(), false);
                    view.setStatus(view.getVMMaintain(), true);
                }

                view.clearButton();
                view.clearInputTF();

            }
        });

        this.view.riceListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.setFoodType("rice");
            }
        });

        this.view.meatListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.setFoodType("meat");
            }
        });

        this.view.sideListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.setFoodType("side");
            }
        });

        this.view.exitMaintainListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMaintain(), false);
                view.setStatus(view.getVMMenu(), true);
            }
        });

        this.view.restockMaintainListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMaintain(), false);
                view.setStatus(view.getVMRestockItem(), true);
                view.restockDisplay(model.displayInventory());
            }
        });

        this.view.restockItemAddListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.getVM().restockItem(view.getItemRestockChoice()-1,view.getItemRestockAmount()))
                {
                    view.clearRestockItemTA();
                    view.restockDisplay("Restock Successful!");
                    view.restockDisplay("Updated Items: ");
                    view.restockDisplay(model.displayInventory());
                    view.clearRestockItemTF();
                }

                else
                {
                    view.clearRestockItemTA();
                    view.clearRestockItemTF();
                    view.restockDisplay("Invalid Inputs!");
                }
            }
        });

        this.view.restockItemExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                view.setStatus(view.getVMRestockItem(), false);
                view.setStatus(view.getVMMaintain(), true);
            }
        });

        this.view.SetPriceListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMaintain(), false);
                view.setStatus(view.getVMsetprice(), true);
                view.setPriceDisplay(model.displayInventory());
            }
        });

        this.view.priceAddListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.getVM().setPrice(view.getPriceChoice()-1, view.getPriceAmount()))
                {
                    view.clearPriceTA();
                    view.setPriceDisplay("Reprice Successful!");
                    view.setPriceDisplay("Updated Items: ");
                    view.setPriceDisplay(model.displayInventory());
                    view.clearPriceTF();
                }

                else
                {
                    view.clearPriceTA();
                    view.clearPriceTF();
                    view.setPriceDisplay("Invalid Inputs!");
                }
            }
        });

        this.view.priceExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                view.setStatus(view.getVMsetprice(), false);
                view.setStatus(view.getVMMaintain(), true);
            }
        });

        this.view.collectPriceListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMaintain(), false);
                view.setStatus(view.getVMCollect(), true);

                if(model.getVM().checkTransac())
                {
                    view.collectMoneyDisplay(model.displayHistory());
                }

                else
                {
                    view.collectMoneyDisplay("[There are no transactions that have been made since last maintenance]");
                }
            }
        });

        this.view.collectExitListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMCollect(), false);
                view.setStatus(view.getVMMaintain(), true);
            }
        });
    }
}