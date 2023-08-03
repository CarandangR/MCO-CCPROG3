import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;

public class View 
{
    private JFrame vmStart;
    private JButton createRVM, createSVM, testVM, exit;
    private JTextField vendName, slotNum, slotCap;
    private JTextArea startOutput;
    private JLabel enterName, enterNum, enterCap, title;

    private JFrame vmMenu;
    private JButton menuTest, menuTestS, menuMaintain, menuExit;
    private JLabel vendTitle;
    private JTextArea menuOutput;

    private JFrame vmMaintain;
    private JButton restockItem, setPrice, collectMoney, restockMoney, maintainExit;

    private JFrame vmInput;
    private JTextField inputName, inputCalories, inputPrice;
    private JLabel itemName, itemCalories, itemPrice;
    private JButton inputNext;
    private JTextArea inputUpdate;
    private JRadioButton rice, meat, side;
    private ButtonGroup typeGroup;

    private JFrame vmRestockItem;
    private JTextArea restockItemDisplay;
    private JTextField restockItemChoice, restockItemAmount;
    private JLabel restockItemChoicelabel, restockItemAmountlabel;
    private JButton restockItemAdd, restockItemExit;

    private JFrame vmSetPrice;
    private JTextArea priceDisplay;
    private JTextField priceChoice, priceAmount;
    private JLabel priceChoicelabel, priceAmountlabel;
    private JButton priceAdd, priceExit;

    private JFrame vmCollectMoney;
    private JScrollPane collectDisplayscroll;
    private JTextArea collectDisplay;
    private JButton collectExit;

    private JFrame vmRestockMoney;
    private JTextArea restockmoneyDisplay;
    private JLabel restockmoneyAmountLabel;
    private JTextField restockmoneyAmount;
    private JButton restockMon1, restockMon5, restockMon10, restockMon20, restockMon50, restockMon100, restockMoneyExit;

    private JFrame vmRegTest;
    private JTextArea RegTestInventory, RegTestStatus, RegTestChange, RegTestTotal, RegTestInserted;
    private JLabel RegTestAmountLabel, RegTestTotalLabel, RegTestInsertedLabel, RegTestChangeLabel, RegTestIndexLabel;
    private JScrollPane RegTestStatusScroll;
    private JTextField RegTestAmount, RegTestIndex;
    private JButton RegTestExit, RegTestMon1, RegTestMon5, RegTestMon10, RegTestMon20, RegTestMon50, RegTestMon100, RegTestBuy;

    public View()
    {
        vmStart();
        vmMenu();
        vmMaintain();
        vmInput();
        vmRestockItem();
        vmSetPrice();
        vmCollectMoney();
        vmSetMoney();
        vmRegTest();
    }

    public void vmStart()
    {
        vmStart = new JFrame("Vending Machine Factory");

        vmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmStart.setSize(800, 800);;
        vmStart.setResizable(false);
        vmStart.setLocationRelativeTo(null);
        vmStart.setLayout(null);

        createRVM = new JButton("Add RVM");
        createRVM.setBounds(587, 491, 102, 47);
        createSVM = new JButton("Add SVM");
        createSVM.setBounds(445, 491, 102, 47);
        testVM = new JButton("Test Vend");
        testVM.setBounds(110, 491, 153, 47);
        exit = new JButton("Exit");
        exit.setBounds(303, 491, 102, 47);

        vendName = new JTextField();
        vendName.setBounds(400, 221, 289, 47);
        slotNum = new JTextField();
        slotNum.setBounds(400, 311, 289, 47);
        slotCap = new JTextField();
        slotCap.setBounds(400, 401, 289, 47);
        startOutput = new JTextArea();
        startOutput.setBounds(110, 600, 579, 120);
        startOutput.setEditable(false);

        title = new JLabel("Vendo Bot");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(200, 50, 400, 120);
        title.setFont(new Font("Arial",Font.BOLD,30));
        enterName = new JLabel("Enter the Name of Vend");
        enterName.setBounds(110, 221, 153, 47);
        enterNum = new JLabel("Enter the No. of Slots");
        enterNum.setBounds(110, 311, 153, 47);
        enterCap = new JLabel("Enter the cap of each Slot");
        enterCap.setBounds(110, 401, 153, 47);

        vmStart.add(title);
        vmStart.add(createRVM);
        vmStart.add(createSVM);
        vmStart.add(testVM);
        vmStart.add(exit);
        vmStart.add(vendName);
        vmStart.add(slotNum);
        vmStart.add(slotCap);
        vmStart.add(startOutput);
        vmStart.add(enterName);
        vmStart.add(enterNum);
        vmStart.add(enterCap);
        vmStart.add(startOutput);

        vmStart.setVisible(true);
    }

