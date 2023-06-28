package edu.itson.webapp.exceptions;

/**
 * Esta clase representa una excepción de Persistencie.
 */
public class PersistenceException extends Exception {

    /**
     * Constructor por defecto de la excepción PersistenceException.
     */
    public PersistenceException() {
    }

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message el mensaje de error
     */
    public PersistenceException(final String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y una causa.
     *
     * @param message el mensaje de error
     * @param cause   la causa de la excepción
     */
    public PersistenceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa de la excepción.
     *
     * @param cause la causa de la excepción
     */
    public PersistenceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que recibe un mensaje de error, una causa,
     * y dos indicadores para habilitar la supresión y rastreo de la pila.
     *
     * @param message            el mensaje de error
     * @param cause              la causa de la excepción
     * @param enableSuppression  indica si se habilita la supresión
     * @param writableStackTrace indica si se habilita el rastreo de la pila
     */
    public PersistenceException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
