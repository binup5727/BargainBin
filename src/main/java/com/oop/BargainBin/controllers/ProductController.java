/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.controllers;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.observerPattern.ProductPublisher;
import com.oop.BargainBin.observerPattern.CartSubscriber;
import com.oop.BargainBin.services.ProductService;
import com.oop.BargainBin.views.PostAuthView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller for product related activities
 */
public class ProductController {
    ProductService service = new ProductService();

    private ProductModel model;
    private PostAuthView view;
    private ArrayList<ProductModel> list;
    /**
     * Constructor
     * @param m model
     * @param v view
     */
    public ProductController(ProductModel m, PostAuthView v) {
        model = m;
        view = v;
        getProducts();
        v.addToCartListener(new AddToCartListener());
    }

    public void initView(){

    }

    /**
     * Fetch the available products
     */
    public void getProducts(){
        list = service.getProductList();
        assignValuesToView(list);
    }

    /**
     * Assign the products to the customer list
     * @param list product list
     */
    public void assignValuesToView(ArrayList<ProductModel> list){
        //Arranging to an object multi dimentional array to populate in the table
        Object[][] row = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            row[i][0] = list.get(i).getName();
            row[i][1] = list.get(i).getPrice();
            row[i][2] = list.get(i).getCategory();
            row[i][3] = list.get(i).getDescription();
            row[i][4] = list.get(i).getQuantityAvailable();
        }

        //Set the values to the model for the JTable
        view.setModelForCustomerProducts(row);
    }

    /**
     * Adding the items to the cart
     */
    public class AddToCartListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //Fetch the selected product
                ProductModel selectedProduct = list.get(view.getSelectedRow());

                //Check if the product is available to add to the cart. You cannot add than the available quantity for a product
                if (service.isProductAvailableForCart(selectedProduct)) {
                    //Implementing the observer pattern here
                    CartSubscriber cartSubscriber = new CartSubscriber();
                    ProductPublisher publisher = new ProductPublisher();
                    publisher.attach(cartSubscriber);

                    //Adding the product to the singleton cart object
                    publisher.notifyUpdate(selectedProduct);
                    publisher.detach(cartSubscriber);

                    //setting the cart items count in the customer view
                    view.setCartCount();
                } else {
                    //If you try to add more counts than available for a product, then show message that you cannot add more
                    JOptionPane.showMessageDialog(null, "You can add only the available counts to the cart");
                }
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Some issue happened while trying to add the item to the cart");
            }
        }
    }
}
