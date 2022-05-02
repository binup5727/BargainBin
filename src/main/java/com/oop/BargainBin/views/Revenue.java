package com.oop.BargainBin.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * creates revenue view with all components
 * gets and outputs data on sales.
 */
/**
 * 
 * @author rev Remekie
 */
public class Revenue{

	public JPanel contentPane;
	public JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblBuyPrice;
	private JLabel lblSellPrice;
	public JButton btnNewButton;
	private JButton btnNewButton_1;
	public JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public JTextField textField_4;
	private JLabel lblNewLabel_2;
	public JTextField textField_5;
	private JLabel lblNewLabel_3;
	public JTextField textField_6;
	private JLabel lblNewLabel_4;


	public Revenue() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 845, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Revenue");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(352, 11, 128, 35);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(238, 68, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JLabel lblProductId = new JLabel("Name");
		lblProductId.setBounds(50, 71, 72, 14);
		contentPane.add(lblProductId);

		btnNewButton = new JButton("Calculate");
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(143, 200, 89, 23);
		contentPane.add(btnNewButton);

		
		textField_3 = new JTextField();
		textField_3.setBounds(238, 357, 160, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel = new JLabel("Profit");
		lblNewLabel.setBounds(50, 360, 46, 14);
		contentPane.add(lblNewLabel);
		
                
		textField_4 = new JTextField();
		textField_4.setBounds(238, 411, 160, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
                
		lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(50, 258, 83, 14);
		contentPane.add(lblNewLabel_2);
		
                
		textField_5 = new JTextField();
		textField_5.setBounds(238, 258, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Cost ");
		lblNewLabel_3.setBounds(50, 411, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(238, 460, 160, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Total Sale Value");
		lblNewLabel_4.setBounds(50, 463, 107, 14);
		contentPane.add(lblNewLabel_4);
	}
}