    public void vmMenu()
    {
        vmMenu = new JFrame("Vending Machine Menu");
        vmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmMenu.setSize(800, 800);;
        vmMenu.setResizable(false);
        vmMenu.setLocationRelativeTo(null);
        vmMenu.setLayout(null);

        menuTest = new JButton("Test Regular");
        menuTest.setBounds(160, 183, 203, 75);
        menuTestS = new JButton("Test Special");
        menuTestS.setBounds(436, 183, 203, 75);
        menuMaintain = new JButton("Maintain Vending Machine");
        menuMaintain.setBounds(160, 312, 479, 75);
        menuExit = new JButton("Go Back to Vending Machine Factory");
        menuExit.setBounds(160, 441, 479, 75);

        vendTitle = new JLabel();
        vendTitle.setBounds(160, 54, 479, 75);
        vendTitle.setFont(new Font("Arial",Font.BOLD,30));
        vendTitle.setHorizontalAlignment(SwingConstants.CENTER);

        menuOutput = new JTextArea();
        menuOutput.setBounds(160, 570, 479, 156);
        menuOutput.setEditable(false);

        vmMenu.add(menuTestS);
        vmMenu.add(menuOutput);
        vmMenu.add(vendTitle);
        vmMenu.add(menuTest);
        vmMenu.add(menuMaintain);
        vmMenu.add(menuExit);
    }

    public void vmMaintain()
    {
        vmMaintain = new JFrame("Maintenance Mode");
        vmMaintain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmMaintain.setSize(800, 800);;
        vmMaintain.setResizable(false);
        vmMaintain.setLocationRelativeTo(null);
        vmMaintain.setLayout(null);

        restockItem = new JButton("Restock the Items");
        restockItem.setBounds(221, 110, 358, 75);
        setPrice = new JButton("Set the Price of an Item");
        setPrice.setBounds(221, 236, 358, 75);
        collectMoney = new JButton("Collect Money from Vend");
        collectMoney.setBounds(221, 362, 358, 75);
        restockMoney = new JButton("Restock Money");
        restockMoney.setBounds(221, 488, 358, 75);
        maintainExit = new JButton("Exit Maintenance");
        maintainExit.setBounds(221, 614, 358, 75);

        vmMaintain.add(restockItem);
        vmMaintain.add(setPrice);
        vmMaintain.add(collectMoney);
        vmMaintain.add(restockMoney);
        vmMaintain.add(maintainExit);

    }

    public void vmInput()
    {
        vmInput = new JFrame("[Input] Item Input Mode");
        vmInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmInput.setSize(800, 800);;
        vmInput.setResizable(false);
        vmInput.setLocationRelativeTo(null);
        vmInput.setLayout(null);

        itemName = new JLabel("Enter the name of the Item");
        itemName.setBounds(160, 54, 201, 75);
        itemCalories = new JLabel("Enter the Calories");
        itemCalories.setBounds(160, 183, 201, 75);
        itemPrice = new JLabel("Enter the Price");
        itemPrice.setBounds(160, 312, 201, 75);

        inputName = new JTextField();
        inputName.setBounds(438, 54, 201, 75);
        inputCalories = new JTextField();
        inputCalories.setBounds(438, 183, 201, 75);
        inputPrice = new JTextField();
        inputPrice.setBounds(438, 312, 201, 75);
        inputUpdate = new JTextArea();
        inputUpdate.setBounds(160, 570, 479, 156);
        inputUpdate.setEditable(false);

        inputNext = new JButton("Add Item");
        inputNext.setBounds(438, 441, 201, 75);

        rice = new JRadioButton("Rice");
        rice.setBounds(160, 441, 75, 75);
        meat = new JRadioButton("Meat");
        meat.setBounds(236, 441, 75, 75);
        side = new JRadioButton("Side");
        side.setBounds(312, 441, 75, 75);

        typeGroup = new ButtonGroup();
        typeGroup.add(rice);
        typeGroup.add(meat);
        typeGroup.add(side);

        vmInput.add(rice);
        vmInput.add(meat);
        vmInput.add(side);
        vmInput.add(itemName);
        vmInput.add(itemCalories);
        vmInput.add(itemPrice);
        vmInput.add(inputName);
        vmInput.add(inputCalories);
        vmInput.add(inputPrice);
        vmInput.add(inputUpdate);
        vmInput.add(inputNext);
    }

