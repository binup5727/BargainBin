/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.BargainBin.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.WriteAbortedException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binup
 */
public class SerializationService {
    
    /**
     *
     * @param file
     * @param o
     * @throws java.io.IOException
     * add file stream object method will close the stream
     */
    public static <T> void Serialize(FileOutputStream file, T o) throws IOException{
        
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(o);
        out.close();
        file.close();

    }
    
    /**
     *
     * @param <T>
     * @param file
     * @return 
     * @throws java.io.IOException
     * add file stream object method will close the stream
     * @throws java.lang.ClassNotFoundException
     */
    
    public static <T> T deSerialize(FileInputStream file) throws IOException, ClassNotFoundException{
        
        ObjectInputStream in = new ObjectInputStream(file);
        T o = null;
        try{
            o = (T)in.readObject();
        }catch(WriteAbortedException e){
            return null;
            
        }
        
        
        in.close();
        file.close();
        
        
        return o;
        
        
        
        
    }

    
}
