package com.oop.BargainBin.models;

/**
 * Model for Products
 * @author Binup
 */
public class ProductModel {
    private int id;
    private String name;
    private float price;
    private String description;
    private String category;
    private int sold = 0;
    private int cartCount = 0;
    private int quantityAvailable;
    

    /**
     * Constructor
     * @param quantityAvailable quantityAvailable
   
     * @param id product Id
     * @param name product name
     * @param price product price
     * @param description product description
     * @param category product category
     * @param sold
     * @param sellerId product seller
     */
    public ProductModel(int id, String name, float price, String description, String category, int quantityAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.cartCount = 0;
        this.quantityAvailable = quantityAvailable;
    }
    /**
     * getters and setters for all field values
     */
    public ProductModel() {
    }


    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
        this.id = id;
    }

    public int getSold() {
        return sold;
    }

    public int getCartCount() {
        return cartCount;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }


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
