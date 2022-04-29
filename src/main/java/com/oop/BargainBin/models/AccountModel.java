/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin;

import java.io.Serializable;

/**
 *
 * @author binup
 */
public class AccountModel implements Serializable{

    

    public AccountModel(LoginRegisterView loginView) {
        
        this.loginView = loginView;
        username = "";
        password = "";
        accountType = "";
        
    }
    
    
    
    
    
    
    
    
    LoginRegisterView loginView;
    public int id;
    public String username;
    public String password;
    public String accountType;

   
}
