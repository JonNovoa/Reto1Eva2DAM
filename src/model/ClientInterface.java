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
public interface ClientInterface {
    public Message registerClient(Message respuesta);
    public Message logIn(Message respuesta);

    //public void logIn(Message respuesta2);
    
}
