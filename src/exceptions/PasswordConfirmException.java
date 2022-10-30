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
public class PasswordConfirmException extends Exception {

    /**
     * Creates a new instance of <code>PasswordConfirmException</code> without
     * detail message.
     */
    public PasswordConfirmException() {
    }

    /**
     * Constructs an instance of <code>PasswordConfirmException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordConfirmException(String msg) {
        super(msg);
    }
}
