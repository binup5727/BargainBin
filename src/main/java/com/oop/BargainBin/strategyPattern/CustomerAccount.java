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

    /**
     * Initialize the view
     */
    private void initView(){
        //Initializing the postAuthView based on the user type
        PostAuthView postAuthView = new PostAuthView("customer");
        ProductModel model = new ProductModel();
        new ProductController(model, postAuthView);

        postAuthView.getPanel().setVisible(true);
        postAuthView.getTabs().setVisible(true);
        BargainBin.getInst().getMainFrame().add(postAuthView.getPanel());
    }


}
