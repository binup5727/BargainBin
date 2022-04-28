/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

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

    public AccountService() {
        this.file = "/temp/Accounts"; 
    }
    
    
    
    public void registerUser(AccountModel acc){
        ArrayList<AccountModel> accounts = null;
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
    

    
    public  AccountModel getUser(String username){
        ArrayList<AccountModel> accounts = null;
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
            if (acc.username == username){
                return acc;
            }
        }
        
        
    
        return null;
    }
    
    private final String file;
    
}
