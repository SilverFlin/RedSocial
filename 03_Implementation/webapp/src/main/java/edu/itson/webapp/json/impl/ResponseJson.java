package edu.itson.webapp.json.impl;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * Constructor vacio.
     */
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
     * Obtiene la informacion, opcional de la respuesta.
     *
     * @return obtiene la informacion de la respuesta.
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

    /**
     * Crea la respuesta en json.
     *
     * @param <T>
     * @param responseJson
     * @param response
     * @param message
     * @param data
     * @param res
     * @throws IOException
     */
    public static <T> void doJsonResponse(
            final ResponseJson<T> responseJson,
            final JsonResponses response,
            final String message,
            final T data,
            final HttpServletResponse res
    ) throws IOException {
        responseJson.setStatus(response);
        responseJson.setMessage(message);
        if (data != null) {
            responseJson.setData(data);
        }
        ResponseJson.processJsonResponse(res, responseJson);
    }

    /**
     * Procesa la respuesta de json.
     *
     * @param res
     * @param responseJson
     * @throws IOException
     */
    public static void processJsonResponse(
            final HttpServletResponse res,
            final ResponseJson responseJson
    ) throws IOException {
        res.setContentType("application/json");
        Gson gson = new Gson();
        String jsonTest = gson.toJson(responseJson);

        try (PrintWriter out = res.getWriter()) {
            out.println(jsonTest);
        }
    }
}
