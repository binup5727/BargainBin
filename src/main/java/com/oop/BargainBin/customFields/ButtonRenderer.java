package com.oop.BargainBin.customFields;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
/**
 * @author Athul
 */
/**
 * Table cell button
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
    /**
     * Constructor
     */
    public ButtonRenderer() {
        setOpaque(true);
    }

    /**
     *  Get the table rendered component
     * @param table  JTable
     * @param value value to be passed
     * @param isSelected selected or not
     * @param hasFocus has focus or not
     * @param row row
     * @param column column
     * @return Component
     */
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Add to cart" : value.toString());
        return this;
    }
}
