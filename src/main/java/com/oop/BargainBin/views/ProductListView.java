package com.oop.BargainBin.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductListView extends Component {
    private javax.swing.JTable JTable_Products ;
    private DefaultTableModel tableModel;
    DefaultTableModel model ;

    /**
     * Constructor- Initialize the fields
     */
    public ProductListView(){
        JTable_Products = new javax.swing.JTable();

    }

    public JTable getJTable(){
        return JTable_Products;

    }

    /**
     * Set the model for the table
     * @param row rows to be added
     */
    public void setModel(Object[][] row){
        model = new DefaultTableModel(row,new String [] {
                "ID", "Name", "Price", "Category","Description"
        });
        JTable_Products.setModel(model);
    }
}
