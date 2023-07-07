package edu.itson.webapp.auth.impl;

import edu.itson.webapp.paths.Constants;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public final class PathsDeclaration {

    private PathsDeclaration() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Lista de los paths publicos.
     */
    private static final List<String> PUBLIC_PATHS_LIST = List.of(
            Constants.LOGIN_ENDPOINT,
            Constants.AUTH_ENDPOINT,
            Constants.REGISTER_ENDPOINT,
            Constants.ASSETS_DIR,
            Constants.SCRIPTS_DIR
    );

    /**
     * Paths publicos, de forma inmutable.
     */
    public static final List<String> PUBLIC_PATHS
            = Collections.unmodifiableList(PUBLIC_PATHS_LIST);

}