    public void vmRestockItem()
    {
        vmRestockItem = new JFrame("[Maintenance] Restock Mode");
        vmRestockItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmRestockItem.setSize(800, 800);
        vmRestockItem.setResizable(false);
        vmRestockItem.setLocationRelativeTo(null);
        vmRestockItem.setLayout(null);

        restockItemDisplay = new JTextArea();
        restockItemDisplay.setBounds(152, 10, 495, 309);
        restockItemDisplay.setEditable(false);

        restockItemChoice = new JTextField();
        restockItemChoice.setBounds(477, 350, 170, 63);
        restockItemAmount = new JTextField();
        restockItemAmount.setBounds(477, 450, 170, 63);

        restockItemChoicelabel = new JLabel("Enter the Index of the Item");
        restockItemChoicelabel.setBounds(152, 350, 170, 63);
        restockItemAmountlabel = new JLabel("Enter the Quantity");
        restockItemAmountlabel.setBounds(152, 450, 170, 63);

        restockItemAdd = new JButton("Add item to Stock");
        restockItemAdd.setBounds(477, 600, 170, 63);
        restockItemExit = new JButton("Exit Restock Mode");
        restockItemExit.setBounds(152, 600, 170, 63);

        vmRestockItem.add(restockItemDisplay);
        vmRestockItem.add(restockItemChoice);
        vmRestockItem.add(restockItemAmount);
        vmRestockItem.add(restockItemChoicelabel);
        vmRestockItem.add(restockItemAmountlabel);
        vmRestockItem.add(restockItemAdd);
        vmRestockItem.add(restockItemExit);
    }

    public void vmSetPrice()
    {
        vmSetPrice = new JFrame("[Maintenance] Reprice Mode");
        vmSetPrice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmSetPrice.setSize(800, 800);;
        vmSetPrice.setResizable(false);
        vmSetPrice.setLocationRelativeTo(null);
        vmSetPrice.setLayout(null);

        priceDisplay = new JTextArea();
        priceDisplay.setBounds(152, 10, 495, 309);
        priceDisplay.setEditable(false);

        priceChoice = new JTextField();
        priceChoice.setBounds(477, 350, 170, 63);
        priceAmount = new JTextField();
        priceAmount.setBounds(477, 450, 170, 63);

        priceChoicelabel = new JLabel("Enter the Index of the Item");
        priceChoicelabel.setBounds(152, 350, 170, 63);
        priceAmountlabel = new JLabel("Enter the new Price");
        priceAmountlabel.setBounds(152, 450, 170, 63);

        priceAdd = new JButton("Reprice Item");
        priceAdd.setBounds(477, 600, 170, 63);
        priceExit = new JButton("Exit Reprice Mode");
        priceExit.setBounds(152, 600, 170, 63);

        vmSetPrice.add(priceDisplay);
        vmSetPrice.add(priceChoice);
        vmSetPrice.add(priceAmount);
        vmSetPrice.add(priceChoicelabel);
        vmSetPrice.add(priceAmountlabel);
        vmSetPrice.add(priceAdd);
        vmSetPrice.add(priceExit);
    }

