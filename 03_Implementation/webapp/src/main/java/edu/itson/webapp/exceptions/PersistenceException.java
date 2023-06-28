package edu.itson.webapp.exceptions;

/**
 *
 * @author luis-
 */
public class PersistenceException extends Exception {
    
     /**
     * Constructor por ausencia de la excepcion 
     */
    public PersistenceException() {
    }
    
    /**
     * Constructor del mensaje de la excepcion.
     * @param message 
     */  
    public PersistenceException(final String message) {
        super(message);
    }
    
    /**
     * Construsctor con el mensaje y la causa de la excepcion.
     * @param message
     * @param cause 
     */
    public PersistenceException(final String message,final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor con la causa de la excepcion.
     * @param cause 
     */ 
    public PersistenceException(final Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructor con el mensaje, causa y si esta disponible.
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace 
     */ 
    public PersistenceException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    } 
}
