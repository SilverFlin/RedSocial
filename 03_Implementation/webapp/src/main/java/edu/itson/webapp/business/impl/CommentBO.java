package edu.itson.webapp.business.impl;

import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.exceptions.BusinessException;
import implementations.facade.FachadaPersistencia;
import interfaces.IPersistencia;
import edu.itson.webapp.business.interfaces.ICommentBO;
import exceptions.PersistenciaException;

public class CommentBO implements ICommentBO {

    /**
     * Fachada de persistencia.
     */
    private final IPersistencia persistence;

    /**
     * Único constructor que instancía la fachada de persistencia.
     */
    public CommentBO() {
        this.persistence = new FachadaPersistencia();
    }

    /**
     * Método que permite la creación de un comentario.
     *
     * @param comment
     * @param post
     * @return comentario creado.
     * @throws BusinessException
     */
    @Override
    public Comentario createComment(final Comentario comment, final Post post)
            throws BusinessException {
        if (comment == null) {
            String errorMsg = "Error @ create comment: Comment is NULL";
            throw new BusinessException(errorMsg);
        }
        if (comment.getCreador().getTipoUsuario() != TipoUsuario.NORMAL) {
            String errorMsg
                    = "Error @ create comment: User is not of NORMAL type";
            throw new BusinessException(errorMsg);
        }
        if (post.getTipoPost() != TipoPost.NORMAL) {
            String errorMsg
                    = "Error @ create comment: Post is not of NORMAL type";
            throw new BusinessException(errorMsg);
        }
        try {
            return this.persistence.agregarComentario(comment);
        } catch (PersistenciaException e) {
            String errorMsg = "Error @ create post: " + e.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    /**
     * Método que permite la eliminación de un comentario.
     *
     * @param comment
     * @return comentario eliminado.
     * @throws BusinessException
     */
    @Override
    public Comentario deleteComment(
            final Comentario comment, final Usuario user)
            throws BusinessException {
        if (comment == null) {
            String errorMsg = "Error @ delete comment: Comment is null";
            throw new BusinessException(errorMsg);
        }
        if (user.getTipoUsuario() != TipoUsuario.ADMIN) {
            String errorMsg
                    = "Error @ delete comment: User is not of ADMIN type";
            throw new BusinessException(errorMsg);
        }
        try {
            return this.persistence.eliminarComentario(comment);
        } catch (PersistenciaException e) {
            String errorMsg = "Error @ delete post: " + e.getMessage();
            throw new BusinessException(errorMsg);
        }
    }
}
