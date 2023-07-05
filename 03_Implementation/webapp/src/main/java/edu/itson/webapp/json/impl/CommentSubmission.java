package edu.itson.webapp.json.impl;

/**
 *
 */
public class CommentSubmission {

    /**
     * Contenido del comentario.
     */
    private String content;
    /**
     * Id del post donde se hizo el comentario.
     */
    private String postId;

    /**
     * Constructor vacio.
     */
    public CommentSubmission() {
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return contenido del comentario
     */
    public String getContent() {
        return content;
    }

    /**
     * Obtiene el Id del post donde se hizo el comentario.
     *
     * @return Id del post donde se hizo el comentario.
     */
    public String getPostId() {
        return postId;
    }

}
