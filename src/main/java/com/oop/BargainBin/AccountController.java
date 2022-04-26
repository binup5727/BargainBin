/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author binup
 */
public class AccountController {
    public AccountController(){
        loginModel = new AccountModel();
        loginView = loginModel.loginView;
        //grab info from serielized file
        loginView.btn..addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get text from user
				//get text from password
				String un  = user.getText();
				String pas = pass.getText();
				
				if (un.equals("admin")&&pas.equals("123")) {
					JOptionPane.showMessageDialog(null, "Login Successful");
                                        //update model fields 
                                        //call update on the model
                                        
                                        
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
				}
			}
		});
        
        
    }

AccountModel loginModel;

}

