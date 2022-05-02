/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.services;

import com.oop.BargainBin.models.AccountModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binup
 */
public class AccountService {
    /**
     * create service to use for account controller
     * saves and gets data from permanent file
     */
    public AccountService() {
        this.file = System.getProperty("user.dir") + "/src/Db/Accounts.txt";
        String dirS = System.getProperty("user.dir") + "/src/Db";
        File dir = new File(dirS);
        if(dir.mkdirs()){
            System.out.println("directory made");
        }else{
            System.out.println("Failed to make directory");
        }
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
    
    
    /**
     * 
     * @param acc uses account model acc to store into permanent file
     * if empty makes new array list to add acc to
     */
    public void registerUser(AccountModel acc){
        ArrayList<AccountModel> accounts = null;
        System.out.println(acc.username);
        try {
            accounts = SerializationService.deSerialize(new FileInputStream(this.file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (accounts == null){
            accounts = new ArrayList<>();
            
        }
        
        accounts.add(acc);
        
        try {
            SerializationService.Serialize(new FileOutputStream(this.file), accounts);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * 
     * @param username username string used to search arraylist of accounts
     * saved in file.
     * @return the account model of user if in file
     */
    public  AccountModel getUser(String username){
        ArrayList<AccountModel> accounts = null;
        System.out.println(this.file);
        try {
            accounts = SerializationService.deSerialize(new FileInputStream(this.file));
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (accounts == null){
            accounts = new ArrayList<>();            
        }
        for (AccountModel acc : accounts) {
            if (acc.username.equals(username)){
                return acc;
            }
        }
        
        
    
        return null;
    }
    
    /**
     * auxiliary function to get the last added accounts id
     * @return id 
     */
    public int getLastUser() {
        ArrayList<AccountModel> accounts = null;
        try {
            accounts = SerializationService.deSerialize(new FileInputStream(this.file));
            
        } catch (FileNotFoundException ex) {
            //System.out.println(accounts);
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            //System.out.println(accounts);
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (accounts == null){
            return 0;        
        }
        return accounts.get(accounts.size() - 1).id;
    }
    
    private String file;

    
    
}
