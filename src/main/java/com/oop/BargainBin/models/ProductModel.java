/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.models;

/**
 * Model for Products
 */
public class ProductModel {
    private String name;
    private float price;
    private String description;
    private String category;
    private int cartCount;
    private int quantityAvailable;
    private int sold = 0;
    private int id;

    /**
     * Constructor
     * @param id id
     * @param name product name
     * @param price product price
     * @param description product description
     * @param category product category
     * @param cartCount cart count
     * @param quantityAvailable quantityAvailable
     */
    public ProductModel(int id, String name, float price, String description, String category, int quantityAvailable, int cartCount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.cartCount = cartCount;
        this.quantityAvailable = quantityAvailable;
        this.id = id;
    }
    public ProductModel(){}

    //Getters
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return category;
    }
    public int getCartCount(){return cartCount;}
    public int getQuantityAvailable(){return quantityAvailable;}
    public int getSold(){return sold;}
    public int getId(){
        return id;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setCartCount(int cartCount){
        this.cartCount = cartCount;
    }
    public void setSold(int sold){
        this.sold = sold;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setQuantityAvailable(int quantityAvailable){
        this.quantityAvailable = quantityAvailable;
    }
}