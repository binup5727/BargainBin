/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author binup
 */
public class AccountController {

    
  

    AccountController(LoginRegisterView logRegView, AccountModel accModel) {
        this.accModel = accModel;
        this.logRegView = logRegView;
        JButton loginBtn = this.logRegView.getLoginbtn();
        JButton regBtn = this.logRegView.getRegisterBtn();
        loginBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				//get text from user
				//get text from password
//				String un  = this.accView.user.getText();
//				String pas = this.accView.pass.getText();
                                JTextField us = (JTextField) loginBtn.getParent().getComponent(0);
                                JTextField pass = (JTextField) loginBtn.getParent().getComponent(1);
                                getUser(us.getText(), pass.getText());
				
				//getUser(un, pas);
			}
		});
        
        regBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				//get text from user
				//get text from password
//				String un  = this.accView.user.getText();
//				String pas = this.accView.pass.getText();
                                JTextField us = (JTextField) regBtn.getParent().getComponent(0);
                                JTextField pass = (JTextField) regBtn.getParent().getComponent(1);
                                JComboBox accType = (JComboBox) regBtn.getParent().getComponent(5);
                                if(us.getText().equals("") || pass.getText().equals("")){
                                    JOptionPane.showMessageDialog(null, "Entries cannot be empty");
                                }else{
                                    
                                    registerUser(us.getText(), pass.getText(), String.valueOf(accType.getSelectedItem()));
                                }
				//getUser(un, pas);
			}
		});
    }

    
    public void registerUser(String username, String pasword, String AccountType){
        accModel.id = accountService.getLastUser() + 1;
        accModel.username = username;
        accModel.password = pasword;
        accModel.accountType = AccountType;
        if(accountService.getUser(username) == null){
            accountService.registerUser(accModel);
            logRegView.getTabs().setVisible(false);
            BargainBin.getInst().mainFrame.remove(logRegView.getTabs());
        }else{
            JOptionPane.showMessageDialog(null, "Account already made");
        }
        
        
        
        
    }
    
    public void getUser(String username, String pasword){
        
        AccountModel temp = accountService.getUser(username);
        if (temp == null){
            JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
        }else{
            accModel = temp;
            JOptionPane.showMessageDialog(null, "Success");
            logRegView.getTabs().setVisible(false);
            BargainBin.getInst().mainFrame.remove(logRegView.getTabs());
            
        }
        
    
    }
    
    

    public AccountModel accModel;
    public LoginRegisterView logRegView;
    public AccountService accountService = new AccountService();


}

