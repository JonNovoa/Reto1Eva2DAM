/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;


import clases.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author somor
 */
public class ClientSocket {
    
    static final String HOST = "localhost";
    static final int PUERTO = 5000;
     //private persona per = null;
     
     
     public ClientSocket(Message mes){
         // ServerSocket skServidor = null;
        Socket skCliente = null;
        try {
             skCliente = new Socket(HOST,PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
          //  skCliente = skServidor.accept();

            ObjectOutputStream out = new ObjectOutputStream(skCliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(skCliente.getInputStream());
            /**
            persona per = new persona();
            
            per.setFechaNacimiento(1990,1,1);
            per.setApellido("novoa");
            per.setNif("dafd");
            per.setNombre("dfd");
            out.writeObject(per);
            per =(persona)in.readObject();
            per.getDatos();
           **/
            out.writeObject(mes);
            
            
            skCliente.close();
            
            
        
     }  catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
     
}
