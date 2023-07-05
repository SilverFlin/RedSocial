package edu.itson.webapp.servlets;

import edu.itson.webapp.http.HttpStatusCode;
import edu.itson.webapp.paths.Constants;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis-
 */
public final class Redirect {

    private Redirect() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Este metodo redirecciona a home.
     *
     * @param req la request
     * @param res la response
     * @throws IOException por si algo sale mal
     */
    public static void redirectHome(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws IOException {
        res.setStatus(HttpStatusCode.OK.getCode());
        res.sendRedirect(
                req.getContextPath() + Constants.HOME_ENDPOINT
        );
    }

    /**
     * Este metodo redirecciona a home, con un codigo http personalizado.
     *
     * @param req la request
     * @param res la response
     * @param statusCode
     * @throws IOException por si algo sale mal
     */
    public static void redirectHome(
            final HttpServletRequest req,
            final HttpServletResponse res,
            final HttpStatusCode statusCode
    ) throws IOException {
        res.setStatus(statusCode.getCode());
        res.sendRedirect(req.getContextPath() + Constants.HOME_ENDPOINT);
    }

    /**
     * Este metodo manda a la pagina de error.
     *
     * @param req la request
     * @param res la response
     * @param httpStatusCode el status
     * @param servletContext el context del servlet
     * @throws ServletException por si algo sale mal
     * @throws IOException por si algo sale mal
     */
    public static void sendToHttpErrorPage(
            final HttpServletRequest req,
            final HttpServletResponse res,
            final HttpStatusCode httpStatusCode,
            final ServletContext servletContext
    ) throws ServletException, IOException {
        res.setStatus(httpStatusCode.getCode());
        req.setAttribute("errorCode", httpStatusCode.getCode());
        servletContext
                .getRequestDispatcher(Constants.HTTP_ERROR_PAGE)
                .forward(req, res);
    }

    /**
     * Este metodo manda a la pagina de error del server.
     *
     * @param req la request
     * @param res la response
     * @param servletContext el contexto del servlet
     * @throws ServletException por si algo sale mal
     * @throws IOException por si algo sale mal
     */
    public static void sendToServerErrorPage(
            final HttpServletRequest req,
            final HttpServletResponse res,
            final ServletContext servletContext
    ) throws ServletException, IOException {
        res.setStatus(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode());
        servletContext
                .getRequestDispatcher(Constants.SERVER_ERROR_PAGE)
                .forward(req, res);
    }

    /**
     * Este metodo redirecciona a la pagina de register.
     *
     * @param req la request
     * @param res la response
     * @param servletContext el contexto del server
     * @throws ServletException por si algo sale mal
     * @throws IOException por si algo sale mal
     */
    public static void sendToRegisterPage(
            final HttpServletRequest req,
            final HttpServletResponse res,
            final ServletContext servletContext
    ) throws ServletException, IOException {
        res.setStatus(HttpStatusCode.BAD_REQUEST.getCode());
        servletContext
                .getRequestDispatcher(Constants.REGISTER_USER_PAGE)
                .forward(req, res);
    }

}
