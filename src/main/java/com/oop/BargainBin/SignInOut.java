/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author binup
 */




public class SignInOut {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignInOut window = new SignInOut();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SignInOut() {	
            initialize();
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

panel = new JPanel();
panel.setBackground(SystemColor.textHighlight);
panel.setBounds(10, 11, 509, 396);
//frame.getContentPane().add(panel);
panel.setLayout(null);

JPanel panel_1 = new JPanel();
panel_1.setBackground(SystemColor.activeCaption);
panel_1.setBounds(205, 0, 304, 396);
panel.add(panel_1);
panel_1.setLayout(null);

user = new JTextField();
user.setBounds(151, 101, 143, 20);
panel_1.add(user);
user.setColumns(10);

pass = new JPasswordField();
pass.setBounds(151, 132, 143, 20);
panel_1.add(pass);

lblNewLabel = new JLabel("Username");
lblNewLabel.setBounds(51, 104, 72, 14);
panel_1.add(lblNewLabel);

lblNewLabel_1 = new JLabel("Password");
lblNewLabel_1.setBounds(51, 135, 72, 14);
panel_1.add(lblNewLabel_1);

JButton btnNewButton = new JButton("SignInOut");
btnNewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        //get text from user
        //get text from password
        String un  = user.getText();
        String pas = pass.getText();
        
        if (un.equals("admin")&&pas.equals("123")) {
            JOptionPane.showMessageDialog(null, "Log In Successful");
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
        }
    }
});
btnNewButton.setBounds(181, 166, 89, 23);
panel_1.add(btnNewButton);

lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setBounds(-205, 0, 509, 396);
ImageIcon icon = new ImageIcon(this.getClass().getResource("/login.jpg"));
lblNewLabel_2.setIcon(icon);
panel_1.add(lblNewLabel_2);

lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setBounds(0, 0, 204, 396);
ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/login.jpg"));
lblNewLabel_3.setIcon(icon2);
panel.add(lblNewLabel_3);
    }
        
    JPanel panel;
}

    

