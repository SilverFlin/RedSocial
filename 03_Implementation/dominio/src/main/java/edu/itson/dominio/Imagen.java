package edu.itson.dominio;

import org.bson.types.Binary;

/**
 *
 */
public final class Imagen {

    /**
     * Nombre del archivo.
     */
    private String fileName;
    /**
     * Datos de la imagen.
     */
    private Binary imageData;

    /**
     * Constructor vacío.
     */
    public Imagen() {
        // No hace falta hacer nada.
    }

    /**
     * Obtiene el nombre de la imágen.
     *
     * @return el nombre de la imágen.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Establece el nombre de la imágen.
     *
     * @param fileName
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Obtiene los datos de la imágen.
     *
     * @return los datos de la imágen.
     */
    public Binary getImageData() {
        return imageData;
    }

    /**
     * Establece los datos de la imágen.
     *
     * @param imageData
     */
    public void setImageData(final Binary imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Image{" + "fileName=" + fileName + '}';
    }
}
