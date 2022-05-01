/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.services;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.singletonPattern.Cart;

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
            ProductModel model1 = new ProductModel("Apple", 10, "this is an apple", "Fruit", 5, 0);
            ProductModel model2 = new ProductModel("Soap", 10, "this is a soap", "Bathing",  2, 0);
            productList.add(model1);
            productList.add(model2);

        } catch (Exception ex) {
            return null;
        }
        return productList;
    }

    /**
     * Check if the required quantity of product is available for adding to the cart
     * @param model product
     * @return available or not
     */
    public boolean isProductAvailableForCart(ProductModel model){
        try{
            //Using the selected product, we are checking if the product is available in the cart. If so, we fetch that product
            ProductModel product = Cart.getInstance().getCartItems().stream().filter(p->p.getName().equals(model.getName())).findAny().orElse(null);
            if(product != null) {
                //Checking if the cart count exceeds or reached the maximum available quantity
                if (product.getQuantityAvailable() <= product.getCartCount()) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception exception){
            return false;
        }
    }
}
