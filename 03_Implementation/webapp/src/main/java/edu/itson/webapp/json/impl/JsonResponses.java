package edu.itson.webapp.json.impl;

/**
 *
 */
public enum JsonResponses {

    /**
     * Status de success de la respuesta.
     */
    STATUS_SUCCESS("success"),
    /**
     * Status de fail de la respuesta.
     */
    STATUS_FAIL("fail"),
    /**
     * Status de error de la respuesta.
     */
    STATUS_ERROR("error");

    private final String status;

    /**
     * Constructor.
     *
     * @param status
     */
    JsonResponses(final String status) {
        this.status = status;
    }

    /**
     * Obtiene el status.
     *
     * @return el status.
     */
    public String getStatus() {
        return status;
    }

}
