/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author somor
 */
public class EmailException extends Exception{
    
    public EmailException(){
        
    }
    
    public EmailException(String msg){
        super(msg);
    }
    
}
