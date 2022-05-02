package com.oop.BargainBin.views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Product{

	public JPanel contentPane;
	private JTextField textField;
	private JTextField txtProducts;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel_1;
	private JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;
	public JTextField textField_9;
	private JLabel lblNewLabel_2;
	private JTable table;
	private JTable table_1;
	public JTable table_2;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
        public final JButton addBtn;
        public final JButton removeBtn;
        public final JTextField comboBox;
        


	/**
	 * Create the frame.
	 */
	public Product() {
		//getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		
		JPanel panel2;
		contentPane.setLayout(null);
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 912, 76);
		panel_1.setBackground(Color.BLUE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Products");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_3.setBounds(391, 33, 139, 32);
		panel_1.add(lblNewLabel_3);
		
//		textField_5 = new JTextField();
//		textField_5.setBounds(200, 99, 174, 20);
//		contentPane.add(textField_5);
//		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(200, 150, 174, 20);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(200, 197, 174, 20);
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(200, 246, 174, 20);
		textField_8.setColumns(10);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(200, 296, 174, 20);
		textField_9.setColumns(10);
		contentPane.add(textField_9);
		
//		JLabel lblNewLabel_1 = new JLabel("Product ID");
//		lblNewLabel_1.setBounds(32, 102, 72, 14);
//		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(32, 153, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setBounds(32, 200, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Category");
		lblNewLabel_1_3.setBounds(32, 249, 83, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Description");
		lblNewLabel_1_4.setBounds(32, 299, 72, 14);
		contentPane.add(lblNewLabel_1_4);
		
		comboBox = new JTextField();
		comboBox.setBounds(200, 341, 174, 22);
		contentPane.add(comboBox);
//		
		lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(32, 349, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		addBtn = new JButton("Add Item");
		addBtn.setForeground(Color.WHITE);
		addBtn.setBackground(Color.BLUE);
		addBtn.setBounds(90, 400, 89, 23);
		contentPane.add(addBtn);
		
		removeBtn = new JButton("Remove Item");
		removeBtn.setForeground(Color.WHITE);
		removeBtn.setBackground(Color.BLUE);
		removeBtn.setBounds(235, 400, 139, 23);
		contentPane.add(removeBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 87, 444, 186);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Product ID", "Name", "Price", "Description", "Category", "Sold"
			}
		));
		
		
	}

}