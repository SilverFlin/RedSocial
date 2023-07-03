package edu.itson.webapp.business.impl;

import edu.itson.dominio.Post;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import exceptions.PersistenciaException;
import implementations.facade.FachadaPersistencia;
import interfaces.IPersistencia;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public final class PostBO implements IPostBO {

    /**
     * Fachada de persistencia.
     */
    private final IPersistencia persistence;

    /**
     * Unico constructor, que instancía la fachada de persistencia.
     */
    public PostBO() {
        this.persistence = new FachadaPersistencia();
    }

    @Override
    public List<Post> getPosts(final int amount) throws BusinessException {
        try {
            // TODO limitar / pagination

            List<Post> posts = this.persistence.buscarTodosLosPosts();
            List<Post> orderedPosts = new LinkedList<>();
            for (int i = 0; i < amount; i++) {
                if (posts.size() < amount || posts.get(i) == null) {
                    break;
                }

                orderedPosts.add(posts.get(i));
            }

            return PostSorter.sortPosts(orderedPosts);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ get posts: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    @Override
    public Post createPost(final Post post) throws BusinessException {
        if (post == null) {
            String errorMsg = "Error @ create post: Post is null";
            throw new BusinessException(errorMsg);
        }

        try {
            return this.persistence.agregarPost(post);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ create post: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    @Override
    public Post getPostById(final String id) throws BusinessException {
        try {
            return this.persistence.buscarPostPorId(id);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ get post: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    @Override
    public boolean postExists(final String id) throws BusinessException {
        return this.getPostById(id) != null;
    }

    @Override
    public Post editPost(final Post post) throws BusinessException {
        try {
            return this.persistence.actualizarPost(post);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ edit post: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

}
