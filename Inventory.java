package labproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;

public class Inventory extends JFrame {

    private final JPanel titlePanel, buttonsPanel, defaultPanel1, defaultPanel2;
    private final JLabel titleLabel;
    private final JTable inventoryTable;
    private final JTableHeader inventoryTableHeader ;
    private final JScrollPane inventoryTablScrollPane;
    private final JButton  showLowStockButton;
    private final String[] columnNames = {"ID", "Item Name", "Quantity", "Expiration Date", "Supplier"};
    private final Object[][] data = new Object[20][5];

    public Inventory() {
        
        setTitle("Inventory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 360);

        setLayout(new BorderLayout());
        
        // Initialize Panels
        titlePanel = new JPanel();
        buttonsPanel = new JPanel(new FlowLayout());
        defaultPanel1 = new JPanel();
        defaultPanel2 = new JPanel();
        
        // Initialize Labels
        titleLabel = new JLabel("Inventory");
        
        // Initialize Table
        inventoryTable = new JTable(data, columnNames);
        
        //Initialize Table Header
        inventoryTableHeader = inventoryTable.getTableHeader();
        
        //Initialize Table Scroll Pane
        inventoryTablScrollPane = new JScrollPane(inventoryTable);
        
        // Initialize Buttons
        showLowStockButton = new JButton("Show Low Stock Item");

    try(RandomAccessFile itemNameFile = new RandomAccessFile ("InventoryitemName.dat","r"); 
        RandomAccessFile supplierFile = new RandomAccessFile ("Inventorysupplier.dat","r");
        RandomAccessFile exDateFile = new RandomAccessFile ("InventoryexDate.dat","r");
        RandomAccessFile quantityFile = new RandomAccessFile ("Inventoryquantity.dat","r")){
        
            //Filling Data array
            for (int i = 0; i < 20; i++) {
                
                // Filling 1st(ID)column and 2nd(Item Name)column
                try {
                    data[i][1] = itemNameFile.readUTF();  //set (Item Name)column value
                    data[i][0] = "#" + (i+1);  //set (ID)column value
                } catch (IOException ex) {
                    data[i][1] = "";  // If an error occurs, set an empty value in (Item Name)column
                    data[i][0] = "";  // If an error occurs, set an empty value in (ID)column
                }
                
                // Filling 3rd column (Supplier)
                try {
                    data[i][2] = quantityFile.readUTF();
                } catch (IOException ex) {
                    data[i][2] = "";  // If an error occurs, set an empty value
                }
                
                // Filling 4th column (Expiration Date)
                try {
                    data[i][3] = exDateFile.readUTF();
                } catch (IOException ex) {
                    data[i][3] = "";  // If an error occurs, set an empty value
                }
                
                // Filling 5th column (Quantity)
                try {
                    data[i][4] = supplierFile.readUTF();
                } catch (IOException ex) {
                    data[i][4] = "";  // If an error occurs, set an empty value
                }
            }

        // set Table color
        inventoryTable.setBackground(new Color(0x590E0E));
        inventoryTable.setForeground(new Color(0xEDE4D8));
        inventoryTable.setRowHeight(25);
        inventoryTable.setGridColor(new Color(0xEDE4D8));
        
        //set Table Header color
        inventoryTableHeader.setBackground(new Color(0x590E0E));
        inventoryTableHeader.setForeground(new Color(0xEDE4D8));
        inventoryTableHeader.setFont(new Font("serif", Font.BOLD, 13));

        // Add Label to Title Panel
        titlePanel.add(titleLabel);

        // Add Buttons to Buttons Panel
        buttonsPanel.add(showLowStockButton);

        // Add Panels to the Content Pane
        add(titlePanel, BorderLayout.NORTH);
        add(inventoryTablScrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        add(defaultPanel1, BorderLayout.EAST);
        add(defaultPanel2, BorderLayout.WEST);

        // Set colors
        titlePanel.setBackground(new Color(0x333333));
        buttonsPanel.setBackground(new Color(0x333333));
        defaultPanel1.setBackground(new Color(0x333333));
        defaultPanel2.setBackground(new Color(0x333333));

//        enterInventoryButton.setBackground(new Color(0x590E0E));
        showLowStockButton.setBackground(new Color(0x590E0E));

        titleLabel.setFont(new Font("serif", Font.BOLD, 22));
        titleLabel.setForeground(new Color(0xEDE4D8));

//        enterInventoryButton.setForeground(new Color(0xEDE4D8));
        showLowStockButton.setForeground(new Color(0xEDE4D8));
        
        inventoryTablScrollPane.setBackground(new Color(0x590E0E));
        
        //add actio listener to the buttons
        showLowStockButton.addActionListener(new showLowStockActionListener());
        

        setLocationRelativeTo(null);
        setVisible(true);
        
}catch (FileNotFoundException e) {
            System.out.println("Error: One or more data files not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    

    
    private class showLowStockActionListener implements ActionListener {
        
         public void actionPerformed(ActionEvent e){
             try {
                 new LowStock();
             } catch (IOException ex) {
                 Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
        
    }

    
}

