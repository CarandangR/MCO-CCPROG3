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
                    if(!(model.getVM() instanceof SpecialVM))
                    {
                        view.testSVMvisible(false);
                    }
                    else
                    {
                        view.testSVMvisible(true);
                    }
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
                    if(view.getInputCal()>0 &&view.getInputPrice()>0)
                    {
                        model.getVM().setSlots(new Rice(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                        view.inputDisplay("Added(Rice): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                        model.addItemCounter();
                        model.setFoodType("");
                    }
                    else
                    {
                        view.inputDisplay("You did not select the type of item");
                    }
                }

                else if(model.getFoodType()=="meat")
                {
                    if(view.getInputCal()>0 &&view.getInputPrice()>0)
                    {
                        model.getVM().setSlots(new Meat(view.getInputName(),view.getInputCal(),view.getInputPrice()), model.getItemCounter());
                        view.inputDisplay("Added(Meat): "+model.getVM().itemSlots[model.getItemCounter()].getItem().getItemName());
                        model.addItemCounter();
                        model.setFoodType("");
                    }
                    else
                    {
                        view.inputDisplay("You did not select the type of item");
                    }
                }

                else if(model.getFoodType()=="side")
                {
                    if(view.getInputCal()>0 &&view.getInputPrice()>0)
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
                model.updateInventory();
                model.getVM().setMaintain(true);
            }
        });

        this.view.restockMaintainListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMaintain(), false);
                view.setStatus(view.getVMRestockItem(), true);
                view.restockDisplay("Status of Stock Since Last Restock");
                view.restockDisplay(model.stockHistory());
            }
        });

        this.view.restockItemAddListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(view.getItemRestockChoice()>0 && view.getItemRestockChoice()<=model.getVM().slotCapacity)
                {
                    if(model.getVM().restockItem(view.getItemRestockChoice(),view.getItemRestockAmount()))
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
                        view.restockDisplay(model.displayInventory());
                    }
                }

                else
                {
                    view.clearRestockItemTA();
                    view.clearRestockItemTF();
                    view.restockDisplay("Invalid Inputs!");
                    view.restockDisplay(model.displayInventory());
                }
            }
        });

        this.view.restockItemExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                view.clearRestockItemTA();
                view.clearRestockItemTF();
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
                if(view.getPriceChoice()>0 && view.getPriceChoice()<=model.getVM().slotCapacity)
                {
                    if(model.getVM().setPrice(view.getPriceChoice(), view.getPriceAmount()))
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

                else
                {
                    view.clearPriceTA();
                    view.clearPriceTF();
                    view.setPriceDisplay("Invalid Inputs!");
                    view.setPriceDisplay(model.displayInventory());
                }
            }
        });

        this.view.priceExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                view.clearPriceTA();
                view.clearPriceTF();
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
                    view.clearcollectMoneyTA();
                    view.collectMoneyDisplay(model.displayHistory());
                    model.getVM().vendBalance.setToZero();
                }

                else
                {
                    view.clearcollectMoneyTA();
                    view.collectMoneyDisplay("[There are no transactions that have been made since last maintenance]\n[Money from the Machine Collected]");
                    model.getVM().vendBalance.setToZero();
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

        this.view.restockMoneyListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMaintain(), false);
                view.setStatus(view.getVMRestockMoney(), true);
                view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
            }
        });

        this.view.restockMon1Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.amountisValid(view.getrestockmoneyAmount()))
                {
                    model.getVM().vendBalance.setCoin1(model.getVM().vendBalance.getCoin1()+view.getrestockmoneyAmount());
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }

                else
                {
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay("Invalid Amount!");
                    model.displayMoney(model.getVM().vendBalance);
                }
            }
        });

        this.view.restockMon5Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.amountisValid(view.getrestockmoneyAmount()))
                {
                    model.getVM().vendBalance.setCoin5(model.getVM().vendBalance.getCoin5()+view.getrestockmoneyAmount());
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }

                else
                {
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay("Invalid Amount!");
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }
            }
        });

        this.view.restockMon10Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.amountisValid(view.getrestockmoneyAmount()))
                {
                    model.getVM().vendBalance.setCoin10(model.getVM().vendBalance.getCoin10()+view.getrestockmoneyAmount());
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }

                else
                {
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay("Invalid Amount!");
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }
            }
        });

        this.view.restockMon20Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.amountisValid(view.getrestockmoneyAmount()))
                {
                    model.getVM().vendBalance.setBill20(model.getVM().vendBalance.getBill20()+view.getrestockmoneyAmount());
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }

                else
                {
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay("Invalid Amount!");
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }
            }
        });

        this.view.restockMon50Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.amountisValid(view.getrestockmoneyAmount()))
                {
                    model.getVM().vendBalance.setBill50(model.getVM().vendBalance.getBill50()+view.getrestockmoneyAmount());
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }

                else
                {
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay("Invalid Amount!");
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }
            }
        });

        this.view.restockMon100Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.amountisValid(view.getrestockmoneyAmount()))
                {
                    model.getVM().vendBalance.setBill100(model.getVM().vendBalance.getBill100()+view.getrestockmoneyAmount());
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }

                else
                {
                    view.clearsetMoneyTA();
                    view.clearsetMoneyTF();
                    view.setMoneyDisplay("Invalid Amount!");
                    view.setMoneyDisplay(model.displayMoney(model.getVM().vendBalance));
                }
            }
        });

        this.view.restockMoneyExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.clearsetMoneyTA();
                view.clearsetMoneyTF();
                view.setStatus(view.getVMRestockMoney(), false);
                view.setStatus(view.getVMMaintain(), true);
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

                else
                {
                    view.setStatus(view.getVMMenu(), false);
                    view.setStatus(view.getVMRegTest(), true);
                    view.clearRegTestStatusTA();
                    view.RegTestInventoryDisplay(model.displayInventory());
                    view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                    view.RegTestTotalDisplay("0");
                    view.RegTestChangeDisplay("0");
                }
            }
        });

        this.view.RegTestExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMRegTest(), false);
                view.setStatus(view.getVMMenu(), true);
                view.clearRegTestStatusTA();
                view.clearRegTestChangeTA();
                view.clearRegTestInsertedTA();
                view.clearRegTestTotalTA();
                view.clearRegTestStatusTA();
                view.clearRegTestInventoryTA();
                model.getVM().userBalance.setToZero();
                view.clearRegTestStatusTA();
            }
        });
        

        this.view.RegTestMon1Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setCoin1(model.getVM().userBalance.getCoin1()+1);
                view.clearRegTestInsertedTA();
                view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.RegTestStatusDisplay("[Added] 1 Php");
            }
        });

        this.view.RegTestMon5Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setCoin5(model.getVM().userBalance.getCoin5()+1);
                view.clearRegTestInsertedTA();
                view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.RegTestStatusDisplay("[Added] 5 Php");
            }
        });

        this.view.RegTestMon10Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setCoin10(model.getVM().userBalance.getCoin10()+1);
                view.clearRegTestInsertedTA();
                view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.RegTestStatusDisplay("[Added] 10 Php");
            }
        });

        this.view.RegTestMon20Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setBill20(model.getVM().userBalance.getBill20()+1);
                view.clearRegTestInsertedTA();
                view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.RegTestStatusDisplay("[Added] 20 Php");
            }
        });

        this.view.RegTestMon50Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setBill50(model.getVM().userBalance.getBill50()+1);
                view.clearRegTestInsertedTA();
                view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.RegTestStatusDisplay("[Added] 50 Php");
            }
        });

        this.view.RegTestMon100Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setBill100(model.getVM().userBalance.getBill100()+1);
                view.clearRegTestInsertedTA();
                view.RegTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.RegTestStatusDisplay("[Added] 100 Php");
            }
        });

        this.view.RegTestBuyListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(view.getRegTestIndex()>0 && view.getRegTestIndex()<=model.getVM().slotCapacity)
                {
                    if(view.getRegTestAmount()>0)
                    {
                        if(model.transacPossible(view.getRegTestIndex(), view.getRegTestAmount()))
                        {
                            view.clearRegTestChangeTA();
                            view.clearRegTestInsertedTA();
                            view.RegTestInsertedDisplay("0");
                            view.clearRegTestTotalTA();
                            view.RegTestStatusDisplay("[Buy] "+model.getTempTransac().getItem().itemName+"\nQty: "+model.getTempTransac().getQty()+"\n");
                            view.clearRegTestInventoryTA();
                            view.RegTestInventoryDisplay(model.displayInventory());
                            view.RegTestChangeDisplay(String.valueOf(model.getTempTransac().getChange()));
                            view.RegTestTotalDisplay(String.valueOf(model.getTempTransac().getQty()*model.getTempTransac().getItem().getPrice()));

                        }

                        else
                        {
                            view.RegTestStatusDisplay("[Error] Machine/User Money Not Enough");
                        }


                        view.clearRegTestAmountTF();
                        view.clearRegTestIndexTF();
                    }
                }
                else
                {
                    view.RegTestStatusDisplay("[Invlid] User Input is Invalid");
                }
            }
        });

        this.view.menuTestSListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMMenu(), false);
                view.setStatus(view.getVMSpecTest(), true);
                view.clearSpecTestStatusTA();
                view.SpecTestInventoryDisplay(model.displayInventory());
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestTotalDisplay("0");
                view.SpecTestChangeDisplay("0");
            }
        });

        this.view.SpecTestExitListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setStatus(view.getVMSpecTest(), false);
                view.setStatus(view.getVMMenu(), true);
                view.clearSpecTestStatusTA();
                view.clearSpecTestChangeTA();
                view.clearSpecTestInsertedTA();
                view.clearSpecTestTotalTA();
                view.clearSpecTestStatusTA();
                view.clearSpecTestInventoryTA();
                model.getVM().userBalance.setToZero();
                view.clearSpecTestStatusTA();
            }
        });

        this.view.SpecTestMon1Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setCoin1(model.getVM().userBalance.getCoin1()+1);
                view.clearSpecTestInsertedTA();
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestStatusDisplay("[Added] 1 Php");
            }
        });

        this.view.SpecTestMon5Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setCoin5(model.getVM().userBalance.getCoin5()+1);
                view.clearSpecTestInsertedTA();
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestStatusDisplay("[Added] 5 Php");
            }
        });

        this.view.SpecTestMon10Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setCoin10(model.getVM().userBalance.getCoin10()+1);
                view.clearSpecTestInsertedTA();
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestStatusDisplay("[Added] 10 Php");
            }
        });

        this.view.SpecTestMon20Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setBill20(model.getVM().userBalance.getBill20()+1);
                view.clearSpecTestInsertedTA();
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestStatusDisplay("[Added] 20 Php");
            }
        });

        this.view.SpecTestMon50Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setBill50(model.getVM().userBalance.getBill50()+1);
                view.clearSpecTestInsertedTA();
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestStatusDisplay("[Added] 50 Php");
            }
        });

        this.view.SpecTestMon100Listener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.getVM().userBalance.setBill100(model.getVM().userBalance.getBill100()+1);
                view.clearSpecTestInsertedTA();
                view.SpecTestInsertedDisplay(String.valueOf(model.getVM().userBalance.getTotalMoney()));
                view.SpecTestStatusDisplay("[Added] 100 Php");
            }
        });

        this.view.SpecTestBuyListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(model.getSVM().isComplete())
                {
                    if(model.specialTransacPossible())
                    {
                        view.SpecTestStatusDisplay("[Buy] "+model.getCustomItem().itemName+"\nQty: 1\n");
                        view.clearSpecTestInventoryTA();
                        /* 
                        view.SpecTestInventoryDisplay(model.displayInventory());
                        view.SpecTestChangeDisplay(String.valueOf(model.getTempTransac().getChange()));
                        view.SpecTestTotalDisplay(String.valueOf(model.getTempTransac().getQty()*model.getTempTransac().getItem().getPrice()));*/
                    }
                }

                else
                {
                    view.SpecTestStatusDisplay("[Error] Not Enough Ingredients");
                }

                view.clearSpecTestAmountTF();
                view.clearSpecTestIndexTF();
            }
        });

        this.view.SpecTestAddBagListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(view.getSpecTestIndex()>0 && view.getSpecTestIndex()<=model.getVM().slotCapacity)
                {
                    if(view.getSpecTestAmount()>0)
                    {
                        if(!(model.getVM().itemSlots[view.getSpecTestIndex()-1].getStock() < view.getSpecTestAmount()))
                        {
                            model.addtoBag(view.getSpecTestIndex(), view.getSpecTestAmount());
                            view.SpecTestStatusDisplay("[Bag] Added to Item Bag");
                            view.clearSpecTestAmountTF();
                            view.clearSpecTestIndexTF();
                        }
                        else
                        {
                            view.SpecTestStatusDisplay("[Invlid] User Input is Invalid");
                        }
                        
                    }
                    else
                    {
                        view.SpecTestStatusDisplay("[Invlid] User Input is Invalid");
                    }
                }
                else
                {
                    view.SpecTestStatusDisplay("[Invlid] User Input is Invalid");
                }
            }
        });
    }
}