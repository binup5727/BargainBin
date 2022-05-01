/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Product frame = new Product();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	/**
	 * Create the frame.
	 */
	public Product() {
		//getContentPane().setLayout(null);
		
//		panel = new JPanel();
//		panel.setBackground(Color.BLUE);
//		panel.setBounds(0, 0, 799, 64);
//		//getContentPane().add(panel);
//		panel.setLayout(null);
//		
//		txtProducts = new JTextField();
//		txtProducts.setText("Products");
//		txtProducts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
//		txtProducts.setBounds(306, 11, 173, 42);
//		panel.add(txtProducts);
//		txtProducts.setColumns(10);
//		
////		textField_1 = new JTextField();
////		textField_1.setBounds(195, 75, 223, 28);
////		getContentPane().add(textField_1);
////		textField_1.setColumns(10);
//		
//		textField_2 = new JTextField();
//		textField_2.setColumns(10);
//		textField_2.setBounds(195, 144, 223, 28);
//		panel.add(textField_2);
//		
//		textField_3 = new JTextField();
//		textField_3.setColumns(10);
//		textField_3.setBounds(195, 213, 223, 28);
//		panel.add(textField_3);
//		
//		textField_4 = new JTextField();
//		textField_4.setColumns(10);
//		textField_4.setBounds(195, 286, 223, 28);
//		panel.add(textField_4);
//		
//		JLabel lblNewLabel = new JLabel("Product ID");
//		lblNewLabel.setBounds(47, 82, 84, 21);
//		panel.add(lblNewLabel);
//		
//		JLabel lblQuantity = new JLabel("Quantity");
//		lblQuantity.setBounds(36, 151, 84, 21);
//		panel.add(lblQuantity);
//		panel.setLayout(null);
//		
//		JPanel panel1 = new JPanel();
//		panel.setBackground(Color.BLUE);
//		panel.setBounds(0, 0, 799, 86);
//		panel.add(panel);
//		
//		textField = new JTextField();
//		textField.setBounds(177, 271, 86, 20);
//		panel.add(textField);
//		textField.setColumns(10);
//		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//setBounds(100, 100, 928, 538);
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
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Product ID", "Name", "Price", "Description", "Category", "Sold"
			}
		));
		
		
	}

}