    public void vmCollectMoney()
    {
        vmCollectMoney = new JFrame("[Maintenance] Collect Money Mode");
        vmCollectMoney.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmCollectMoney.setSize(800, 800);;
        vmCollectMoney.setResizable(false);
        vmCollectMoney.setLocationRelativeTo(null);
        vmCollectMoney.setLayout(null);

        collectDisplay = new JTextArea();
        collectDisplay.setEditable(false);
        collectDisplayscroll = new JScrollPane(collectDisplay);
        collectDisplayscroll.setBounds(110, 50, 579, 550);
        collectDisplayscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        collectExit = new JButton("Exit");
	    collectExit.setBounds(323, 610, 153, 47);

        vmCollectMoney.add(collectDisplayscroll);
        vmCollectMoney.add(collectExit);
    }

    public void vmSetMoney()
    {
        vmRestockMoney = new JFrame("[Maintenance] Restock Money Mode");
        vmRestockMoney.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmRestockMoney.setSize(800, 800);;
        vmRestockMoney.setResizable(false);
        vmRestockMoney.setLocationRelativeTo(null);
        vmRestockMoney.setLayout(null);

        restockmoneyDisplay = new JTextArea();
        restockmoneyDisplay.setBounds(152, 10, 495, 309);
        restockmoneyDisplay.setEditable(false);

        restockmoneyAmountLabel = new JLabel("Enter the amount");
        restockmoneyAmountLabel.setBounds(275, 496, 112, 31);

        restockmoneyAmount = new JTextField();
        restockmoneyAmount.setBounds(414, 496, 73, 31);

        restockMon1 = new JButton("1");
	    restockMon1.setBounds(110, 560, 73, 55);
        restockMon5 = new JButton("5");
	    restockMon5.setBounds(212, 560, 73, 55);
        restockMon10 = new JButton("10");
	    restockMon10.setBounds(314, 560, 73, 55);
        restockMon20 = new JButton("20");
	    restockMon20.setBounds(414, 560, 73, 55);
        restockMon50 = new JButton("50");
	    restockMon50.setBounds(516, 560, 73, 55);
        restockMon100 = new JButton("100");
	    restockMon100.setBounds(616, 560, 73, 55);
        restockMoneyExit = new JButton("Exit");
	    restockMoneyExit.setBounds(324, 652, 152, 55);

        vmRestockMoney.add(restockmoneyDisplay);
        vmRestockMoney.add(restockmoneyAmountLabel);
        vmRestockMoney.add(restockmoneyAmount);
        vmRestockMoney.add(restockMon1);
        vmRestockMoney.add(restockMon5);
        vmRestockMoney.add(restockMon10);
        vmRestockMoney.add(restockMon20);
        vmRestockMoney.add(restockMon50);
        vmRestockMoney.add(restockMon100);
        vmRestockMoney.add(restockMoneyExit);
    }

