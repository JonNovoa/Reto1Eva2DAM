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

    public ClientSocket(Message mes) {
        
        System.out.println(mes.getOrden());
        System.out.println(mes.getCliente().getLogin());
        // ServerSocket skServidor = null;
        Socket skCliente = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            skCliente = new Socket(HOST, PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);

            //  skCliente = skServidor.accept();
            out = new ObjectOutputStream(skCliente.getOutputStream());
         
           // Message mensaje=(Message) in.readObject();

            out.writeObject(mes);

        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
                skCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
