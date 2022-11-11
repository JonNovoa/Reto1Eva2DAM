/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author josue
 */
public class ValidateUserPass extends Exception {

    /**
     * Creates a new instance of <code>ValidateUserPass</code> without detail
     * message.
     */
    public ValidateUserPass() {
    }

    /**
     * Constructs an instance of <code>ValidateUserPass</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ValidateUserPass(String msg) {
        super(msg);
    }
}