    public void vmRegTest()
    {
        vmRegTest = new JFrame("[Testing] Regular Vending Machine");
        vmRegTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmRegTest.setSize(800, 800);;
        vmRegTest.setResizable(false);
        vmRegTest.setLocationRelativeTo(null);
        vmRegTest.setLayout(null);

        RegTestInventory = new JTextArea();
        RegTestInventory.setBounds(31, 31, 377, 324);
        RegTestInventory.setEditable(false);
        RegTestStatus = new JTextArea();
        RegTestStatus.setEditable(false);
        RegTestTotal = new JTextArea();
        RegTestTotal.setBounds(531, 511, 215, 52);
        RegTestTotal.setEditable(false);
        RegTestInserted = new JTextArea();
        RegTestInserted.setBounds(531, 600, 215, 52);
        RegTestInserted.setEditable(false);
        RegTestChange = new JTextArea();
        RegTestChange.setBounds(531, 689, 215, 42);
        RegTestChange.setEditable(false);

        RegTestStatusScroll = new JScrollPane(RegTestStatus);
        RegTestStatusScroll.setBounds(531, 31, 215, 437);
        RegTestStatusScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        RegTestStatus.setCaretPosition(RegTestStatus.getDocument().getLength());

        RegTestIndexLabel = new JLabel("Enter the Item Index:");
        RegTestIndexLabel.setBounds(31, 373, 122, 42);
        RegTestAmountLabel = new JLabel("Enter the Item Qty:");
        RegTestAmountLabel.setBounds(31, 433, 122, 42);
        RegTestTotalLabel = new JLabel("Total:");
        RegTestTotalLabel.setBounds(412, 511, 96, 52);
        RegTestInsertedLabel = new JLabel("Inserted:");
        RegTestInsertedLabel.setBounds(412, 600, 96, 52);
        RegTestChangeLabel = new JLabel("Change:");
        RegTestChangeLabel.setBounds(412, 689, 96, 52);

        RegTestIndex = new JTextField();
        RegTestIndex.setBounds(193, 373, 215, 42);
        RegTestAmount = new JTextField();
        RegTestAmount.setBounds(193, 433, 215, 42);

        RegTestMon1 = new JButton("1");
	    RegTestMon1.setBounds(31, 503, 70, 68);
        RegTestMon5 = new JButton("5");
	    RegTestMon5.setBounds(123, 503, 70, 68);
        RegTestMon10 = new JButton("10");
	    RegTestMon10.setBounds(215, 503, 70, 68);
        RegTestMon20 = new JButton("20");
	    RegTestMon20.setBounds(307, 503, 70, 68);
        RegTestMon50 = new JButton("50");
	    RegTestMon50.setBounds(31, 592, 70, 68);
        RegTestMon100 = new JButton("100");
	    RegTestMon100.setBounds(123, 592, 70, 68);
        RegTestBuy = new JButton("Buy");
	    RegTestBuy.setBounds(215, 689, 162, 52);
        RegTestExit = new JButton("Exit");
	    RegTestExit.setBounds(31, 689, 162, 52);

        vmRegTest.add(RegTestInventory);
        vmRegTest.add(RegTestStatusScroll);
        vmRegTest.add(RegTestTotal);
        vmRegTest.add(RegTestInserted);
        vmRegTest.add(RegTestChange);
        vmRegTest.add(RegTestAmount);
        vmRegTest.add(RegTestAmountLabel);
        vmRegTest.add(RegTestTotalLabel);
        vmRegTest.add(RegTestInsertedLabel);
        vmRegTest.add(RegTestChangeLabel);
        vmRegTest.add(RegTestIndex);
        vmRegTest.add(RegTestIndexLabel);
        vmRegTest.add(RegTestMon1);
        vmRegTest.add(RegTestMon5);
        vmRegTest.add(RegTestMon10);
        vmRegTest.add(RegTestMon20);
        vmRegTest.add(RegTestMon50);
        vmRegTest.add(RegTestMon100);
        vmRegTest.add(RegTestBuy);
        vmRegTest.add(RegTestExit);
    }

    /* Buttons/Radio Buttons */

    public void exitVMListener(ActionListener e)
    {
        exit.addActionListener(e);
    }

    public void RVMListener(ActionListener e)
    {
        createRVM.addActionListener(e);
    }

    public void SVMListener(ActionListener e)
    {
        createSVM.addActionListener(e);
    }

    public void TestListener(ActionListener e)
    {
        testVM.addActionListener(e);
    }

    public void menuExitListener(ActionListener e)
    {
        menuExit.addActionListener(e);
    }

    public void menuTestListener(ActionListener e)
    {
        menuTest.addActionListener(e);
    }

    public void menuTestSListener(ActionListener e)
    {
        menuTestS.addActionListener(e);
    }


    public void menuMaintainListener(ActionListener e)
    {
        menuMaintain.addActionListener(e);
    }

    public void riceListener(ActionListener e)
    {
        rice.addActionListener(e);
    }

    public void meatListener(ActionListener e)
    {
        meat.addActionListener(e);
    }

    public void sideListener(ActionListener e)
    {
        side.addActionListener(e);
    }

    public void exitMaintainListener(ActionListener e)
    {
        maintainExit.addActionListener(e);
    }

    public void restockMaintainListener(ActionListener e)
    {
        restockItem.addActionListener(e);
    }

    public void restockItemAddListener(ActionListener e)
    {
        restockItemAdd.addActionListener(e);
    }

