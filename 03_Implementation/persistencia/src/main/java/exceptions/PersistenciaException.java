/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author MoonA
 */
public final class PersistenciaException extends Exception {

    /**
     * Constructor por omisión de la clase
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de la clase que recibe un parámetro
     *
     * @param message mensaje recibido a almancenar
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y la causa del lanzamiento de la
     * excepción
     *
     * @param message mensaje recibido a almacenar
     * @param cause causa que ocasionó el lanzamiento de la excepción
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que solo recibe la causa del lanzamiento de la excepción
     *
     * @param cause causa que lo ocasionó
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }
}
