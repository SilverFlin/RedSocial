package edu.itson.webapp.utils.impl;

import edu.itson.dominio.Image;
import java.io.IOException;
import java.io.InputStream;
import org.bson.types.Binary;

/**
 *
 */
public final class MongoImageConversor {

    private MongoImageConversor() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Lee un inputstream y regresa un documento con su nombre e informacion.
     *
     * @param inputStream
     * @param fileName
     * @return El documento con la información de la imagen.
     * @throws IOException
     */
    public static Image createImageFromInputStream(
            final InputStream inputStream,
            final String fileName
    ) throws IOException {
        byte[] imageData = inputStream.readAllBytes();

        Image imagenDocument = new Image();
        imagenDocument.setImageData(new Binary(imageData));
        imagenDocument.setFileName(fileName);
        inputStream.close();
        return imagenDocument;

    }
}
