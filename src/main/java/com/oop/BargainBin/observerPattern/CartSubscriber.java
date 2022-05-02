package com.oop.BargainBin.observerPattern;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.singletonPattern.Cart;

/**
 * Cart subscriber for add the items to the cart
 */
public class CartSubscriber implements Observer{

    //Creating the singleton cart object
    Cart cart = Cart.getInstance();

    /**
     * Updating the cart
     * @param model product passed
     */
    @Override
    public void update(ProductModel model) {
        //Using the selected product, we are checking if the product is available in the cart. If so, we fetch that product
        ProductModel product = cart.getCartItems().stream().filter(p -> p.getName().equals(model.getName())).findAny().orElse(null);

        //If the same product is available in the cart, then increment the quantity needed
        if (product != null) {
            int cartCount = product.getCartCount();
            model.setCartCount(cartCount + 1);
            //Removing the item, so that a new entry for the same produt with the updated count can be added.
            cart.getCartItems().removeIf(p -> p.getName() == model.getName());
        }
        else{
            //If the product is not available in the cart, then set the cart count for the product to 1
            model.setCartCount(1);
        }
        //Adding the product to the cart with update the count
        cart.addToCart(model);
    }
}
