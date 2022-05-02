/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Master view for the post auth functionalities
 *
 */
public class PostAuthView extends JFrame{

    private JPanel panel = new JPanel();
    private JTabbedPane tabs;
    int cartCount=0;

    private javax.swing.JTable productTable ;
    DefaultTableModel productModel ;
    private javax.swing.JTable cartTable ;
    DefaultTableModel cartModel ;
    private javax.swing.JTable checkoutTable ;
    DefaultTableModel checkoutModel ;

    private JTextField textCreditCard;
    private JTextField textAddress;
    private JLabel labelCreditCard;
    private JLabel labelAddress;

    JPanel panelProducts = new JPanel(new BorderLayout());
    JPanel panelCart = new JPanel(new BorderLayout());
    JPanel panelCheckout = new JPanel(new BorderLayout());
    JButton buttonCart ;
    JButton button = new JButton();
    JButton buttonDelete = new JButton();
    JButton buttonCheckout = new JButton("Checkout");
    JButton buttonOrder = new JButton("Order");

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
            tabs.setPreferredSize(new Dimension(1000, 800));
            tabs.setMinimumSize(new Dimension(1000, 700));
            tabs.setMaximumSize(new Dimension(1000, 700));
            buttonCart = new JButton("Cart : "+ cartCount + ". Total Amount : " + 0);
            buttonCheckout.setBounds(181, 166, 89, 23);
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
     * @param products products to be added
     * @param cartItems items in the cart
     */
    public void setModelForCustomerProducts(Object[][] products, Object[][] cartItems){
        setProductPanel(products);
        setCartPanel(cartItems);

        panel.add(tabs);
        panel.add(buttonCart);
        panel.add(buttonCheckout);
    }
    public void setProductPanel(Object[][] products){
        String[] columns = new String [] {"Name", "Price", "Category", "Description", "Quantity Available", "Action"};
        //Define the model for the JTable
        productModel = new DefaultTableModel(products, columns);

        //Adding details to the products JTable
        productTable = new javax.swing.JTable(productModel);
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        productTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        productTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
        productTable.getColumnModel().getColumn(0).setPreferredWidth(113);
        productTable.setModel(productModel);

        //Adding the table and the products panel to the tabs
        panelProducts.add(new JScrollPane(productTable), BorderLayout.CENTER);
        panelProducts.setBackground(SystemColor.activeCaption);
        panelProducts.setBounds(0, 0, 900, 396);
        tabs.addTab("Products", panelProducts);
    }

    public void setCartPanel(Object[][] cartItems){
        String[] columns = new String [] {"Name", "Price", "Category", "Description", "Quantity for purchase", "Delete items"};
        cartModel = new DefaultTableModel(cartItems, columns);

        //Adding cart list to the cart table
        cartTable = new javax.swing.JTable(cartModel);

        cartTable.getTableHeader().setReorderingAllowed(false);
        cartTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        cartTable.getColumn("Delete items").setCellRenderer(new DeleteButtonRenderer());
        cartTable.getColumn("Delete items").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
        cartTable.getColumnModel().getColumn(0).setPreferredWidth(113);
        cartTable.setModel(cartModel);

        panelCart.add(new JScrollPane(cartTable), BorderLayout.CENTER);
        panelCart.setBackground(SystemColor.activeCaption);
        panelCart.setBounds(205, 0, 900, 396);

        tabs.addTab("Cart", panelCart);
    }

