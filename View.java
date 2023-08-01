import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Font;
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
    public View()
    {
        vmStart();
    }

    public void vmStart()
    {
        vmStart = new JFrame("Vending Machine Factory");

        vmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmStart.setBounds(0, 0, 800, 800);;
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

        title = new JLabel("Vendo Bot",SwingConstants.CENTER);
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

    public void exitVMListener(ActionListener e)
    {
        exit.addActionListener(e);
    }

    public void createRVMListener(ActionListener e)
    {
        createRVM.addActionListener(e);
    }

    public void createSVMListener(ActionListener e)
    {
        createSVM.addActionListener(e);
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

    public JFrame getVMstart()
    {
        return vmStart;
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

    public void clearTA()
    {
        startOutput.setText("");
    }
}
