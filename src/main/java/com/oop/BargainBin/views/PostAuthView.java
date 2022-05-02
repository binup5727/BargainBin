package com.oop.BargainBin.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Master view for the post auth functionalities
 */
public class PostAuthView extends JFrame{

    private JPanel panel = new JPanel();
    private JTabbedPane tabs;
    int cartCount=0;

    private javax.swing.JTable productTable ;
    DefaultTableModel productModel ;
    private javax.swing.JTable cartTable ;
    DefaultTableModel cartModel ;


    JPanel panelProducts = new JPanel(new BorderLayout());
    JPanel panelCart = new JPanel(new BorderLayout());
    JButton buttonCart ;
    JButton button = new JButton();
    JButton buttonDelete = new JButton();

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
            buttonCart = new JButton("Cart : "+ cartCount + ". Total Amount : " + 0);
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
        panelProducts.setBounds(0, 0, 800, 396);
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
        panelCart.setBounds(205, 0, 800, 396);
        tabs.addTab("Cart", panelCart);
    }

    public void resetCartPanel(Object[][] cartItems){
        panelCart.removeAll();
        setCartPanel(cartItems);
    }
    public void resetProductPanel(Object[][] products){
        panelProducts.removeAll();
        setProductPanel(products);
    }

    /**
     * Open the cart tab
     */
    public void openCartTab(){
        tabs.setSelectedIndex(1);
    }

    /**
     * Open the cart tab listener
     * @param listener
     */
    public void openCartListener(ActionListener listener){
        buttonCart.addActionListener(listener);
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
     * Get the selected row number
     * @return the selected row number
     */
    public int getSelectedRow(){
        return productTable.convertRowIndexToModel(productTable.getSelectedRow());
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

