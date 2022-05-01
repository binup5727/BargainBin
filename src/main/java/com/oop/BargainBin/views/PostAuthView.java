package com.oop.BargainBin.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Locale;

/**
 * Master view for the post auth functionalities
 */
public class PostAuthView extends JFrame{

    private JTabbedPane tabs;
    private javax.swing.JTable productTable ;
    DefaultTableModel model ;
    JPanel panelProducts = new JPanel(new BorderLayout());
    JPanel panelCart = new JPanel(new BorderLayout());

    /**
     * Constructor
     * @param accountType customer or seller
     */
     public PostAuthView(String accountType) {
        initComponents(accountType);
    }

    /**
     * Initialize the fields for the frame
     */
    private void initComponents(String accountType) {
        this.setLayout(null);
        tabs = new javax.swing.JTabbedPane();

        if (accountType.toLowerCase(Locale.ROOT).equals("customer")) {
            tabs.setPreferredSize(new Dimension(800, 800));
            tabs.setMinimumSize(new Dimension(800, 800));
            tabs.setMaximumSize(new Dimension(800, 800));
        }else{
            tabs.setPreferredSize(new Dimension(900, 900));
            tabs.setMinimumSize(new Dimension(900, 900));
            tabs.setMaximumSize(new Dimension(900, 900));
        }
        
    }

    /**
     * Get the tabs of the pane
     * @return JTabbedPane
     */
    public JTabbedPane getTabs() {
        return tabs;
    }

    /**
     * Set the model for the table
     * @param row rows to be added
     */
    public void setModel(Object[][] row){
        //Define the model for the JTable
        model = new DefaultTableModel(row,new String [] {
                "Name", "Price", "Category","Description"
        });

        productTable = new javax.swing.JTable(model);
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        productTable.getColumnModel().getColumn(0).setPreferredWidth(113);

        productTable.setModel(model);
        panelProducts.add(new JScrollPane(productTable), BorderLayout.CENTER);
        //panel_1.add(productTable);
        panelProducts.setBackground(SystemColor.activeCaption);
        panelProducts.setBounds(0, 0, 304, 396);
        tabs.addTab("Products", panelProducts);

        panelCart.setBackground(SystemColor.activeCaption);
        panelCart.setBounds(205, 0, 304, 396);
        tabs.addTab("Cart", panelCart);
        getContentPane().add(tabs);

    }

    private void CartBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }                                       

     // Variables declaration - do not modify                     
    private javax.swing.JButton CartBtn;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel MarketPanel;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTabbedPane Tabs;
    // End of variables declaration   
    
}