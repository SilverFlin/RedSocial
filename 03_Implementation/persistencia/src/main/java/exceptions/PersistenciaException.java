package exceptions;

/**
 *
 */
public final class PersistenciaException extends Exception {

    /**
     * Constructor por omisión de la clase.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de la clase que recibe un parámetro.
     *
     * @param message mensaje recibido a almancenar
     */
    public PersistenciaException(final String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y la causa del lanzamiento de la
     * excepción.
     *
     * @param message mensaje recibido a almacenar
     * @param cause causa que ocasionó el lanzamiento de la excepción
     */
    public PersistenciaException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que solo recibe la causa del lanzamiento de la excepción.
     *
     * @param cause causa que lo ocasionó
     */
    public PersistenciaException(final Throwable cause) {
        super(cause);
    }
}
