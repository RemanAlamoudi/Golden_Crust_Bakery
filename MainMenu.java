
package labproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class MainMenu extends JFrame{

    JPanel mainPanel;
    JPanel orderPanel;
    JLabel logophoto;
    JPanel inventoryPanel;
    JPanel labelPanel;
    JPanel salesPanel;  
    JPanel emptyPanel1;
    JPanel emptyPanel2;
    JPanel emptyPanel3;
    JLabel mLabel;
    JButton orderButton;
    JButton inventoryButton;
    JButton enterInventoryButton;
    JButton salesButton;
    
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenuItem exitItem;
    JMenuItem reportItem;
    JCheckBoxMenuItem logoItem;
    ImageIcon logopic;
    Image logoImage;
    ImageIcon logoscaledIcon;
    
    public MainMenu(){
        setTitle("Bakery Managment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,440);
        setLayout(new BorderLayout());
        buildPanel();
        buildMenu();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void buildPanel(){
        
        
        labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logopic = new ImageIcon("Logo.JPG");
        logoImage = logopic.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        logoscaledIcon = new ImageIcon(logoImage);
        logophoto = new JLabel(logoscaledIcon);
       
        logophoto.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelPanel.add(logophoto);
        labelPanel.setBackground(new Color(0x333333));
        add(labelPanel , BorderLayout.NORTH);
        
        mainPanel= new JPanel(new GridLayout(4,1));
        
        

        
        orderButton = new JButton("     New Order     ");
        orderButton.setForeground(new Color(0xEDE4D8));
        orderButton.setBackground(new Color(0x590E0E));
        orderPanel = new JPanel();
        orderPanel.add(orderButton);
        orderPanel.setBackground(new Color(0x333333));
        orderButton.addActionListener(new OrderListener());
        
        mainPanel.add(orderPanel);
        
        inventoryButton = new JButton(" Enter Inventroy ");
        inventoryButton.setForeground(new Color(0xEDE4D8));
        inventoryButton.setBackground(new Color(0x590E0E));
        inventoryPanel = new JPanel();
        inventoryPanel.add(inventoryButton);
        inventoryPanel.setBackground(new Color(0x333333));
        mainPanel.add(inventoryPanel);
        inventoryButton.addActionListener(new InventoryListener());
        
        salesButton = new JButton("         Sales          ");
        salesButton.setForeground(new Color(0xEDE4D8));
        salesButton.setBackground(new Color(0x590E0E));
        salesPanel = new JPanel();
        salesPanel.add(salesButton);
        salesPanel.setBackground(new Color(0x333333));
        mainPanel.add(salesPanel);
        salesButton.addActionListener( new SalesListener() );
        
        emptyPanel2 = new JPanel();
        emptyPanel2.setBackground(new Color(0x333333));
        mainPanel.add(emptyPanel2); 
        mainPanel.setBackground(new Color(0x333333));
    
        add(mainPanel, BorderLayout.CENTER);
    }
    
    
    private void buildMenu(){
        menuBar = new JMenuBar();
        
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitListener());
        
        reportItem = new JMenuItem("Report Problem");
        reportItem.setMnemonic(KeyEvent.VK_R);
        reportItem.addActionListener(new ReportListener());
        
        fileMenu = new JMenu("File");
        fileMenu.add(exitItem);
        fileMenu.addSeparator();
        fileMenu.add(reportItem);
        menuBar.add(fileMenu);
        
        logoItem = new JCheckBoxMenuItem("Logo", true);
        logoItem.setMnemonic(KeyEvent.VK_L);
        logoItem.addActionListener(new logoListener());
        
        editMenu = new JMenu("Edit");
        editMenu.add(logoItem);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);        
        
        
    }
     private class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           System.exit(0);
        }
    }
    
     private class ReportListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           JOptionPane.showMessageDialog(null, "Contact:\nGCDContact@gmail.com");
        }
    }
     
     private class logoListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            if(!logoItem.isSelected()){
            logophoto.setText("Golden Crust Bakery");
            logophoto.setForeground(new Color(0xEDE4D8));
            logophoto.setFont(new Font("Serif", Font.BOLD, 26)); 
            logophoto.setIcon(null);
            logophoto.setPreferredSize(new Dimension(400, 225));
            
            

            System.out.println("might");
            }
            else {
                logophoto.setText(null);
                logophoto.setIcon(logoscaledIcon);
            }
            
            logophoto.revalidate();
            logophoto.repaint();
        }
    }
    
    private class OrderListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
             new NewOrder();
        }
    }
    
    private class SalesListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new Sales();
        }
    }
    private class InventoryListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
             try{
                 new enterItem();
             }
             catch(FileNotFoundException c){
                 JOptionPane.showMessageDialog(null, "The file was not found");
             }
        }
    }
    
    
    public static void main(String[] args) {
        new MainMenu();
        
    }
    
}

 

