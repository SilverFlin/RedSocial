package edu.itson.webapp.utils.interfaces;

import edu.itson.dominio.Imagen;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author luis-
 */
public interface IimageConversor {

    /**
     * Realiza la conversion de imagen.
     *
     * @param inputStream la imagen
     * @param fileName el nombre de la imagen
     * @return la imagen convertida
     */
    Imagen createImageFromInputStream(
            InputStream inputStream, String fileName) throws IOException;

}
