/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

import com.oop.BargainBin.controllers.AccountController;
import com.oop.BargainBin.models.AccountModel;
import com.oop.BargainBin.views.LoginRegisterView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author binup
 */

public class BargainBin {
    
    
    private BargainBin() {
        
        logRegView = new LoginRegisterView();
        accModel = new AccountModel(logRegView);
        mainFrame = new JFrame();
        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.LINE_AXIS));
        mainFrame.add(logRegView.getTabs());
        mainFrame.setExtendedState(mainFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        mainFrame.setPreferredSize(new Dimension(1500,800));
        mainFrame.pack();
        mainFrame.setVisible(true);
       
        acc = new AccountController(logRegView, accModel);
        
        
    }
    /**
     * Exit the Application
     */
    
    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }    
    
    public static BargainBin getInst(){
        return inst;
    }
    
    
    
     /**
     * @param args the command line arguments
     */
    //step 1 bargain bin single instance made in main
    //login view and account model constructed.
    //acount controller constructed pass login vie and account model.
    /**
     * when user registers or logs in
     * account controller will populate account model
     * account controller will create instance of account class seller or customer
     * account controller will temp make copy or main frame
     * account controller will call parent of login view panel and remove it
     * then the specific version of account type class seller or buyer method strategy pattern
     * Stretegy pattern will make the panels/views for each account type and do  mainframe.add()
     * 
     */
    
    
    
    public static void main(String args[]) {
        
        BargainBin BargainBinMain = BargainBin.getInst();
        
        
//        Temp main = new Temp();
//        
//        LoginRegisterView login = null;
//        System.out.println("login added");
//        login = new LoginRegisterView();
//        JTabbedPane loginPanel = login.getTabs();
//        main.setLayout(new BorderLayout());
//        System.out.println(login);
//        main.add(loginPanel);
//        
//        
//        //main.pack();
//        
//        System.out.println(loginPanel.getParent());
//        main.setVisible(true);
//        //main.setBounds(0, 0, main.getWidth(), main.getHeight() - main.Tabs.getHeight());
//        main.MainPage.remove(0);
//        
//        
//        System.out.println(main);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
    
    
    
    private static BargainBin inst = new BargainBin();
    private JFrame mainFrame;
    private AccountController acc;
    private LoginRegisterView logRegView;
    private AccountModel accModel;
    
    
}
