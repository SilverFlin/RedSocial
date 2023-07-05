package edu.itson.webapp.json.impl;

/**
 *
 * @param <T>
 */
public class ResponseJson<T> {

    /**
     * Status de la respuesta.
     */
    private String status;

    /**
     * Mensaje de la respuesta.
     */
    private String message;

    /**
     * Informacion opcional de la respuesta.
     */
    private T data;

    public ResponseJson() {
    }

    /**
     * Obtiene el status de la respuesta.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece la version de texto del status.
     *
     * @param status
     */
    public void setStatus(final JsonResponses status) {
        this.status = status.getStatus();
    }

    /**
     * Obtiene el mensaje de la respuesta.
     *
     * @return mensaje del status.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de la respuesta.
     *
     * @param message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Obtiene la informacion, opcional de la resputsta
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * Establece la informacion de la respuesta.
     *
     * @param data
     */
    public void setData(final T data) {
        this.data = data;
    }

}
