/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.Client;
import clases.Message;

/**
 *
 * @author somor
 */
public class ImplementationClient implements ClientInterface {

    @Override
    public void registerClient(Client user) {

    }

    @Override
    public void closeSession() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void logIn(Client user) {
        OrderEnumeration ORDER = OrderEnumeration.IN;
        Message mensaje= new Message();
        mensaje.makeMessage(user, ORDER);
        
        
    }
    
    
}
