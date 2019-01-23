/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class CLient {
    public static void main(String[] args) 
    {
        try (Socket socket=new Socket("localhost",5000)){
            
            socket.setSoTimeout(10000);
            BufferedReader echo=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho=new PrintWriter(socket.getOutputStream(),true);
            Scanner sc=new Scanner(System.in);
            String e,r;
            
            do
            {
                System.out.println("Enter string to be echoed");
                e=sc.nextLine();
                
                stringToEcho.println(e);
                if(!e.equals("exit"))
                {   
                    r=echo.readLine();
                    System.out.println(r);
                }
            }  while(!e.equals("exit"));
        }
         catch(SocketTimeoutException e) {
            System.out.println("The client timed out after 10s with no response");
        }
        catch (IOException ex) {
            Logger.getLogger(CLient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
