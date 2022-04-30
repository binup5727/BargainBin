package com.oop.BargainBin.services;

import com.oop.BargainBin.models.ProductModel;

import java.util.ArrayList;

/**
 * Product service class for the product related methods
 */
public class ProductService {

    /**
     * Get all products from the system
     * @return product list
     */
    public ArrayList<ProductModel> getProductList() {
        ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
        try {
            //replace with the database coding
            ProductModel model1 = new ProductModel(1, "Apple", 10, "this is an apple", "Fruit", 1);
            ProductModel model2 = new ProductModel(1, "Soap", 10, "this is a soap", "Bathing", 1);
            productList.add(model1);
            productList.add(model2);

        } catch (Exception ex) {
            return null;
        }
        return productList;
    }
}
