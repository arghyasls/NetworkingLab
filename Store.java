/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Student
 */
public class Store {
    
    public static void main(String[] args) 
    {    
        Student s1=new Student();
        s1.setName("Sita");
        s1.setAge(23);
        Student s2=new Student();
        s2.setName("Gita");
        s2.setAge(24);
        String filename1 = "file1.txt"; 
        String filename2="file2.txt";  
        
        try
        {    
            
            FileOutputStream file1 = new FileOutputStream(filename1); 
            ObjectOutputStream out1 = new ObjectOutputStream(file1); 
              
           
            out1.writeObject(s1); 
              
            out1.close(); 
            file1.close(); 
              
            System.out.println("Student1 has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
  
        Student d1 = null; 
  
       
        try
        {    
            
            FileInputStream file1 = new FileInputStream(filename1); 
            ObjectInputStream in1 = new ObjectInputStream(file1); 
              
            
            d1 = (Student)in1.readObject(); 
              
            in1.close(); 
            file1.close(); 
              
            System.out.println("Student1 has been deserialized "); 
            System.out.println("Name = " + d1.getName()); 
            System.out.println("Age = " + d1.getAge()); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
         try
        {    
            
            FileOutputStream file2 = new FileOutputStream(filename2); 
            ObjectOutputStream out2 = new ObjectOutputStream(file2); 
              
           
            out2.writeObject(s2); 
              
            out2.close(); 
            file2.close(); 
              
            System.out.println("Student2 has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
  
        Student d2 = null; 
  
       
        try
        {    
            
            FileInputStream file2 = new FileInputStream(filename2); 
            ObjectInputStream in2 = new ObjectInputStream(file2); 
              
            
            d2 = (Student)in2.readObject(); 
              
            in2.close(); 
            file2.close(); 
              
            System.out.println("Student2 has been deserialized "); 
            System.out.println("Name = " + d2.getName()); 
            System.out.println("Age = " + d2.getAge()); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
    }
}
