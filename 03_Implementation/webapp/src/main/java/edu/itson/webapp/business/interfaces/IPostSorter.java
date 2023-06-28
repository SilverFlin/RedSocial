package edu.itson.webapp.business.interfaces;

import edu.itson.dominio.Post;
import java.util.List;

/**
 *
 */
public interface IPostSorter {

    /**
     * Ordena los posts en base a su tipo y fecha de reacion.
     *
     * @param posts
     * @return Una lista con lost posts ordenados.
     */
    List<Post> sortPosts(List<Post> posts);
}
