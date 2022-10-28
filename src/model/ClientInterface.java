/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.Client;

/**
 *
 * @author somor
 */
public interface ClientInterface {
    public void registerClient(Client user);
    public void closeSession();
    public void logIn(Client user);
    
}
