/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author josue
 */
public class NotAceptSpace extends Exception {

    /**
     * Creates a new instance of <code>NotAceptSpace</code> without detail
     * message.
     */
    public NotAceptSpace() {
    }

    /**
     * Constructs an instance of <code>NotAceptSpace</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NotAceptSpace(String msg) {
        super(msg);
    }
}
