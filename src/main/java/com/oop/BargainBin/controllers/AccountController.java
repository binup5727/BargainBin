/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.controllers;
import com.oop.BargainBin.models.AccountModel;
import com.oop.BargainBin.BargainBin;
import com.oop.BargainBin.patterns.AccountType;
import com.oop.BargainBin.patterns.CustomerAccount;
import com.oop.BargainBin.patterns.SellerAccount;
import com.oop.BargainBin.services.AccountService;
import com.oop.BargainBin.views.LoginRegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author binup
 */
public class AccountController {

    
  
    /**
     * keeps a version of view and model to control.
     * view has actionlistner functions that tell control of new data from user.
     * @param logRegView view of preauth screen
     * @param accModel view of model of account to fill with user info.
     */
    public AccountController(LoginRegisterView logRegView, AccountModel accModel) {
        this.accModel = accModel;
        this.logRegView = logRegView;
        JButton loginBtn = this.logRegView.getLoginbtn();
        JButton regBtn = this.logRegView.getRegisterBtn();
        loginBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
                                JTextField us = (JTextField) loginBtn.getParent().getComponent(0);
                                JTextField pass = (JTextField) loginBtn.getParent().getComponent(1);
                                getUser(us.getText(), pass.getText());
				
				
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

    /**
     * 
     * @param username username string to register into permanent file
     * @param pasword   password string to register into permanent file
     * @param AccountType account type either Customer or Seller.
     */
    public void registerUser(String username, String pasword, String AccountType){
        accModel.id = accountService.getLastUser() + 1;
        accModel.username = username;
        accModel.password = pasword;
        accModel.accountType = AccountType;
        if(accountService.getUser(username) == null){

            accountService.registerUser(accModel);

            changeView();
            //BargainBin.getInst().mainFrame.remove(logRegView.getTabs());
        }else{
            JOptionPane.showMessageDialog(null, "Account already existing");
        }
    }
    
    /**
     * 
     * @param username string username used to look up and get user
     * @param pasword password must match to get account model
     */
    public void getUser(String username, String pasword){
        
        AccountModel temp = accountService.getUser(username);
        if (temp == null){
            JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
        }else{
            accModel = temp;
            changeView();
            
            
        }
        
    
    }

    /**
     * Navigating to the corresponding postAuth view based on the Customer type or the Seller type
     */
    public void changeView(){
        logRegView.getTabs().setVisible(false);
        BargainBin.getInst().getMainFrame().remove(logRegView.getTabs());
        if(accModel.accountType.equals("Customer")) {
            account = new CustomerAccount(accModel);
        } else if(accModel.accountType.equals("Seller")){
            account = new SellerAccount(accModel);
        }
    }

    
    /**
     * fields
     */
    public AccountModel accModel;
    public LoginRegisterView logRegView;
    public AccountService accountService = new AccountService();
    public AccountType account;

}

