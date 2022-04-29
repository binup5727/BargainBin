/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author binup
 */
public class PostAuth {
    
     public PostAuth() {
        initComponents();
    }

    public JPanel getPostAuth() {
        return postAuth;
    }

    public JTabbedPane getTabs() {
        return Tabs;
    }
     
    

    
    private void initComponents() {

        postAuth = new javax.swing.JPanel();
        Tabs = new javax.swing.JTabbedPane();
        

        Tabs.setToolTipText("");

        
        postAuth.add(Tabs);

        

      
    }// </editor-fold>     
    
    
    
    
    
    
    
        private void CartBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    
    
     // Variables declaration - do not modify                     
    private javax.swing.JButton CartBtn;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel postAuth;
    private javax.swing.JPanel MarketPanel;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTabbedPane Tabs;
    // End of variables declaration   
    
}
