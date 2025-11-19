package labproject;

import javax.swing.*;
import java.awt.*;

class OrderReciept extends JFrame {

    JPanel titlePanel;
    JLabel titleLabel;
    JPanel content;
    JLabel orderNumber;
    JLabel orderNumberOutput;
    JLabel orderItems;
    JTextArea orderItemsOutput ;
    JLabel date;
    JLabel dateOutput;
    JLabel totalAmount;
    JLabel totalAmountOutput;

    // Modified constructor to accept order details
    OrderReciept(int orderID, String itemsOrdered, String dateOrdered, int total) {

        setTitle("Bakery Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        
        // Initialize labels with the passed-in information
        orderNumberOutput = new JLabel(String.valueOf(orderID));
        orderItemsOutput = new JTextArea(itemsOrdered);
        dateOutput = new JLabel(dateOrdered);
        totalAmountOutput = new JLabel(total + " SR");

        buildPanel();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void buildPanel() {
        
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new JLabel("Order Reciept");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        titleLabel.setForeground(new Color(0xEDE4D8));
        titlePanel.add(titleLabel);
        titlePanel.setBackground(new Color(0x333333));
        add(titlePanel, BorderLayout.NORTH);
        
        content = new JPanel(new GridLayout(4,2));
        
        orderNumber = new JLabel("  Order Number:  ");
        orderNumber.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E),3)); 
        JPanel orderexP = new JPanel();
        orderexP.add(orderNumber);
        orderexP.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        orderexP.setBackground(new Color(0x333333));
        content.add(orderexP);
        content.add(orderNumberOutput);
        orderNumber.setForeground(new Color(0xEDE4D8));
        orderNumber.setFont(new Font("Sans", Font.BOLD, 14));
        orderNumberOutput.setForeground(new Color(0xEDE4D8));
        
        
        orderItems= new JLabel("    Order Items:    ");
        orderItems.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E),3)); 
        JPanel itemexP = new JPanel();
        itemexP.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        itemexP.add(orderItems);
        itemexP.setBackground(new Color(0x333333));
        content.add(itemexP);
        orderItemsOutput.setLineWrap(true);         
        orderItemsOutput.setWrapStyleWord(true);     
        orderItemsOutput.setEditable(false);          
        orderItemsOutput.setOpaque(false);            
        orderItemsOutput.setBorder(null);             

        content.add(orderItemsOutput);
        orderItems.setForeground(new Color(0xEDE4D8));
        orderItems.setFont(new Font("Sans", Font.BOLD, 14));
        orderItemsOutput.setForeground(new Color(0xEDE4D8));

        date = new JLabel ("          Date:          ");
        date.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E),4)); 
        JPanel dateexP = new JPanel();
        dateexP.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        dateexP.add(date);
        dateexP.setBackground(new Color(0x333333));
        content.add(dateexP);
//        dateOutput= new JLabel(dateOrdered);
        content.add(dateOutput);
        date.setForeground(new Color(0xEDE4D8));
        date.setFont(new Font("Sans", Font.BOLD, 14));
        dateOutput.setForeground(new Color(0xEDE4D8));

        totalAmount= new JLabel("   Total Amount:  ");
        totalAmount.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E),4)); 
        JPanel taexP = new JPanel();
        taexP.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        taexP.add(totalAmount);
        taexP.setBackground(new Color(0x333333));
        content.add(taexP);
        content.add(totalAmountOutput);
        totalAmount.setForeground(new Color(0xEDE4D8));
        totalAmount.setFont(new Font("Sans", Font.BOLD, 14));
        totalAmountOutput.setForeground(new Color(0xEDE4D8));
        
        content.setBackground(new Color(0x333333));
        add(content, BorderLayout.CENTER);
        
        

    }
}
