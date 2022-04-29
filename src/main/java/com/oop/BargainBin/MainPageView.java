/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

/**
 *
 * @author binup
 */
public class MainPageView {
    
     public MainPageView() {
        initComponents();
    }

    
    private void initComponents() {

        MainPage = new javax.swing.JPanel();
        Tabs = new javax.swing.JTabbedPane();
        HomePanel = new javax.swing.JPanel();
        ProfilePanel = new javax.swing.JPanel();
        MarketPanel = new javax.swing.JPanel();
        CartBtn = new javax.swing.JButton();


        Tabs.setToolTipText("");

        HomePanel.setName(""); // NOI18N

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        Tabs.addTab("Home", HomePanel);

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        ProfilePanelLayout.setVerticalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        Tabs.addTab("Profile", ProfilePanel);

        javax.swing.GroupLayout MarketPanelLayout = new javax.swing.GroupLayout(MarketPanel);
        MarketPanel.setLayout(MarketPanelLayout);
        MarketPanelLayout.setHorizontalGroup(
            MarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        MarketPanelLayout.setVerticalGroup(
            MarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        Tabs.addTab("Market", MarketPanel);

        MainPage.add(Tabs);

        CartBtn.setText("Cart");
        CartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartBtnActionPerformed(evt);
            }
        });
        MainPage.add(CartBtn);

      
    }// </editor-fold>     
    
    
    
    
    
    
    
        private void CartBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    
    
     // Variables declaration - do not modify                     
    private javax.swing.JButton CartBtn;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel MainPage;
    private javax.swing.JPanel MarketPanel;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTabbedPane Tabs;
    // End of variables declaration   
    
}
