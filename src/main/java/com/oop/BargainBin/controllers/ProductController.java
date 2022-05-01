package com.oop.BargainBin.controllers;

import com.oop.BargainBin.models.ProductModel;
import com.oop.BargainBin.services.ProductService;
import com.oop.BargainBin.views.PostAuthView;
import com.oop.BargainBin.views.Product;
import com.oop.BargainBin.views.Revenue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Controller for product related activities
 */
public class ProductController {
    ProductService service = new ProductService();

    private ProductModel model;
    private PostAuthView view;
    private int accId;
    ArrayList<ProductModel> products;
    private Product Inventory;
    private Revenue rev;
    private DefaultTableModel table;
    private ProductModel pro;

    /**
     * Constructor
     * @param m model
     * @param v view
     */
    public ProductController(ProductModel m, PostAuthView v) {
        model = m;
        view = v;
        getProducts();
    }
    //seller constructor
    public ProductController(ProductModel m, PostAuthView v, Product Inventory, Revenue rev, int id) {
        model = m;
        view = v;
        accId = id;
        this.Inventory = Inventory;
        this.rev = rev;
        
        //get all products only keep those that match accId.
        ArrayList<ProductModel> temp = service.getProductList();
        products = new ArrayList<>();
        for (ProductModel productModel : temp) {
            if (productModel.getId() == this.accId){
                products.add(productModel);
                
            }
            
        }
        
        //revenue view calls to controller.
        rev.btnNewButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //String

                        }
        });
        
        
        //product view can call to controller.
        Inventory.addBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
                            String name = Inventory.textField_6.getText();
                            Float price = Float.parseFloat(Inventory.textField_7.getText());
                            String description = Inventory.textField_9.getText();
                            String category = Inventory.textField_8.getText();
                            addProduct(name, price, description, category);
			}
		});
        
        Inventory.removeBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
                                String name = Inventory.textField_6.getText();
                                
                                deleteProduct(name);
			}
		});
        
        
        table = new DefaultTableModel(getProductsSeller(), new String[] {
				"Product ID", "Name", "Price", "Description", "Category", "Sold"
			});
        this.Inventory.table_2.setModel(table);
        
    }
    
    public void addProduct(String Name, Float price, String description, String category){
        pro = new ProductModel(accId, Name, price, description, category);
        products.add(pro);
        service.saveProduct(pro);
        
        table = new DefaultTableModel(getProductsSeller(), new String[] {
				"Product ID", "Name", "Price", "Description", "Category", "Sold"
			});
        this.Inventory.table_2.setModel(table);
        
    }
    public void deleteProduct(String name){
        for (ProductModel product : products) {
            if(product.getName().equals(name)){
                System.out.println("error");
                products.remove(product);
            }
        }
        service.saveProduct(products);
        
        table = new DefaultTableModel(getProductsSeller(), new String[] {
				"Product ID", "Name", "Price", "Description", "Category", "Sold"
			});
        this.Inventory.table_2.setModel(table);
        
        
    }

    public void initView(){

    }

    /**
     * Fetch the saved products
     */
    public void getProducts(){
        ArrayList<ProductModel> list = service.getProductList();

        //Arranging to an object multi dimentional array to populate in the table
        Object[][] row = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getSold() == false){
                row[i][0] = list.get(i).getName();
                row[i][1] = list.get(i).getPrice();
                row[i][2] = list.get(i).getCategory();
                row[i][3] = list.get(i).getDescription();
                
            }
            //Set the values to the model for the JTable
            view.setModel(row);
        }

    }
    
    
    public Object[][] getProductsSeller(){
        ArrayList<ProductModel> list = products;

        //Arranging to an object multi dimentional array to populate in the table
        Object[][] row = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            row[i][0] = list.get(i).getId();
            row[i][1] = list.get(i).getName();
            row[i][2] = list.get(i).getPrice();
            row[i][3] = list.get(i).getCategory();
            row[i][4] = list.get(i).getDescription();
            row[i][5] = list.get(i).getSold();

            //Set the values to the model for the JTable
            
        }
        return row;

    }
}
