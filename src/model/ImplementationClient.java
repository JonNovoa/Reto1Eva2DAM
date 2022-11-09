/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.Client;
import clases.Message;
import clases.Order;
import sockets.ClientSocket;

/**
 *
 * @author somor
 */
public class ImplementationClient implements ClientInterface {

    @Override
    public void registerClient(Client user) {
        Order ORDER = Order.UP;
        Message mensaje= new Message();
        mensaje.makeMessage(user, ORDER);

        ClientSocket socket= new ClientSocket(mensaje);

    }

    @Override
    public void closeSession() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Message logIn(Client user) {

        Order ORDER = Order.IN;
        Message mensaje= new Message();
        mensaje.makeMessage(user, ORDER);

       ClientSocket socket= new ClientSocket(mensaje);
        
       
       return mensaje;
        
        
        
       
    }
    
    
}
