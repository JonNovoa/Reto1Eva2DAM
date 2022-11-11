/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author somor
 */
public class FullNameException extends Exception {

    /**
     * Creates a new instance of <code>FullNameException</code> without detail
     * message.
     */
    public FullNameException() {
        
       
    }

    /**
     * Constructs an instance of <code>FullNameException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    
    public FullNameException(String msg) {
        super("error");
    }
     
    
}
