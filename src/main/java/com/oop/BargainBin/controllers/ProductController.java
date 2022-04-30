/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.controllers;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.services.ProductService;
import com.oop.BargainBin.views.PostAuthView;
import com.oop.BargainBin.views.ProductListView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Controller for product related activities
 */
public class ProductController extends Component {
    ProductService service = new ProductService();

    private ProductModel model;
    private PostAuthView view;
    /**
     * Constructor
     */
    public ProductController(ProductModel m, PostAuthView v) {
        model = m;
        view = v;
        getProducts();
    }

    public void initView(){

    }
    public void getProducts(){
        ArrayList<ProductModel> list = service.getProductList();
        Object[][] row = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            row[i][0] = list.get(i).getId();
            row[i][1] = list.get(i).getName();
            row[i][2] = list.get(i).getPrice();
            row[i][3] = list.get(i).getCategory();
            row[i][4] = list.get(i).getDescription();

            view.setModel(row);
        }

    }
}