    /**
     * Set the checkout panel
     * @param cartItems cart items for checkout
     */
    public void setCheckoutPanel(Object[][] cartItems){
        textAddress = new JTextField();
        textAddress.setBounds(150, 550, 143, 20);
        panelCheckout.add(textAddress);
        textAddress.setColumns(10);

        textCreditCard = new JPasswordField();
        textCreditCard.setBounds(150, 600, 143, 20);
        panelCheckout.add(textCreditCard);

        labelAddress = new JLabel("Address");

        labelAddress.setBounds(51, 550, 72, 14);
        panelCheckout.add(labelAddress);

        labelCreditCard = new JLabel("Credit card");
        labelCreditCard.setBounds(51, 600, 72, 14);
        panelCheckout.add(labelCreditCard);

        buttonOrder.setBounds(51, 640, 100, 35);
        panelCheckout.add(buttonOrder);

        String[] columns = new String [] {"Name", "Price", "Category", "Description", "Quantity for purchase"};
        checkoutModel = new DefaultTableModel(cartItems, columns);

        //Adding cart list to the cart table
        checkoutTable = new javax.swing.JTable(checkoutModel);

        checkoutTable.getTableHeader().setReorderingAllowed(false);
        checkoutTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        checkoutTable.getColumnModel().getColumn(0).setPreferredWidth(113);
        checkoutTable.setModel(checkoutModel);

        panelCheckout.add(new JScrollPane(checkoutTable), BorderLayout.CENTER);
        panelCheckout.setBackground(SystemColor.activeCaption);
        panelCheckout.setBounds(205, 0, 900, 396);

        tabs.addTab("Checkout", panelCheckout);
        panel.add(tabs);
    }

    /**
     * Resetting the cart panel
     * @param cartItems items to be added to the panel
     */
    public void resetCartPanel(Object[][] cartItems){
        panelCart.removeAll();
        setCartPanel(cartItems);
    }

    /**
     * Resetting the checkout panel
     * @param cartItems items to be added to the panel
     */
    public void resetCheckoutPanel(Object[][] cartItems){
        panelCheckout.removeAll();
        setCheckoutPanel(cartItems);
    }

    /**
     * Open the checkout tab
     */
    public void openCheckoutTab(){
        tabs.setSelectedIndex(2);
    }

    /**
     * Open the cart tab
     */
    public void openCartTab(){
        tabs.setSelectedIndex(1);
    }

    /**
     * Get the tab count
     * @return tab count
     */
    public int getTabCount(){
        return tabs.getTabCount();
    }

    /**
     * Open the cart tab listener
     * @param listener listener
     */
    public void openCartListener(ActionListener listener){
        buttonCart.addActionListener(listener);
    }

    public  int getCheckoutTableItemCount(){
        return checkoutTable.getRowCount();

    }
    /**
     * Order listener
     * @param listener listener
     */
    public void orderListener(ActionListener listener){
        buttonOrder.addActionListener(listener);
    }

    private void CartBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Method to add AddToCartListener to the JTable button
     * @param listener listener to be used
     */
    public void addToCartListener(ActionListener listener){
        button.addActionListener(listener);
    }

    /**
     * Method to add  the DeleteCartListener to the JTable button
     * @param listener listener to be used
     */
    public void removeFromCartListener(ActionListener listener){
        buttonDelete.addActionListener(listener);
    }

    /**
     * Method to add  checkout for the purchase
     * @param listener listener to be used
     */
    public void checkoutListener(ActionListener listener){
        buttonCheckout.addActionListener(listener);
    }

    /**
     * Get the selected row number
     * @return the selected row number
     */
    public int getSelectedRow(){
        return productTable.convertRowIndexToModel(productTable.getSelectedRow());
    }

    /**
     * Get the selected row number
     * @return the selected row number
     */
    public int getCartSelectedRow(){
        return cartTable.convertRowIndexToModel(cartTable.getSelectedRow());
    }

    /**
     * Set the cart items count to the cart button
     */
    public void setCartCount(int count, float amount){
        buttonCart.setText("Cart : "+ count + ". Total Amount : " + amount);
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

    /**
     * Rendering the delete items button for the cart
     */
    class DeleteButtonRenderer extends JButton implements TableCellRenderer {
        public DeleteButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Delete" : value.toString());
            return this;
        }
    }

    /**
     * Rendering the delete items button for the cart
     */
    class DeleteButtonEditor extends DefaultCellEditor {
        private String label;

        public DeleteButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            label = (value == null) ? "Delete" : value.toString();
            buttonDelete.setText(label);
            return buttonDelete;
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

