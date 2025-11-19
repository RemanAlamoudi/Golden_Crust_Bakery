package labproject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BestSelller extends JFrame {

    JPanel tablePanel;
    JPanel tPanel;
    JPanel c1Panel;
    JPanel c2Panel;
    JPanel c3Panel;
    JPanel rp;
    JPanel sp;
    JPanel np;
    JPanel em1Panel = new JPanel();
    JPanel em2Panel = new JPanel();
    JPanel em3Panel = new JPanel();
    
    JLabel rl = new JLabel("Rank");
    JLabel nl = new JLabel("Item Name");
    JLabel sl = new JLabel("Sold");
    JLabel bigL = new JLabel("Best Sellers ");
    
    final ImageIcon m0 = new ImageIcon("icons8-bestsales-33.png");

    
    public BestSelller(List<String> topSellers) {

        setSize(450, 500);
        setTitle("Bakery Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(new Color(0x333333));
        setLocationRelativeTo(null);
        

        c1Panel = new JPanel(new GridLayout(5, 1));
        c2Panel = new JPanel(new GridLayout(5, 1));
        c3Panel = new JPanel(new GridLayout(5, 1));
        rp = new JPanel();
        sp = new JPanel();
        np = new JPanel();
        tPanel = new JPanel();
        tablePanel = new JPanel(new GridLayout(1, 3, 5, 10));
        
     //-------------------------------------------------------------------------

        c1Panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));
        c2Panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));
        c3Panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));

        rp.setLayout(new FlowLayout(FlowLayout.LEFT));
        sp.setLayout(new FlowLayout(FlowLayout.LEFT));
        np.setLayout(new FlowLayout(FlowLayout.LEFT));
        rp.add(rl);
        sp.add(sl);
        np.add(nl);

     //--------------------------------------------------------------------------
     
        c1Panel.add(rp);
        c2Panel.add(np);
        c3Panel.add(sp);
        
        c1Panel.add(new JLabel("1"));
        c1Panel.add(new JLabel("2"));
        c1Panel.add(new JLabel("3"));
        c1Panel.add(new JLabel("4")); 
        
        for (int i = 0; i < 4; i++) {
            String[] parts = topSellers.get(i).split(" - Sold: ");
            c2Panel.add(new JLabel(parts[0]));  
            c3Panel.add(new JLabel(parts[1]));  
        }
     //-----------------------------------------------------------------------
        
        rl.setFont(new Font("Dialog", Font.BOLD, 13));
        nl.setFont(new Font("Dialog", Font.BOLD, 13));
        sl.setFont(new Font("Dialog", Font.BOLD, 13));
        bigL.setFont(new Font("Serif", Font.BOLD, 21));
        rl.setForeground(new Color(0xEDE4D8));
        nl.setForeground(new Color(0xEDE4D8));
        sl.setForeground(new Color(0xEDE4D8));

        bigL.setIcon(m0);
        bigL.setForeground(new Color(0xEDE4D8));

        rl.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E), 5, true));
        sl.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E), 5, true));
        nl.setBorder(BorderFactory.createLineBorder(new Color(0x590E0E), 5, true));
       
        tPanel.setBackground(new Color(0x333333));
        c1Panel.setBackground(new Color(0x333333));
        c2Panel.setBackground(new Color(0x333333));
        c3Panel.setBackground(new Color(0x333333));
        tablePanel.setBackground(new Color(0x333333));
        rp.setBackground(new Color(0x333333));
        sp.setBackground(new Color(0x333333));
        np.setBackground(new Color(0x333333));
        em1Panel.setBackground(new Color(0x333333));
        em2Panel.setBackground(new Color(0x333333));
        em3Panel.setBackground(new Color(0x333333));

        
        setLabelColors(c1Panel);
        setLabelColors(c2Panel);
        setLabelColors(c3Panel);

     //------------------------------------------------------------------------
        tablePanel.add(c1Panel);
        tablePanel.add(c2Panel);
        tablePanel.add(c3Panel);
        tPanel.add(bigL);
        
        add(tPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(em3Panel, BorderLayout.SOUTH);
        add(em1Panel, BorderLayout.EAST);
        add(em2Panel, BorderLayout.WEST);
        
        setVisible(true);

    }

    private void setLabelColors(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JLabel) {
                ((JLabel) comp).setForeground(new Color(0xEDE4D8));
            }
        }
    }

   
}
