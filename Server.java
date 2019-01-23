/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author Student
 */import java.net.ServerSocket;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Server {
    public static void main(String[] args)
    {
        try(ServerSocket serverSocket=new ServerSocket(5000)){
            Socket socket=serverSocket.accept();
            System.out.println("Client Connected");
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
            while(true)
            {
                String echoString=input.readLine();
                String ans="";
                  if(echoString.equalsIgnoreCase("time"))
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();  
                    ans= formatter.format(date);
                    
                }
                if(echoString.equalsIgnoreCase("ip"))
                {
                    String ip=(((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress()).toString().replace("/","");
                    ans=ip;
                    
                }
                if (echoString.equalsIgnoreCase("exit"))
                    break;
                output.println("Echo from Server " + ans);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
