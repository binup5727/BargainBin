/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.views;

/**
 *
 * @author binup
 */

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class LoginRegisterView implements Serializable{

	private JFrame frame;
        private JTabbedPane tabs;
        //fields for log in swing components.
	private JTextField user;
	private JPasswordField pass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
        
        //fields for register swing components
        private JTextField regUser;
	private JPasswordField regPass;
	private JLabel reglblNewLabel;
	private JLabel reglblNewLabel_1;
	private JLabel reglblNewLabel_2;
	private JLabel reglblNewLabel_3;
        private JTextField regName;
        
        //buttons
        JButton btnNewButton;
        JButton btnNewButton2;

	/**
	 * Create the application.
	 */
	public LoginRegisterView() {
		initialize();
	}

        public JTabbedPane getTabs() {
            return tabs;
        }
        
        public JButton getLoginbtn(){
            return btnNewButton;
        }
        public JButton getRegisterBtn(){
            return btnNewButton2;
        }
        private int spacer(int space, int XY, int n){
            
            return XY + (n* space);
        }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.getContentPane().setBackground(Color.BLACK);
//		frame.setBounds(100, 100, 545, 457);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		tabs = new javax.swing.JTabbedPane();
                tabs.setPreferredSize(new Dimension(1500,1500));
                tabs.setMinimumSize(new Dimension(1500,1500));
                tabs.setMaximumSize(new Dimension(1500,1500));

//		panel = new JPanel();
//		panel.setBackground(SystemColor.textHighlight);
//		panel.setBounds(10, 11, 509, 396);
//		//frame.getContentPane().add(panel);
//		tabs.setLayout(null);

                int x = 51;
                
                
                int y = 101;
//		
                int spacingX = 70;
                int spacingY = 31;
                
                int lvl1X = spacer(spacingX, x, 1);
                int lvl1Y = spacer(spacingY, y, 1);
                
                int lvl2X = spacer(spacingX, x, 2);
                int lvl2Y = spacer(spacingY, y, 2);
                
                int lvl3X = spacer(spacingX, x, 3);
                int lvl3Y = spacer(spacingY, y, 3);
                
                int lvl4X = spacer(spacingX, x, 4);
                int lvl4Y = spacer(spacingY, y, 4);
                
                int lvl5X = spacer(spacingX, x, 5);
                int lvl5Y = spacer(spacingY, y, 5);
                
                

                //login side
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(205, 0, 304, 396);
		tabs.addTab("Log In", panel_1);
		panel_1.setLayout(null);
		
		user = new JTextField();
		user.setBounds(lvl1X, y, 143, 20);
		panel_1.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(lvl1X, lvl1Y, 143, 20);
		panel_1.add(pass);
		
		lblNewLabel = new JLabel("Username");
            
		lblNewLabel.setBounds(x, y, 72, 14);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(x, lvl1Y, 72, 14);
		panel_1.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Login");
		
		btnNewButton.setBounds(181, 166, 89, 23);
		panel_1.add(btnNewButton);
                
                
                //registration side
                JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(205, 0, 304, 396);
		panel_2.setLayout(null);
                tabs.addTab("Register", panel_2);
                
                
                regUser = new JTextField();
                regUser.setBounds(lvl1X, y, 143, 20);
                panel_2.add(regUser);
                regUser.setColumns(10);
		
		regPass = new JPasswordField();
		regPass.setBounds(lvl1X, lvl1Y, 143, 20);
		panel_2.add(regPass);
		
		reglblNewLabel = new JLabel("Username");
		reglblNewLabel.setBounds(x, y, 72, 14);
		panel_2.add(reglblNewLabel);
		
		reglblNewLabel_1 = new JLabel("Password");
		reglblNewLabel_1.setBounds(x, lvl1Y, 72, 14);
		panel_2.add(reglblNewLabel_1);
                
                
                             
                reglblNewLabel_2 = new JLabel("Account");
		reglblNewLabel_2.setBounds(x, lvl2Y, 72, 14);
		panel_2.add(reglblNewLabel_2);
                 
                
                String[] optionsToChoose = {"Customer", "Seller"};
                JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);               
                jComboBox.setBounds(lvl1X, lvl2Y, 140, 20);                
                panel_2.add(jComboBox);

    
                
                
		
		btnNewButton2 = new JButton("Register");
		
                btnNewButton2.setBounds(181, lvl4Y, 89, 23);
		panel_2.add(btnNewButton2);
                
                
		
//		lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(-205, 0, 509, 396);
//		ImageIcon icon = new ImageIcon(this.getClass().getResource("/login.jpg"));
//		lblNewLabel_2.setIcon(icon);
//		panel_1.add(lblNewLabel_2);
//		
//		lblNewLabel_3 = new JLabel("");
//		lblNewLabel_3.setBounds(0, 0, 204, 396);
//		ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/login.jpg"));
//		lblNewLabel_3.setIcon(icon2);
//		panel.add(lblNewLabel_3);
	}
        
        
        
        
}
