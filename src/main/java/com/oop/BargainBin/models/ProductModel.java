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
    private boolean sold;

    /**
     * Constructor
     * @param id product Id
     * @param name product name
     * @param price product price
     * @param description product description
     * @param category product category
     * @param sold
     * @param sellerId product seller
     */
    public ProductModel(int id, String name, float price, String description, String category, boolean sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.sold = sold;
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
    public boolean getSold(){
        return this.sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}