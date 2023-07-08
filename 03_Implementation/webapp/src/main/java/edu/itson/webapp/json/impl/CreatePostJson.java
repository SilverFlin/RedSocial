package edu.itson.webapp.json.impl;

/**
 *
 */
public final class CreatePostJson {

    /**
     * Titulo del post.
     */
    private String title;
    /**
     * Contenido del post.
     */
    private String content;

    /**
     * Tipo del post.
     */
    private boolean isAnchored;

    /**
     * Constructor vacio.
     */
    public CreatePostJson() {
    }

    /**
     * Obtiene el titulo del post.
     *
     * @return titulo del post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el contenido del post.
     *
     * @return contenido del post.
     */
    public String getContent() {
        return content;
    }

    /**
     * Obtiene si el post es anclado.
     *
     * @return tipo del post.
     */
    public boolean getIsAnchored() {
        return isAnchored;
    }

}
