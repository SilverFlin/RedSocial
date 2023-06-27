package edu.itson.webapp.auth.interfaces;

import edu.itson.webapp.auth.impl.PathsDeclaration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 */
public final class AuthRequestProcessor {

    private AuthRequestProcessor() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Obtiene el path del URI.
     *
     * @param req
     * @return el path del URI.
     */
    public static String getRequestedPath(final HttpServletRequest req) {
        String uri = req.getRequestURI();
        return uri.substring(req.getContextPath().length());
    }

    /**
     * Verifica si el path es privado.
     *
     * @param path
     * @return true, si el path es privado.
     */
    public static boolean isPrivatePath(final String path) {
        for (String publicPath : PathsDeclaration.PUBLIC_PATHS) {
            if (path.startsWith(publicPath)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si hay una session de usuario activa.
     *
     * @param req
     * @return true si se encuentra una session activa.
     */
    public static boolean isUserLoggedIn(final HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }
        return session.getAttribute("user") != null;
    }
}
