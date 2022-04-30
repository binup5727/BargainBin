/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.views;

import com.oop.BargainBin.controllers.ProductController;
import com.oop.BargainBin.models.ProductModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Locale;

/**
 * Master view for the post auth functionalities
 */
public class PostAuthView {

    private JFrame frame;
    private JTabbedPane tabs;
    private javax.swing.JTable productTable ;
    DefaultTableModel model ;
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();

     public PostAuthView(String accountType) {
        initComponents(accountType);
    }

    public JTabbedPane getTabs() {
        return tabs;
    }

    /**
     * Initialize the fields for the frame
     */
    private void initComponents(String accountType) {
        if (accountType.toLowerCase(Locale.ROOT).equals("customer")) {
            productTable = new javax.swing.JTable();

            tabs = new javax.swing.JTabbedPane();
            tabs.setPreferredSize(new Dimension(800, 800));
            tabs.setMinimumSize(new Dimension(800, 800));
            tabs.setMaximumSize(new Dimension(800, 800));

            panel_1.setBackground(SystemColor.activeCaption);
            panel_1.setBounds(205, 0, 304, 396);
            tabs.addTab("Products", panel_1);
            panel_1.setLayout(null);

            panel_2.setBackground(SystemColor.activeCaption);
            panel_2.setBounds(205, 0, 304, 396);
            panel_2.setLayout(null);
            tabs.addTab("Cart", panel_2);
        }
    }
    /**
     * Set the model for the table
     * @param row rows to be added
     */
    public void setModel(Object[][] row){
        model = new DefaultTableModel(row,new String [] {
                "ID", "Name", "Price", "Category","Description"
        });
        productTable.setModel(model);
        panel_1.add(productTable);
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
