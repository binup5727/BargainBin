/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.patterns;

import com.oop.BargainBin.BargainBin;
import com.oop.BargainBin.models.AccountModel;
import com.oop.BargainBin.views.PostAuth;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author binup
 */
public class CustomerAccount implements AccountType{

    CustomerAccount(AccountModel aThis) {
        
        loadUserPlatform();
    }

    @Override
    public void loadUserPlatform() {
        PostAuth page = new PostAuth();
        //productsView;
        
        page.getTabs().add(new JPanel());
        
        //barbainbin . get inst to get main window fram and add any panel then set visibility to show it
        //add 
        //BargainBin.getInst().Frame.add(whatever jpanel );
        //page.getTabs().visibillity(true);
        
        
    }
    
    
    
}
