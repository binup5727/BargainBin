package com.oop.BargainBin.singletonPattern;

import com.oop.BargainBin.models.ProductModel;

import java.util.ArrayList;

/**
 * @author Athul
 * Singleton object for the Cart
 */
public class Cart {

    ArrayList<ProductModel> products = new ArrayList<>();

    //create an object of Cart
    private static Cart cartObject = new Cart();

    /**
     * make the constructor private so that this class cannot be instantiated
     */
    private Cart(){}

    /**
     * Get the only object available
     * @return singleton Cart object
     */
    public static Cart getInstance(){
        return cartObject;
    }

    /**
     * Add the product to the cart
     * @param product
     * @return
     */
    public ArrayList<ProductModel> addToCart(ProductModel product){
        products.add(product);
        return products;
    }

    /**
     * Get the item counts in the cart
     * @return item count
     */
    public int getCartItemsCount(){
        int count = 0;
        for (ProductModel product: products) {
            count += product.getCartCount();
        }
        return count;
    }

    /**
     * Get the total amount in the cart
     * @return total amount in the cart
     */
    public float getCartAmount(){
        float cartAmount=0;
        for (ProductModel product: products) {
            cartAmount += product.getCartCount()* product.getPrice();
        }
        return cartAmount;
    }

    /**
     * Return the cart items
     * @return cart items
     */
    public ArrayList<ProductModel> getCartItems(){
        return products;
    }

    public void clearCart(){
        products.clear();
    }
}
