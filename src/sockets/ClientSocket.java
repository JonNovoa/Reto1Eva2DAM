/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;


import clases.Message;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
    private Message mensaje;

    /**
     * Crea el socket con el mensaje que le va a mandar al servidor
     * @param mensaje 
     */
    public ClientSocket(Message mensaje) {
        try {
            Socket skCliente = new Socket(HOST, PUERTO);
            OutputStream auxx = skCliente.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(auxx);
            this.mensaje = mensaje;
            oos.writeObject(mensaje);
            
            skCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
