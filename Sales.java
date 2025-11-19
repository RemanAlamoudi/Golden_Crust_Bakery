package labproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sales extends JFrame {

    JLabel bigL;
    JPanel tablePanel;
    JButton showBs;
    JPanel bPanel;
   
    DefaultTableModel tableModel;
    JPanel em1Panel = new JPanel();
    JPanel em2Panel = new JPanel();
    JPanel topPanel ;
     
    final ImageIcon m = new ImageIcon("icons8-sales-32 (1).png");
    final String orderIDPath = "OrderID.dat";
    final String orderItemsPath = "OrderItems.dat";
    final String datePath = "date.dat";
    final String totalAmountPath = "totalAmount.dat";

    String[] columnNames = {"Order Number", "Items", "Date", "Total"};
    
    String[] menuItems = {"Sourdough", "Black Sourdough", "Blueberry Muffin", "Chocolate Muffin", 
                          "White Bread", "Brown Bread", "Classic Croissant", "Chocolate Croissant", 
                          "Honey Cake", "Chocolate Cake", "Classic Cookie", "Brownie Cookie"};
    
    int[] itemCounters = new int[menuItems.length];
    JTable salesTable;
    

    public Sales() {
        setTitle("Bakery Management System");
        setSize(1300, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(0,0));
        setLocationRelativeTo(null);
        

        bigL = new JLabel("Sales");
        bigL.setFont(new Font("Serif", Font.BOLD, 21));
        bigL.setIcon(m);
        bigL.setForeground(new Color(0xEDE4D8));

        showBs = new JButton("Show Bestsellers");
        showBs.setBackground(new Color(0x590E0E));
        showBs.setForeground(new Color(0xEDE4D8));
        
    //--------------------------------------------------------------------------    
        
        showBs.addActionListener(new ActionListener() {
    @Override
        public void actionPerformed(ActionEvent e) {
        new BestSelller(getTopSellingItems());
    }
});

    //--------------------------------------------------------------------------
        
        tableModel = new DefaultTableModel(columnNames, 0);
        salesTable = new JTable(tableModel);
        

        JScrollPane scl = new JScrollPane(salesTable);
        tablePanel = new JPanel(new BorderLayout());
        
        scl.setBorder(null);
        tablePanel.add(scl);

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(bigL);
        bPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bPanel.add(showBs);

        bPanel.add(showBs);  
        topPanel.add(bigL);
       
    //--------------------------------------------------------------------------
        
        salesTable.setFillsViewportHeight(true);
        salesTable.setBackground(new Color(0x333333));
        salesTable.setForeground(new Color(0xEDE4D8));
        salesTable.setGridColor(new Color(0xEDE4D8));
        
        tablePanel.setBackground(new Color(0x333333));
        em1Panel.setBackground(new Color(0x333333));
        em2Panel.setBackground(new Color(0x333333));
        bPanel.setBackground(new Color(0x333333));
        topPanel.setBackground(new Color(0x333333));

        JTableHeader tableHeader = salesTable.getTableHeader();
        tableHeader.setForeground(new Color(0xEDE4D8));
        tableHeader.setBackground(new Color(0x590E0E));
        tableHeader.setFont(new Font("Serif", Font.BOLD, 14));
        
        scl.setBorder(BorderFactory.createEmptyBorder());
                       
    //-------------------------------------------------------------------------       
        add(tablePanel, BorderLayout.CENTER);
        add(bPanel, BorderLayout.SOUTH);
        add(em1Panel, BorderLayout.EAST);
        add(em2Panel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        
        setVisible(true);
        
        loadFromFiles();
    }


private void loadFromFiles() {
    try (RandomAccessFile orderIDFile = new RandomAccessFile(orderIDPath, "r");
         RandomAccessFile itemsFile = new RandomAccessFile(orderItemsPath, "r");
         RandomAccessFile dateFile = new RandomAccessFile(datePath, "r");
         RandomAccessFile totalFile = new RandomAccessFile(totalAmountPath, "r")) {

        tableModel.setRowCount(0);  

        while (true) {
            try {
                int orderID = orderIDFile.readInt();
                String items = itemsFile.readUTF();
                String date = dateFile.readUTF();
                int total = totalFile.readInt();

                processItems(items);  
                              
                tableModel.addRow(new Object[]{orderID, items.replace(",", "\n"), date, total});
            } catch (EOFException e) {
                break;
            }
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Please enter orders first");

    }
}


private void processItems(String items) {
    
    items = items.replaceAll("[\\[\\]]", "");

    for (String item : items.split(",")) {
        String[] parts = item.trim().split("-", 2);
        if (parts.length == 2) {
            try {
                
                int quantity = Integer.parseInt(parts[0].trim().replaceAll("[^\\d]", ""));
                String itemName = parts[1].trim();

                for (int i = 0; i < menuItems.length; i++) {
                    if (itemName.equalsIgnoreCase(menuItems[i])) {
                        itemCounters[i] += quantity;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing quantity for item: " + item);
            }
        }
    }
}


public List<String> getTopSellingItems() {
    
    List<String> topSellers = new ArrayList<>();
    
    for (int i = 0; i < menuItems.length; i++) {
        topSellers.add(menuItems[i] + " - Sold: " + itemCounters[i]);
    }
    
    topSellers.sort(new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return Integer.parseInt(b.split(": ")[1]) - Integer.parseInt(a.split(": ")[1]);
    }
});

    return topSellers.size() > 4 ? topSellers.subList(0, 4) : topSellers;
}

    
}
