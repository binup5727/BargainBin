/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.controllers;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.observerPattern.ProductPublisher;
import com.oop.BargainBin.observerPattern.CartSubscriber;
import com.oop.BargainBin.services.ProductService;
import com.oop.BargainBin.singletonPattern.Cart;
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
        //Get the products available
        Object[][] productList = getProducts();

        //Get the items from the cart
        Object[][] cartList = convertCartListToObjects(Cart.getInstance().getCartItems());

        //Set the values to the model for the JTable
        view.setModelForCustomerProducts(productList, cartList);
        view.addToCartListener(new AddToCartListener());
        view.removeFromCartListener(new DeleteFromCartListener());
        view.openCartListener(new OpenCartListener());
        view.checkoutListener(new CheckoutListener());
        view.orderListener(new OrderListener());
    }

    public void initView(){

    }

    /**
     * Fetch the available products
     * @return product list
     */
    public Object[][] getProducts(){
        list = service.getProductList();
        return convertProductListToObjects(list);
    }

    /**
     * Convert product list to the object array
     * @param list product list
     * @return product records
     */
    public Object[][] convertProductListToObjects(ArrayList<ProductModel> list){
        //Arranging to an object multi dimentional array to populate in the table
        Object[][] row = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            row[i][0] = list.get(i).getName();
            row[i][1] = list.get(i).getPrice();
            row[i][2] = list.get(i).getCategory();
            row[i][3] = list.get(i).getDescription();
            row[i][4] = list.get(i).getQuantityAvailable();
        }
        return row;
    }

    /**
     * Convert cart list to the object array
     * @param list product list
     * @return product records
     */
    public Object[][] convertCartListToObjects(ArrayList<ProductModel> list){
        //Arranging to an object multi dimentional array to populate in the table
        Object[][] row = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            row[i][0] = list.get(i).getName();
            row[i][1] = list.get(i).getPrice();
            row[i][2] = list.get(i).getCategory();
            row[i][3] = list.get(i).getDescription();
            row[i][4] = list.get(i).getCartCount();
        }
        return row;
    }

    /**
     * Action listener to remove the item from the cart
     */
    public class CheckoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Resetting to clear the items and fill it again
            view.resetCheckoutPanel(convertCartListToObjects(Cart.getInstance().getCartItems()));
            //Open the checkout tab
            view.openCheckoutTab();
        }
    }

    /**
     * Action listener to remove the item from the cart
     */
    public class DeleteFromCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Fetch the selected product
            ProductModel selectedProduct = list.get(view.getCartSelectedRow());

            //Delete the item from the singleton cart object
            service.deleteFromCart(selectedProduct);

            //setting the cart items count in the customer view so that customer can view how many items are in the cart
            view.setCartCount(Cart.getInstance().getCartItemsCount(), Cart.getInstance().getCartAmount());

            //Reloading the cart panel
            view.resetCartPanel(convertCartListToObjects(Cart.getInstance().getCartItems()));
            view.openCartTab();
        }
    }

    /**
     * Action listener for opening the cart
     */
    public class OpenCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.openCartTab();
        }
    }

    /**
     * Action listener for ordering the items
     */
    public class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getCheckoutTableItemCount() > 0) {
                ArrayList<ProductModel> newList = new ArrayList<>();

                for (ProductModel model : list) {
                    ProductModel product = Cart.getInstance().getCartItems().stream().filter(p -> p.getName().equals(model.getName())).findAny().orElse(null);
                    if (product != null) {
                        //Calculating the remaining items available
                        model.setQuantityAvailable(model.getQuantityAvailable() - product.getCartCount());
                        model.setSold(product.getCartCount());
                    }
                    newList.add(model);
                }
                service.saveProductAll(newList);
                JOptionPane.showMessageDialog(null, "Order placed successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No items available for purchase");
            }
        }
    }

    /**
     * Action listener to add the items to the cart
     */
    public class AddToCartListener implements ActionListener {
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

                    //setting the cart items count in the customer view so that customer can view how many items are in the cart
                    view.setCartCount(Cart.getInstance().getCartItemsCount(), Cart.getInstance().getCartAmount());
                    view.resetCartPanel(convertCartListToObjects(Cart.getInstance().getCartItems()));

                    //When we reset the cart tab, if the checkout tab is visible, its going to the middle of the tabs. In order to bring it back we are initializing
                    //the checkout tab again
                    if(view.getTabCount()>2) {
                        //Resetting to clear the items and fill it again
                        view.resetCheckoutPanel(convertCartListToObjects(Cart.getInstance().getCartItems()));
                        //Open the checkout tab
                        view.openCheckoutTab();
                    }
                } else {
                    //If you try to add more counts than available for a product, then show message that you cannot add more
                    JOptionPane.showMessageDialog(null, "You can add only the available counts to the cart");
                }
//
//                view.addToCartListener(new CartListener());
//                view.setCartCount();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Some issue happened while trying to add the item to the cart");
            }
        }
    }
}
