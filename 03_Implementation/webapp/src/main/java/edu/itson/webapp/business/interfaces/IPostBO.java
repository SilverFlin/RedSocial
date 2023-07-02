package edu.itson.webapp.business.interfaces;

import edu.itson.dominio.Post;
import edu.itson.webapp.exceptions.BusinessException;
import java.util.List;

/**
 *
 */
public interface IPostBO {

    /**
     * Obtiene la cantidad especificada de posts.
     *
     * @param amount
     * @return los posts solicitados.
     * @throws BusinessException
     */
    List<Post> getPosts(int amount) throws BusinessException;

    /**
     * Crea un post y lo regresa.
     *
     * @param post
     * @return el post creado.
     * @throws BusinessException
     */
    Post createPost(Post post) throws BusinessException;

}
