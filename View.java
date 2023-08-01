import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
    private JButton menuTest, menuMaintain, menuExit;
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
    ButtonGroup typeGroup;

    private JFrame vmRestockItem;
    private JTextArea restockItemDisplay;
    private JTextField restockItemChoice, restockItemAmount;
    private JLabel restockItemChoicelabel, restockItemAmountlabel;
    private JButton restockItemAdd, restockItemExit;

    private JFrame vmSetPrice;
    private JTextArea priceDisplay;
    private TextField priceChoice, priceAmount;

    private JFrame vmCollectMoney;
    private JTextArea displayTransac;
    private JButton exitCollect;

    private JFrame vmRestockMoney;
    private JTextArea restockmoneyDisplay;
    private TextField restockmoneyChoice, restockmoneyAmount;

    public View()
    {
        vmStart();
        vmMenu();
        vmMaintain();
        vmInput();
        vmRestockItem();
    }

    public void vmStart()
    {
        vmStart = new JFrame("Vending Machine Factory");

        vmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmStart.setSize(800, 800);;
        vmStart.setResizable(false);
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
        vmMenu.setLayout(null);

        menuTest = new JButton("Test Vending Machine");
        menuTest.setBounds(160, 183, 479, 75);
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
        vmInput = new JFrame("Item Input Mode");
        vmInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmInput.setSize(800, 800);;
        vmInput.setResizable(false);
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

    public int getItemRestockChoice()
    {
        return Integer.parseInt(restockItemChoice.getText());
    }

    public int getItemRestockAmount()
    {
        return Integer.parseInt(restockItemAmount.getText());
    }

    public void restockDisplay(String text)
    {
        restockItemDisplay.append(text+"\n");
    }

    public void inputItem(ActionListener e)
    {
        inputNext.addActionListener(e);
    }

    public String getInputName()
    {
        return inputName.getText();
    }

    public int getInputCal()
    {
        return Integer.parseInt(inputCalories.getText());
    }

    public int getInputPrice()
    {
        return Integer.parseInt(inputPrice.getText());
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

    public JFrame getStart()
    {
        return vmStart;
    }

    public JFrame getMenu()
    {
        return vmMenu;
    }

    public JFrame getMaintain()
    {
        return vmMaintain;
    }

    public JFrame getInput()
    {
        return vmInput;
    }

    public void startDisplay(String text)
    {
        startOutput.append(text+"\n");
    }

    public void clearTF()
    {
        vendName.setText("");
        slotNum.setText("");
        slotCap.setText("");
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

    public void clearstartTA()
    {
        startOutput.setText("");
    }

    public void setvendTitle(String name)
    {
        vendTitle.setText(name);
    }

    public void menuDisplay(String text)
    {
        menuOutput.append(text+"\n");
    }

    public void clearMenuTA()
    {
        menuOutput.setText("");
    }

    public void setStatus(JFrame frame, boolean bool)
    {
        frame.setVisible(bool);
    }

    public void clearInputTF()
    {
        inputName.setText("");
        inputCalories.setText("");
        inputPrice.setText("");
    }

    public void clearInputTA()
    {
        inputUpdate.setText("");
    }

    public void inputDisplay(String text)
    {
        inputUpdate.append(text+"\n");
    }

    public void clearButton()
    {
        typeGroup.clearSelection();
    }

    public JFrame getVMRestockItem()
    {
        return vmRestockItem;
    }
}
