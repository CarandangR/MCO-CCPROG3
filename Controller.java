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
                    view.setStatus(view.getStart(), false);
                    view.setvendTitle(model.getVM().vendName);
                    view.setStatus(view.getMenu(), true);
                }
            }
        });

        this.view.menuExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getMenu(), false);
                view.setStatus(view.getStart(), true);
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
                    view.setStatus(view.getMenu(), false);
                    view.setStatus(view.getInput(), true);
                }

                else
                {
                    view.setStatus(view.getMenu(), false);
                    view.setStatus(view.getMaintain(), true);
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
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                    model.addItemCounter();
                }

                else if(model.getFoodType()=="meat")
                {
                    model.getVM().setSlots(new Meat(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                    view.inputDisplay("Added(Meat): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                    model.addItemCounter();
                }

                else if(model.getFoodType()=="side")
                {
                    model.getVM().setSlots(new Side(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                    view.inputDisplay("Added(Side): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                    model.addItemCounter();
                }

                else
                {
                    view.inputDisplay("You did not select the type of item");
                }

                if(model.getItemCounter() == model.getVM().slotCapacity)
                {
                    model.getVM().setIsNew(false);
                    view.setStatus(view.getInput(), false);
                    view.setStatus(view.getMaintain(), true);
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
                view.setStatus(view.getMaintain(), false);
                view.setStatus(view.getMenu(), true);
                model.reset();
            }
        });

        this.view.restockMaintainListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getMaintain(), false);
                view.setStatus(view.getVMRestockItem(), true);
            }
        });

        this.view.restockItemAddListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if()
                {
                    
                }
            }
        });
    }

}