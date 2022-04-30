/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.controllers;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.services.ProductService;
import com.oop.BargainBin.views.PostAuthView;
import java.util.ArrayList;

/**
 * Controller for product related activities
 */
public class ProductController {
    ProductService service = new ProductService();

    private ProductModel model;
    private PostAuthView view;

    /**
     * Constructor
     * @param m model
     * @param v view
     */
    public ProductController(ProductModel m, PostAuthView v) {
        model = m;
        view = v;
        getProducts();
    }

    public void initView(){

    }

    /**
     * Fetch the saved products
     */
    public void getProducts(){
        ArrayList<ProductModel> list = service.getProductList();

        //Arranging to an object multi dimentional array to populate in the table
        Object[][] row = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            row[i][0] = list.get(i).getName();
            row[i][1] = list.get(i).getPrice();
            row[i][2] = list.get(i).getCategory();
            row[i][3] = list.get(i).getDescription();

            //Set the values to the model for the JTable
            view.setModel(row);
        }

    }
}
