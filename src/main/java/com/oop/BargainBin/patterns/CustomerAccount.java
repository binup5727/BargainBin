/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.patterns;

import com.oop.BargainBin.BargainBin;
import com.oop.BargainBin.controllers.ProductController;
import com.oop.BargainBin.models.AccountModel;
import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.views.LoginRegisterView;
import com.oop.BargainBin.views.PostAuthView;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * Class that implements the strategy pattern to load the customer views
 */
public class CustomerAccount implements AccountType{

    /**
     * Constructor
     * @param accountModel accountModel
     */
    public CustomerAccount(AccountModel accountModel) {
        loadUserPlatform();
    }

    @Override
    public void loadUserPlatform() {
        initView();
    }

    private void initView(){
        PostAuthView postAuthView = new PostAuthView("customer");

        ProductModel model = new ProductModel();
        controller = new ProductController(model, postAuthView);
        
        BargainBin.getInst().getMainFrame().add(postAuthView.getTabs());
        postAuthView.getTabs().setVisible(true);
    }
    
    
    public ProductController controller;

}
