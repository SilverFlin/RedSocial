package edu.itson.webapp.http;

/**
 *
 */
public enum HttpStatusCode {
    /**
     * Status OK.
     */
    OK(200),
    /**
     * Status Created 201.
     */
    CREATED(201),
    /**
     * Status Bad Request 400.
     */
    BAD_REQUEST(400),
    /**
     * Status Unauthorized 401.
     */
    UNAUTHORIZED(401),
    /**
     * Status Not Found 404.
     */
    NOT_FOUND(404),
    /**
     * Status Internal Server Error 500.
     */
    INTERNAL_SERVER_ERROR(500);

    /**
     * El valor del codigo.
     */
    private final int code;

    /**
     * Constructor.
     *
     * @param code
     */
    HttpStatusCode(final int code) {
        this.code = code;
    }

    /**
     * Obtiene el código del status.
     *
     * @return el codigo del status.
     */
    public int getCode() {
        return code;
    }
}
