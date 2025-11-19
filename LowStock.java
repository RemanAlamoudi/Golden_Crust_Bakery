package labproject;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.table.JTableHeader;

public class LowStock extends JFrame {

    private final JPanel titlePanel, defaultPanel1, defaultPanel2, defaultPanel3;
    private final JLabel titleLabel;
    private final JTable lowStockTable;
    private final JScrollPane lowStockTablScrollPane;
    private final JTableHeader lowStockTableHeader ;
    private final String[] columnNames = {"Item Name", "Quantity"};
    private final Object[][] data = new Object[10][2];

    public LowStock() throws FileNotFoundException, IOException {
        
        setTitle("Low Stock Inventory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 360);

        setLayout(new BorderLayout());

        // Initialize Panels
        titlePanel = new JPanel();
        defaultPanel1 = new JPanel();
        defaultPanel2 = new JPanel();
        defaultPanel3 = new JPanel();

        // Initialize Label
        titleLabel = new JLabel("Low Stock - Please Order Soon!!");
        
        // Initialize Table
        lowStockTable = new JTable(data, columnNames);
        
        //Initialize Table Header
        lowStockTableHeader = lowStockTable.getTableHeader();
        
        //Initialize Table Scroll Pane
        lowStockTablScrollPane = new JScrollPane(lowStockTable);
        
        // Read data from files
        try (RandomAccessFile itemNameFile = new RandomAccessFile("InventoryitemName.dat", "r");
             RandomAccessFile quantityFile = new RandomAccessFile("Inventoryquantity.dat", "r")) {

            //Filling Data array
            int RowIndex = 0 ;
            
            while (RowIndex < 10 
                   && itemNameFile.getFilePointer() < itemNameFile.length() 
                   && quantityFile.getFilePointer() < quantityFile.length()) 
            {
                
                String itemName = itemNameFile.readUTF();
                String quantity = quantityFile.readUTF();

                // Only add items with "Half a Dozen" quantity
                if ("Half a Dozen".equalsIgnoreCase(quantity)) {
                    data[RowIndex][0] = itemName;
                    data[RowIndex][1] = quantity;
                    RowIndex++;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found");
        } catch (IOException ex) {
            System.out.println("Error: In Input/Output File");
        }
        
        // set Table color
        lowStockTable.setBackground(new Color(0x590E0E));
        lowStockTable.setForeground(new Color(0xEDE4D8));
        lowStockTable.setRowHeight(25);
        
        //set Table Header color
        lowStockTableHeader.setBackground(new Color(0x590E0E));
        lowStockTableHeader.setForeground(new Color(0xEDE4D8));
        lowStockTableHeader.setFont(new Font("serif", Font.BOLD, 13));
        

        // Add Label to Title Panel
        titlePanel.add(titleLabel);

        // Add Table to JScrollPane and center it
        add(lowStockTablScrollPane, BorderLayout.CENTER);

        // Add Panels to the Content Pane
        add(titlePanel, BorderLayout.NORTH);
        add(defaultPanel1, BorderLayout.EAST);
        add(defaultPanel2, BorderLayout.WEST);
        add(defaultPanel3, BorderLayout.SOUTH);

        // Set colors
        titlePanel.setBackground(new Color(0x333333));
        titleLabel.setFont(new Font("serif", Font.BOLD, 22));
        titleLabel.setForeground(new Color(0xEDE4D8));

        defaultPanel1.setBackground(new Color(0x333333));
        defaultPanel2.setBackground(new Color(0x333333));
        defaultPanel3.setBackground(new Color(0x333333));
        
        lowStockTablScrollPane.setBackground(new Color(0x590E0E));

        setLocationRelativeTo(null);
        setVisible(true);
    }

   
}
