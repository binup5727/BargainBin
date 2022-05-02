/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.strategyPattern;

import com.oop.BargainBin.BargainBin;
import com.oop.BargainBin.controllers.ProductController;
import com.oop.BargainBin.models.AccountModel;
import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.views.PostAuthView;
import com.oop.BargainBin.views.Product;
import com.oop.BargainBin.views.Revenue;
import javax.swing.JTabbedPane;

/**
 *
 * @author binup
 */
/**
 * 
 */
public class SellerAccount implements AccountType{
    /**
     * 
     * @param accModel model to use send id to map to inventory. 
     */
    public SellerAccount(AccountModel accModel) {
        this.accModel = accModel;
        
        loadUserPlatform();
    }

    @Override
    /**
     * loads platform specific to user using product and revenue views.
     */
    public void loadUserPlatform() {
        //create views and controller and models to show seller screen.
        PostAuthView postAuthView = new PostAuthView("seller");
        Product Inventory = new Product();
        Revenue rev = new Revenue();
        tabs = postAuthView.getTabs();
        tabs.add(Inventory.contentPane, "Inventory");
        tabs.add(rev.contentPane, "Revenue");
        
        ProductModel model = new ProductModel();
        controller = new ProductController(model, postAuthView, Inventory, rev, accModel.id);
        
        BargainBin.getInst().getMainFrame().add(tabs);
        
        
        
        
    }
    /**
     * field of view model and controller.
     */
    public JTabbedPane tabs;
    public AccountModel accModel;
    public ProductController controller;
}
