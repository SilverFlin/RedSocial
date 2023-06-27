package edu.itson.webapp.auth.impl;

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
            "/login",
            "/auth",
            "/register",
            "/assets"
    );

    /**
     * Paths publicos, de forma inmutable.
     */
    public static final List<String> PUBLIC_PATHS
            = Collections.unmodifiableList(PUBLIC_PATHS_LIST);

}
