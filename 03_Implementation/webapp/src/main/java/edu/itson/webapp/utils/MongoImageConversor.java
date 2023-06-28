package edu.itson.webapp.utils;

import edu.itson.dominio.Imagen;
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
    public static Imagen crearImagen(
            final InputStream inputStream,
            final String fileName
    ) throws IOException {
        byte[] imageData = inputStream.readAllBytes();

        Imagen imagenDocument = new Imagen();
        imagenDocument.setImageData(new Binary(imageData));
        imagenDocument.setFileName(fileName);
        inputStream.close();
        return imagenDocument;

    }
}
