package edu.itson.webapp.utils.impl;

import edu.itson.dominio.Imagen;
import edu.itson.webapp.utils.interfaces.IimageConversor;
import java.io.IOException;
import java.io.InputStream;
import org.bson.types.Binary;

/**
 * Implementación de la interfaz IimageConversor que convierte imágenes
 * utilizando MongoDB.
 */
public final class MongoImageConversor implements IimageConversor {

    /**
     * Constructor por ausencia.
     */
    public MongoImageConversor() {

    }

    /**
     * Lee un inputstream y regresa un documento con su nombre e información.
     *
     * @param inputStream el flujo de entrada del archivo de imagen
     * @param fileName el nombre del archivo de imagen
     * @return el documento con la información de la imagen
     */
    @Override
    public Imagen createImageFromInputStream(
            final InputStream inputStream,
            final String fileName) {
        try {
            byte[] imageData = inputStream.readAllBytes();
            Imagen imagenDocument = new Imagen();
            imagenDocument.setImageData(new Binary(imageData));
            imagenDocument.setFileName(fileName);
            inputStream.close();
            return imagenDocument;
        } catch (IOException ex) {
            ex.getMessage();
        }
        return null;
    }
}
