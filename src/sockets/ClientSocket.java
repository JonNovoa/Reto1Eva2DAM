package sockets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import clases.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author somor
 */
public class ClientSocket {

    static final String HOST = ResourceBundle.getBundle("clases.connection").getString("host");
    static final Integer PUERTO = Integer.parseInt(ResourceBundle.getBundle("clases.connection").getString("puerto"));
    //private persona per = null;
    private Message mensajeSalida;
    public ClientSocket(Message mensaje)   {
        Socket skCliente = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        this.mensajeSalida=null;
        try {
            skCliente = new Socket(HOST, PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);

            //  skCliente = skServidor.accept();
            oos = new ObjectOutputStream(skCliente.getOutputStream());
            ois= new ObjectInputStream(skCliente.getInputStream());
           

           oos.writeObject(mensaje);
           this.mensajeSalida=(Message) ois.readObject();
           System.out.println(mensajeSalida.getRESPUESTA());
           
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
                ois.close();
                skCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        
    }
    public Message vueltaMensaje(){
    
        return this.mensajeSalida;
    
}

}
