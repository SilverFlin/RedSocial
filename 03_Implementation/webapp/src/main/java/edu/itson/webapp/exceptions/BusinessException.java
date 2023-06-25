package edu.itson.webapp.exceptions;

/**
 *
 */
public class BusinessException extends Exception {

    /**
     * Constructor vacio.
     */
    public BusinessException() {
    }

    /**
     * Constructor con el mensaje motivo de la excepción.
     *
     * @param message
     */
    public BusinessException(final String message) {
        super(message);
    }

    /**
     * Constructor con el mensaje motivo y la causa.
     *
     * @param message
     * @param cause
     */
    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea la excepción con la causa.
     *
     * @param cause
     */
    public BusinessException(final Throwable cause) {
        super(cause);
    }

    /**
     * Crea la excepción con los detalles, causa, si está suprimido o no, y si
     * puede escribir en el stack trace.
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public BusinessException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
