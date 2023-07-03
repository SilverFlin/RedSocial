package edu.itson.dominio;

/**
 *
 */
public class CommentContent {

    /**
     * Contenido de texto del comentario.
     */
    private String texto;
    /**
     * Imágen opcional del comentario.
     */
    private Image imagen;

    /**
     * Constructor vacío.
     */
    public CommentContent() {
        // No hace falta hacer nada.
    }

    /**
     * Obtiene el texto del comentario.
     *
     * @return texto del comentario
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto del comentario.
     *
     * @param texto
     */
    public void setTexto(final String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la imágen del comentario, si la hay.
     *
     * @return imágen del comentario, si al hay.
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Establece la imágen del comentario.
     *
     * @param imagen
     */
    public void setImagen(final Image imagen) {
        this.imagen = imagen;
    }

}
