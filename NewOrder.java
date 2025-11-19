package labproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;

public class NewOrder extends JFrame {
    // GUI components
    private JPanel mPanel;
    private JTextField srtxtf, wbtxtf, hctxtf, bsrtxtf, bbtxtf, chctxtf, bmtxtf, cctxtf, clcokitxtf, chmtxtf, chcrtxtf, brcokitxtf;
    private int total = 0;
    private int orderID = 1;
    private String orderedItems;
    private String dateOrdered;

    public NewOrder() {
        initializeOrderID();
        setTitle("Bakery Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        buildPanel();
        
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(new Color(0x590E0E));
        confirmButton.setForeground(new Color(0xEDE4D8));
        confirmButton.addActionListener(new CalculateListener());

        JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        confirmPanel.add(confirmButton);
        confirmPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 20));
        confirmPanel.setBackground(new Color(0x333333));

        add(mPanel, BorderLayout.CENTER);
        add(confirmPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void buildPanel() {
        mPanel = new JPanel(new GridLayout(4, 3));
        mPanel.setBackground(new Color(0x333333));

        addItemPanel("Sourdough", "5 sr", "Sourdough.JPG", srtxtf = new JTextField(5));
        addItemPanel("White Bread", "3 sr", "WhiteBread.JPG", wbtxtf = new JTextField(5));
        addItemPanel("Honey Cake", "8 sr", "HoneyCake.JPG", hctxtf = new JTextField(5));
        addItemPanel("Black Sourdough", "7 sr", "BlackSourdough.JPG", bsrtxtf = new JTextField(5));
        addItemPanel("Brown Bread", "4 sr", "BrownBread.JPG", bbtxtf = new JTextField(5));
        addItemPanel("Chocolate Cake", "10 sr", "ChoclateCake.JPG", chctxtf = new JTextField(5));
        addItemPanel("Blueberry Muffin", "5 sr", "BBMuffin.JPG", bmtxtf = new JTextField(5));
        addItemPanel("Classic Croissant", "6 sr", "CCroissant.JPG", cctxtf = new JTextField(5));
        addItemPanel("Classic Cookie", "3 sr", "ClCookies.JPG", clcokitxtf = new JTextField(5));
        addItemPanel("Chocolate Muffin", "5 sr", "ChMuffin.JPG", chmtxtf = new JTextField(5));
        addItemPanel("Chocolate Croissant", "6 sr", "ChCroissants.JPG", chcrtxtf = new JTextField(5));
        addItemPanel("Brownie Cookie", "6 sr", "BrCookies.JPG", brcokitxtf = new JTextField(5));
        
        
    }

    private void addItemPanel(String itemName, String price, String imagePath, JTextField textField) {
        JPanel itemPanel = new JPanel(new GridLayout(1, 2));
        JPanel textPanel = new JPanel(new GridLayout(3, 1));
        JLabel nameLabel = new JLabel(itemName);
        JLabel priceLabel = new JLabel(price);

        itemPanel.setBackground(new Color(0x333333));
        textPanel.setBackground(new Color(0x333333));
        nameLabel.setForeground(new Color(0xEDE4D8));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 18));
        priceLabel.setForeground(new Color(0xEDE4D8));
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        
        textPanel.add(nameLabel);
        textPanel.add(priceLabel);
        textField.setBackground(new Color(0xEDE4D8));
        textField.setForeground(new Color(0x333333));
        textPanel.add(textField);

        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel photoLabel = new JLabel(new ImageIcon(img));

        itemPanel.add(textPanel);
        itemPanel.add(photoLabel);
        itemPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
        
        mPanel.add(itemPanel);
    }
    private void initializeOrderID() {
    try (RandomAccessFile orderIDFile = new RandomAccessFile("OrderID.dat", "rw")) {
        if (orderIDFile.length() > 0) {
            orderIDFile.seek(orderIDFile.length() - 4); // Move to the last int position
            orderID = orderIDFile.readInt() + 1; // Set orderID to last ID + 1
        } else {
            orderID = 1; // Start from 1 if file is empty
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error initializing Order ID: " + e.getMessage());
        e.printStackTrace();
    }
}


    // Helper function for processing and totaling order
    private int addItemToOrder(ArrayList<String> items, int quantity, String itemName, int pricePerUnit) {
        items.add(quantity + "-" + itemName);
        return quantity * pricePerUnit;
    }

    // Method to process the order
    public void processOrder() {
        ArrayList<String> items = new ArrayList<>();
        Date date = new Date();
        total = 0;

        try {
            // Add each item if quantity is specified
            if (!srtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(srtxtf.getText()), "Sourdough", 5);
            if (!wbtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(wbtxtf.getText()), "White Bread", 3);
            if (!hctxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(hctxtf.getText()), "Honey Cake", 8);
            if (!bsrtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(bsrtxtf.getText()), "Black Sourdough", 7);
            if (!bbtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(bbtxtf.getText()), "Brown Bread", 4);
            if (!chctxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(chctxtf.getText()), "Chocolate Cake", 10);
            if (!bmtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(bmtxtf.getText()), "Blueberry Muffin", 5);
            if (!cctxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(cctxtf.getText()), "Classic Croissant", 6);
            if (!clcokitxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(clcokitxtf.getText()), "Classic Cookie", 3);
            if (!chmtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(chmtxtf.getText()), "Chocolate Muffin", 5);
            if (!chcrtxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(chcrtxtf.getText()), "Chocolate Croissant", 6);
            if (!brcokitxtf.getText().isEmpty()) total += addItemToOrder(items, Integer.parseInt(brcokitxtf.getText()), "Brownie Cookie", 6);

            orderedItems = items.toString();
            dateOrdered = date.toString();

            // Save data
            writeOrderData();

            // Show order receipt
            new OrderReciept(orderID, orderedItems, dateOrdered, total);

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error processing order: " + e.getMessage()+"\nPlease enter the order correctly");
            e.printStackTrace();
        }
    }

    // Writes order data to files
    private void writeOrderData() throws IOException {
        try (
             RandomAccessFile orderIDFile = new RandomAccessFile("OrderID.dat", "rw");
             RandomAccessFile orderItemsFile = new RandomAccessFile("OrderItems.dat", "rw");
             RandomAccessFile dateFile = new RandomAccessFile("date.dat", "rw");
             RandomAccessFile totalFile = new RandomAccessFile("totalAmount.dat", "rw")) {

            orderIDFile.seek(orderIDFile.length());
            orderIDFile.writeInt(orderID);

            orderItemsFile.seek(orderItemsFile.length());
            orderItemsFile.writeUTF(orderedItems);

            dateFile.seek(dateFile.length());
            dateFile.writeUTF(dateOrdered);

            totalFile.seek(totalFile.length());
            totalFile.writeInt(total);
            
           
        }
    }

    // Listener class to trigger processOrder on button click
    private class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
            processOrder();
        }
    }
}