    public void restockItemExitListener(ActionListener e)
    {
        restockItemExit.addActionListener(e);
    }

    public void priceAddListener(ActionListener e)
    {
        priceAdd.addActionListener(e);
    }

    public void priceExitListener(ActionListener e)
    {
        priceExit.addActionListener(e);
    }

    public void SetPriceListener(ActionListener e)
    {
        setPrice.addActionListener(e);
    }

    public void collectPriceListener(ActionListener e)
    {
        collectMoney.addActionListener(e);
    }

    public void collectExitListener(ActionListener e)
    {
        collectExit.addActionListener(e);
    }

    public void restockMoneyListener(ActionListener e)
    {
        restockMoney.addActionListener(e);
    }

    public void restockMon1Listener(ActionListener e)
    {
        restockMon1.addActionListener(e);
    }

    public void restockMon5Listener(ActionListener e)
    {
        restockMon5.addActionListener(e);
    }

    public void restockMon10Listener(ActionListener e)
    {
        restockMon10.addActionListener(e);
    }

    public void restockMon20Listener(ActionListener e)
    {
        restockMon20.addActionListener(e);
    }

    public void restockMon50Listener(ActionListener e)
    {
        restockMon50.addActionListener(e);
    }

    public void restockMon100Listener(ActionListener e)
    {
        restockMon100.addActionListener(e);
    }

    public void restockMoneyExitListener(ActionListener e)
    {
        restockMoneyExit.addActionListener(e);
    }

    public void RegTestExitListener(ActionListener e)
    {
        RegTestExit.addActionListener(e);
    }

    public void RegTestMon1Listener(ActionListener e)
    {
        RegTestMon1.addActionListener(e);
    }

    public void RegTestMon5Listener(ActionListener e)
    {
        RegTestMon5.addActionListener(e);
    }

    public void RegTestMon10Listener(ActionListener e)
    {
        RegTestMon10.addActionListener(e);
    }

    public void RegTestMon20Listener(ActionListener e)
    {
        RegTestMon20.addActionListener(e);
    }

    public void RegTestMon50Listener(ActionListener e)
    {
        RegTestMon50.addActionListener(e);
    }

    public void RegTestMon100Listener(ActionListener e)
    {
        RegTestMon100.addActionListener(e);
    }

    public void RegTestBuyListener(ActionListener e)
    {
        RegTestBuy.addActionListener(e);
    }

    /* Text Fields*/

