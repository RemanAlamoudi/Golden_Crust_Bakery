
package labproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class enterItem extends JFrame {

    private final JPanel titlePanel, infoPanel, allinfoPanel, quantityRadioButtonPanel,allquantityRadioButtonPanel, exDatePanel,
            exDateTFPanel,exDateTXPanel, itemNamePanel,supplierPanel,buttonsPanel, infoItemSupplierPanel, infoQuantityExDatePanel;
    private final JLabel titleLabel, itemNameLabel, supplierLabel, exDateLabel, quantityLabel;
    private final JTextField itemNameTextField, exDateTextField;
    private final JButton confirmButton, inventoryButton;
    private final JRadioButton halfDozenRadioButton, dozenRadioButton, twoDozenRadioButton;
    private final  JComboBox supplierComboBox;
    public RandomAccessFile itemNameFile, supplierFile, exDateFile, quantityFile;

    public enterItem() throws FileNotFoundException {
        itemNameFile = new RandomAccessFile ("InventoryitemName.dat","rw");
        supplierFile = new RandomAccessFile ("Inventorysupplier.dat","rw");
        exDateFile = new RandomAccessFile ("InventoryexDate.dat","rw");
        quantityFile = new RandomAccessFile ("Inventoryquantity.dat","rw");

        setTitle("Enter Inventory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 350);

        setLayout(new BorderLayout());

        // Initialize Panels
        titlePanel = new JPanel();
        infoPanel = new JPanel(new GridLayout(2, 1));
        allinfoPanel= new JPanel();
        buttonsPanel = new JPanel();
        infoItemSupplierPanel = new JPanel(new BorderLayout());
        infoQuantityExDatePanel = new JPanel(new FlowLayout());
        quantityRadioButtonPanel = new JPanel(new GridLayout(4, 1));
        allquantityRadioButtonPanel = new JPanel();
        exDatePanel = new JPanel(new BorderLayout());
        exDateTFPanel= new JPanel();
        exDateTXPanel= new JPanel();
        itemNamePanel = new JPanel();
        supplierPanel = new JPanel();
        
        // Initialize Labels
        titleLabel = new JLabel("Enter Item");
        itemNameLabel = new JLabel("Item Name");
        supplierLabel = new JLabel("Supplier");
        exDateLabel = new JLabel("Expiration Date");
        quantityLabel = new JLabel("Quantity");

        // Initialize Text Fields
        itemNameTextField = new JTextField(20);
        supplierComboBox = new JComboBox<>(new String[] {"Panda", "Danube", "Bindawood"});
        supplierComboBox.setBackground(new Color(139, 0, 0)); // Dark red background
        supplierComboBox.setForeground(Color.WHITE); // Optional: set text color for contrast
        supplierPanel.add(supplierComboBox); // Add combo box to the panel
        exDateTextField = new JTextField(20);

        // Initialize Buttons
        confirmButton = new JButton("Confirm");
        inventoryButton = new JButton("Inventory");

        // Initialize Radio Buttons
        halfDozenRadioButton = new JRadioButton("Half a Dozen");
        dozenRadioButton = new JRadioButton("Dozen");
        twoDozenRadioButton = new JRadioButton("Two Dozen");

        // Initialize Button Group
        ButtonGroup quantityGroup = new ButtonGroup();
        quantityGroup.add(halfDozenRadioButton);
        quantityGroup.add(dozenRadioButton);
        quantityGroup.add(twoDozenRadioButton);

        // Add title to "titlePanel"
        titlePanel.add(titleLabel);
        
        //add item name and text feld to "itemPanel"
        itemNamePanel.add(itemNameLabel);
        itemNamePanel.add(itemNameTextField);
        
        //add supplier and text feld to "supplierPanel"
        supplierPanel.add(supplierLabel);
        supplierPanel.add(supplierComboBox);

        // Add Item Name and Supplier Text Fields to "infoItemSupplierPanel"
        infoItemSupplierPanel.add(itemNamePanel, BorderLayout.NORTH);
        infoItemSupplierPanel.add(supplierPanel, BorderLayout.CENTER);

        // Add "quantityLabel" and quantity options to "quantityRadioButtonPanel"
        quantityRadioButtonPanel.add(quantityLabel);
        quantityRadioButtonPanel.add(halfDozenRadioButton);
        quantityRadioButtonPanel.add(dozenRadioButton);
        quantityRadioButtonPanel.add(twoDozenRadioButton);
        allquantityRadioButtonPanel.add(quantityRadioButtonPanel);
        
        // Add "exDateLabel" and "exDateTextField" to "exDatePanel"
        exDateTXPanel.add(exDateLabel);
        exDatePanel.add(exDateTXPanel, BorderLayout.NORTH);
        exDateTFPanel.add(exDateTextField);
        exDatePanel.add(exDateTFPanel, BorderLayout.CENTER);

        // Add Quantity Radio Buttons and Expiration Date to "infoQuantityExDatePanel"
        infoQuantityExDatePanel.setLayout(new BorderLayout());
        infoQuantityExDatePanel.add(allquantityRadioButtonPanel ,BorderLayout.WEST);
        infoQuantityExDatePanel.add(exDatePanel,BorderLayout.CENTER);

        // Add Item Name, Supplier, Quantity, Expiration Date Panels to "infoPanel"
        infoPanel.add(infoItemSupplierPanel);
        infoPanel.add(infoQuantityExDatePanel);
        allinfoPanel.add(infoPanel);

        // Add the buttons to "buttonsPanel"
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(inventoryButton);

        // Add the main panels to the content pane
        add(titlePanel, BorderLayout.NORTH);
        add(allinfoPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        
        //set title color 
        titlePanel.setBackground(new Color(0x333333));
        titleLabel.setFont(new Font("serif",Font.BOLD,22));
        titleLabel.setForeground(new Color(0xEDE4D8));
        titleLabel.setBackground(new Color(0x333333));
        
        
        //set item Name color 
        itemNamePanel.setBackground(new Color(0x333333));
        itemNameLabel.setForeground(new Color(0xEDE4D8));
        itemNameTextField.setBackground(new Color(0x590E0E));
        itemNameTextField.setForeground(new Color(0xEDE4D8));
        
        //set supplier color 
        supplierPanel.setBackground(new Color(0x333333));
        supplierLabel.setForeground(new Color(0xEDE4D8));
        supplierComboBox.setBackground(new Color(0x590E0E));
        supplierComboBox.setForeground(new Color(0xEDE4D8));
                
        //set info Panel color
        infoPanel.setBackground(new Color(0x333333));
        allinfoPanel.setBackground(new Color(0x333333));
        allquantityRadioButtonPanel.setBackground(new Color(0x333333));
        
        //set quantity color
        quantityRadioButtonPanel.setBackground(new Color(0x333333));
        quantityLabel.setBackground(new Color(0x333333));
        quantityLabel.setForeground(new Color(0xEDE4D8));
        halfDozenRadioButton.setBackground(new Color(0x333333));
        halfDozenRadioButton.setForeground(new Color(0xEDE4D8));
        dozenRadioButton.setBackground(new Color(0x333333));
        dozenRadioButton.setForeground(new Color(0xEDE4D8));
        twoDozenRadioButton.setBackground(new Color(0x333333));
        twoDozenRadioButton.setForeground(new Color(0xEDE4D8));
        
        //set expiration Date color
        exDatePanel.setBackground(new Color(0x333333));
        exDateTFPanel.setBackground(new Color(0x333333));
        exDateTXPanel.setBackground(new Color(0x333333));
        exDateLabel.setForeground(new Color(0xEDE4D8));
        exDateTextField.setBackground(new Color(0x590E0E));
        exDateTextField.setForeground(new Color(0xEDE4D8));
        
        //set button color
        buttonsPanel.setBackground(new Color(0x333333));
        confirmButton.setBackground(new Color(0x590E0E));
        confirmButton.setForeground(new Color(0xEDE4D8));
        inventoryButton.setBackground(new Color(0x590E0E));
        inventoryButton.setForeground(new Color(0xEDE4D8));

        
        //add action Listener
        confirmButton.addActionListener(new confirmButtonActionListener());
        inventoryButton.addActionListener(new inventoryButtonActionListener());

        
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    private class confirmButtonActionListener implements ActionListener {
        
         @Override
         public void actionPerformed(ActionEvent e){
            String itemName = itemNameTextField.getText();
            String supplier = supplierComboBox.getSelectedItem().toString();
            String exDate = exDateTextField.getText();
            String quantity = "";

            if (halfDozenRadioButton.isSelected()) quantity = "Half a Dozen";
            else if (dozenRadioButton.isSelected()) quantity = "Dozen";
            else if (twoDozenRadioButton.isSelected()) quantity = "Two Dozen";
                
            try {
            // Move the file pointer to the end of the files to append
            itemNameFile.seek(itemNameFile.length());
            supplierFile.seek(supplierFile.length());
            exDateFile.seek(exDateFile.length());
            quantityFile.seek(quantityFile.length());

            // Write the new data at the end of the files
            itemNameFile.writeUTF(itemName);   // Write item name
            supplierFile.writeUTF(supplier);   // Write supplier
            exDateFile.writeUTF(exDate);       // Write expiration date
            quantityFile.writeUTF(quantity);   // Write quantity

            // Close the files
            itemNameFile.close();
            supplierFile.close();
            exDateFile.close();
            quantityFile.close();

        } catch (IOException ioException) {
            System.out.println("Error writing to files!!");
            ioException.printStackTrace();
        }
                
            dispose();
                
            }
        
    }
    
    private class inventoryButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            // Instantiate the Inventory class
            new Inventory();
            } catch (Exception exception) {
            exception.printStackTrace();
            }
        }
    }


   
}

