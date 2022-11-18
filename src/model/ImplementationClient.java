/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.Message;
import clases.Order;
import exceptions.NotConnectedServer;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.ClientSocket;

/**
 *
 * @author somor
 */
public class ImplementationClient implements ClientInterface {
 private static final Logger logMsg = Logger.getLogger("");
    /*
    *Get the message and pick up the order to send it to the clientSocket,
    *and then we receive the updated message
     */
    @Override
    public Message registerClient(Message mensaje) {
        
     try {
         Order ORDER = Order.UP;
         mensaje.setORDER(ORDER);
         mensaje.setCerrar("Sigue");
         ClientSocket socket = new ClientSocket(mensaje);
         mensaje = socket.vueltaMensaje();
         
         
        
     } catch (ConnectException ex) {
        // Logger.getLogger(ImplementationClient.class.getName()).log(Level.SEVERE, null, ex);
      logMsg.log(Level.INFO, "login incorrecto ");
     }
      return mensaje;
    }

    @Override
    /*
    *Get the message and pick up the order to send it to the clientSocket,
    *and then we receive the updated message
     */
    public Message logIn(Message mensaje) throws ConnectException{
     try {
         Order ORDER = Order.IN;
         mensaje.setORDER(ORDER);
         mensaje.setCerrar("Sigue");
         ClientSocket socket;
         
         socket = new ClientSocket(mensaje);
         mensaje = socket.vueltaMensaje();
         
         
        
     } catch (ConnectException ex) {
        // Logger.getLogger(ImplementationClient.class.getName()).log(Level.SEVERE, null, ex);
     logMsg.log(Level.INFO, "login incorrecto ");
     }
      return mensaje;
    }
    
    /**
     *
     * @param mensaje
     */
    @Override
    public void closeApli(Message mensaje){
     try {
         mensaje.setCerrar("exit");
         
         ClientSocket socket = new ClientSocket(mensaje);
     } catch (ConnectException ex) {
        // Logger.getLogger(ImplementationClient.class.getName()).log(Level.SEVERE, null, ex);
         logMsg.log(Level.INFO, "login incorrecto ");
     }
       

        
    }
}
//