    public int getItemRestockChoice()
    {
        try 
        {
            return Integer.parseInt(restockItemChoice.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getItemRestockAmount()
    {
        try 
        {
            return Integer.parseInt(restockItemAmount.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getInputCal()
    {
        try 
        {
            return Integer.parseInt(inputCalories.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getInputPrice()
    {
        try 
        {
            return Integer.parseInt(inputPrice.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public String getInputName()
    {
        return inputName.getText();
    }

    public String getvendName()
    {
        return vendName.getText();
    }

    public String getslotNum()
    {
        return slotNum.getText();
    }

    public String getslotCap()
    {
        return slotCap.getText();
    }

    public int getPriceChoice()
    {
        try 
        {
            return Integer.parseInt(priceChoice.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getPriceAmount()
    {
        try 
        {
            return Integer.parseInt(priceAmount.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getrestockmoneyAmount()
    {
        try 
        {
            return Integer.parseInt(restockmoneyAmount.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getRegTestAmount()
    {
        try 
        {
            return Integer.parseInt(RegTestAmount.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public int getRegTestIndex()
    {
        try 
        {
            return Integer.parseInt(RegTestIndex.getText());
        } 
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    /* JFrame getter */

    public JFrame getVMStart()
    {
        return vmStart;
    }

    public JFrame getVMMenu()
    {
        return vmMenu;
    }

    public JFrame getVMMaintain()
    {
        return vmMaintain;
    }

    public JFrame getVMInput()
    {
        return vmInput;
    }

    public JFrame getVMsetprice()
    {
        return vmSetPrice;
    }

    public JFrame getVMRestockItem()
    {
        return vmRestockItem;
    }

    public JFrame getVMCollect()
    {
        return vmCollectMoney;
    }

    public JFrame getVMRestockMoney()
    {
        return vmRestockMoney;
    }

    public JFrame getVMRegTest()
    {
        return vmRegTest;
    }

    /* Clear TA */

    public void clearstartTA()
    {
        startOutput.setText("");
    }

    public void clearInputTA()
    {
        inputUpdate.setText("");
    }

    public void clearRestockItemTA()
    {
        restockItemDisplay.setText("");
    }

    public void clearMenuTA()
    {
        menuOutput.setText("");
    }

    public void clearPriceTA()
    {
        priceDisplay.setText("");
    }

    public void clearsetMoneyTA()
    {
        restockmoneyDisplay.setText("");
    }

    public void clearcollectMoneyTA()
    {
        collectDisplay.setText("");
    }

    public void clearRegTestInventoryTA()
    {
        RegTestInventory.setText("");
    }

    public void clearRegTestStatusTA()
    {
        RegTestStatus.setText("");
    }

    public void clearRegTestTotalTA()
    {
        RegTestTotal.setText("");
    }

    public void clearRegTestInsertedTA()
    {
        RegTestInserted.setText("");
    }

    public void clearRegTestChangeTA()
    {
        RegTestChange.setText("");
    }

    /* Clear TF */

    public void clearTF()
    {
        vendName.setText("");
        slotNum.setText("");
        slotCap.setText("");
    }

    public void clearInputTF()
    {
        inputName.setText("");
        inputCalories.setText("");
        inputPrice.setText("");
    }

    public void clearRestockItemTF()
    {
        restockItemAmount.setText("");
        restockItemChoice.setText("");
    }

    public void clearPriceTF()
    {
        priceChoice.setText("");
        priceAmount.setText("");
    }

    public void clearsetMoneyTF()
    {
        restockmoneyAmount.setText("");
    }

    public void clearRegTestIndexTF()
    {
        RegTestIndex.setText("");
    }

    public void clearRegTestAmountTF()
    {
        RegTestAmount.setText("");
    }

    /* Display Screens */

    public void startDisplay(String text)
    {
        startOutput.append(text+"\n");
    }

    public void restockDisplay(String text)
    {
        restockItemDisplay.append(text+"\n");
    }

    public void menuDisplay(String text)
    {
        menuOutput.append(text+"\n");
    }

    public void inputDisplay(String text)
    {
        inputUpdate.append(text+"\n");
    }

    public void setPriceDisplay(String text)
    {
        priceDisplay.append(text+"\n");
    }

    public void collectMoneyDisplay(String text)
    {
        collectDisplay.append(text);
    }

    public void setMoneyDisplay(String text)
    {
        restockmoneyDisplay.append(text+"\n");
    }

    public void RegTestInventoryDisplay(String text)
    {
        RegTestInventory.append(text+"\n");
    }

    public void RegTestStatusDisplay(String text)
    {
        RegTestStatus.append(text+"\n");
    }

    public void RegTestTotalDisplay(String text)
    {
        RegTestTotal.append(text+"\n");
    }

    public void RegTestInsertedDisplay(String text)
    {
        RegTestInserted.append(text+"\n");
    }

    public void RegTestChangeDisplay(String text)
    {
        RegTestChange.append(text+"\n");
    }

    /* Helper Functions */

    public void inputItem(ActionListener e)
    {
        inputNext.addActionListener(e);
    }

    public boolean isEmpty()
    {
        if(vendName.getText().length() == 0)
        {
            return true;
        }

        else if(slotNum.getText().length() == 0)
        {
            return true;
        }

        else if(slotCap.getText().length() == 0)
        {
            return true;
        }

        return false;
    }

    public void setvendTitle(String name)
    {
        vendTitle.setText(name);
    }

    public void setStatus(JFrame frame, boolean bool)
    {
        frame.setVisible(bool);
    }

    public void clearButton()
    {
        typeGroup.clearSelection();
    }

    public void testSVMvisible(boolean bool)
    {
        menuTestS.setVisible(bool);
    }
}