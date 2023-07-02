package edu.itson.webapp.business.interfaces;

import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.exceptions.BusinessException;

public interface ICommentBO {

    /**
     * Crea un comentario y lo retorna.
     *
     * @param comment
     * @param post
     * @return el comentario creado.
     * @throws edu.itson.webapp.exceptions.BusinessException
     */
    Comentario createComment(Comentario comment, Post post)
            throws BusinessException;

    /**
     * Elimina un comentario y lo retorna.
     *
     * @param comment
     * @param user
     * @return el comentario eliminado.
     * @throws edu.itson.webapp.exceptions.BusinessException
     */
    Comentario deleteComment(Comentario comment, Usuario user)
            throws BusinessException;
}
