package edu.itson.webapp.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public final class JsonConverter {

    private JsonConverter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Saca el JSON que viene en el request y lor regresa en formato de string.
     *
     * @param req
     * @return string representando al json.
     * @throws IOException
     */
    public static String getJsonFromRequest(
            final HttpServletRequest req
    ) throws IOException {
        BufferedReader reader = req.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        return jsonBuilder.toString();
    }

}
