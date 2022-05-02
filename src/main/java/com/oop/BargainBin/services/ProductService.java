package com.oop.BargainBin.services;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.singletonPattern.Cart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;

/**
 * Product service class for the product related methods
 */
public class ProductService {

    /**
     * Get all products from the system
     * @return product list
     */
    String file;
    public ProductService(){
        
    this.file = System.getProperty("user.dir") + "/src/Db/Products.txt";
    try {
      File f = new File(this.file);
      if (f.createNewFile()) {
        System.out.println("File created: " + f.getName());
        this.file = f.getPath(); 
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
        }


    
        
    }
    public ArrayList<ProductModel> getProductList() {
        ArrayList<ProductModel> productList = new ArrayList<>();
        try {
            
            
            productList = toModel(SerializationService.deSerialize(new FileInputStream(file)));
            
        } catch (Exception ex) {
            return productList;
        }
        return productList;
    }
    
    public void saveProduct(ProductModel pro){
        
        
        try {
            ArrayList<ProductModel> productLst = getProductList();
            productLst.add(pro);
            SerializationService.Serialize(new FileOutputStream(file), toArray(productLst));
            
            
        } catch (Exception ex) {
            System.out.println("empty file");
            
        }
           
    }
    public void saveProductAll(ArrayList<ProductModel> pro){
        
        
        try {
            ArrayList<ArrayList<String>> productLst = toArray(pro);
            
            SerializationService.Serialize(new FileOutputStream(file), productLst);
            
            
        } catch (Exception ex) {
            System.out.println("empty file");
            
        }
        
        
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

    /**
     * Delete the selected product from the cart
     * @param model product model
     */
    public void deleteFromCart(ProductModel model){
        Cart.getInstance().getCartItems().removeIf(p -> p.getName() == model.getName());
    }

//    public void deleteProduct(){
//        
//    }
    
    public ArrayList<ArrayList<String>> toArray(ArrayList<ProductModel> mods){
        ArrayList<ArrayList<String>> Arrlst = new ArrayList<>();
        for (int i = 0; i < mods.size(); i++) {
            Arrlst.add(new ArrayList<>());
            
            Arrlst.get(i).add(Integer.toString(mods.get(i).getId()));
            Arrlst.get(i).add(mods.get(i).getName());
            Arrlst.get(i).add(Float.toString(mods.get(i).getPrice()));
            Arrlst.get(i).add(mods.get(i).getDescription());
            Arrlst.get(i).add(mods.get(i).getCategory());
            Arrlst.get(i).add(Integer.toString(mods.get(i).getSold()));
            Arrlst.get(i).add(Integer.toString(mods.get(i).getQuantityAvailable()));
                
                
            
        }
        
        
        
        return Arrlst;
        
        
        
    }
    
    public ArrayList<ProductModel> toModel(ArrayList<ArrayList<String>> Arrlst){
        ArrayList<ProductModel> mods = new ArrayList<>();
        for (int i = 0; i < Arrlst.size(); i++) {
            mods.add(new ProductModel());
            mods.get(i).setId(Integer.parseInt(Arrlst.get(i).get(0)));
            mods.get(i).setName(Arrlst.get(i).get(1));
            mods.get(i).setPrice(Float.parseFloat(Arrlst.get(i).get(2)));
            mods.get(i).setDescription(Arrlst.get(i).get(3));
            mods.get(i).setCategory(Arrlst.get(i).get(4));
            mods.get(i).setSold(Integer.parseInt(Arrlst.get(i).get(5)));
            mods.get(i).setQuantityAvailable(Integer.parseInt(Arrlst.get(i).get(6)));
        }
        return mods;
        
    }
}
