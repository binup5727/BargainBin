/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.views;

import com.oop.BargainBin.singletonPattern.Cart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Vector;

/**
 * Master view for the post auth functionalities
 */
public class PostAuthView extends JFrame{

    private JPanel panel = new JPanel();
    private JTabbedPane tabs;
    private javax.swing.JTable productTable ;
    DefaultTableModel model ;
    JPanel panelProducts = new JPanel(new BorderLayout());
    JPanel panelCart = new JPanel(new BorderLayout());
    JButton buttonCart ;
    JButton button = new JButton();
    Cart cart = Cart.getInstance();

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
            buttonCart = new JButton("Cart:" + cart.getCartItemsCount());
        }
    }

    /**
     * Get the tabs of the pane
     * @return JTabbedPane
     */
    public JTabbedPane getTabs() {
        return tabs;
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Set the model and the structure for the table
     * @param row rows to be added
     */
    public void setModelForCustomerProducts(Object[][] row){
        //Define the model for the JTable
        model = new DefaultTableModel(row,new String [] {
                "Name", "Price", "Category","Description","Quantity Available","Action"
        });

        productTable = new javax.swing.JTable(model);
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        productTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        productTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
        productTable.getColumnModel().getColumn(0).setPreferredWidth(113);

        productTable.setModel(model);
        panelProducts.add(new JScrollPane(productTable), BorderLayout.CENTER);
        panelProducts.setBackground(SystemColor.activeCaption);
        panelProducts.setBounds(0, 0, 800, 396);
        tabs.addTab("Products", panelProducts);

        panelCart.setBackground(SystemColor.activeCaption);
        panelCart.setBounds(205, 0, 800, 396);
        tabs.addTab("Cart", panelCart);
        panel.add(tabs);
        panel.add(buttonCart);
    }

    private void CartBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Method to add the listener to the JTable button
     * @param listener listener to be used
     */
    public void addToCartListener(ActionListener listener){
        button.addActionListener(listener);
    }

    /**
     * Get the selected row number
     * @return the selected row number
     */
    public int getSelectedRow(){
        return productTable.convertRowIndexToModel(productTable.getSelectedRow());
    }

    /**
     * Set the cart items count to the cart button
     */
    public void setCartCount(){
        buttonCart.setText("Cart:"+ cart.getCartItemsCount());
    }

    /**
     * Rendering the add to cart button
     */
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Add to cart" : value.toString());
            return this;
        }
    }

    /**
     * Rendering the add to cart button
     */
    class ButtonEditor extends DefaultCellEditor {
        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            label = (value == null) ? "Add to cart" : value.toString();
            button.setText(label);
            return button;
        }
        public Object getCellEditorValue() {
            return label;
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton CartBtn;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel MarketPanel;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTabbedPane Tabs;
    // End of variables declaration

}

