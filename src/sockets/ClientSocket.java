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

    static final String HOST = "localhost";
    static final Integer PUERTO = 5000;
    //private persona per = null;
    private Message mensajeSalida;

    public ClientSocket(Message mensaje) {
        Socket skCliente = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        this.mensajeSalida = null;
        try {
//We make the connection
            skCliente = new Socket(HOST, PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
//Initialize the oos and ois for your use 
            oos = new ObjectOutputStream(skCliente.getOutputStream());
            ois = new ObjectInputStream(skCliente.getInputStream());

//send to the server the message
            oos.writeObject(mensaje);
            //Read Server Message
            this.mensajeSalida = (Message) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Close the Stream and the connection
                oos.close();
                ois.close();
                skCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Message vueltaMensaje() {
        //Returns message Output
        return this.mensajeSalida;

    }

}
