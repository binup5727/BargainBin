package com.oop.BargainBin.customFields;

import javax.swing.*;
import java.awt.*;

/**
 * Editor button
 */
public class ButtonEditor extends DefaultCellEditor {
    private String label;
    JButton button = new JButton();

    /**
     * Constructor
     * @param checkBox check box
     */
    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
    }
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        label = (value == null) ? "Modify" : value.toString();
        button.setText(label);
        return button;
    }

    public Object getCellEditorValue() {
        return label;
    }
}
