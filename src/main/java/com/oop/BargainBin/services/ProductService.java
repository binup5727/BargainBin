package com.oop.BargainBin.services;

import com.oop.BargainBin.models.ProductModel;
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
            //replace with the database coding
//            ProductModel model1 = new ProductModel(1, "Apple", 10, "this is an apple", "Fruit", 1);
//            ProductModel model2 = new ProductModel(1, "Soap", 10, "this is a soap", "Bathing", 1);
//            productList.add(model1);
//            productList.add(model2);
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
            Arrlst.get(i).add(Boolean.toString(mods.get(i).getSold()));
                
                
            
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
            mods.get(i).setSold(Boolean.getBoolean(Arrlst.get(i).get(5)));
        }
        return mods;
        
    }
}