/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.AnswerEnumeration;
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
  public Message registerClient(Message mensaje) {

        Order ORDER = Order.UP;
        
        mensaje.setORDER(ORDER);

       ClientSocket socket= new ClientSocket(mensaje);
       mensaje=socket.vueltaMensaje();
       
       return mensaje;
        
        
        
       
    }

 

    @Override
    public Message logIn(Message mensaje) {

        Order ORDER = Order.IN;
        
        mensaje.setORDER(ORDER);

       ClientSocket socket= new ClientSocket(mensaje);
       mensaje=socket.vueltaMensaje();
       
       return mensaje;
        
        
        
       
    }
    
    
}
//