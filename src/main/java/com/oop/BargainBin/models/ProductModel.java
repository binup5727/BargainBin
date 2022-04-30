/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.models;

/**
 * Model for Products
 */
public class ProductModel {
    private int id;
    private String name;
    private float price;
    private String description;
    private String category;
    private int sellerId;

    /**
     * Constructor
     * @param id product Id
     * @param name product name
     * @param price product price
     * @param description product description
     * @param category product category
     * @param sellerId product seller
     */
    public ProductModel(int id, String name, float price, String description, String category, int sellerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.sellerId = sellerId;
    }
    public ProductModel(){}

    public int getId(){
        return id;
    }
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
    public int getSellerId(){
        return sellerId;
    }
}