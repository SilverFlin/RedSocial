package edu.itson.dominio;

/**
 *
 */
public class PostContent {

    /**
     * Contenido de texto del post.
     */
    private String texto;
    /**
     * Imágen opcional del comentario.
     */
    private Image imagen;

    /**
     * Constructor vacío.
     */
    public PostContent() {
        // No hace falta hacer nada.
    }

    /**
     * Obtiene el texto del post.
     *
     * @return texto del post
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto del post.
     *
     * @param texto
     */
    public void setTexto(final String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la imágen del post, si la hay.
     *
     * @return imágen del post, si al hay.
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Establece la imágen del post.
     *
     * @param imagen
     */
    public void setImagen(final Image imagen) {
        this.imagen = imagen;
    }

}
