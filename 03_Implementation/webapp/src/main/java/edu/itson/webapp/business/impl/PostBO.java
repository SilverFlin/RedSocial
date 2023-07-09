package edu.itson.webapp.business.impl;

import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
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

            if (posts.isEmpty()) {
                return posts;
            }
            posts = PostSorter.sortPosts(posts);
            List<Post> orderedPosts = new LinkedList<>();

            int limit = amount;

            if (amount > posts.size()) {
                limit = posts.size();
            }

            for (int i = 0; i < limit; i++) {
                if (posts.get(i) == null) {
                    break;
                }

                orderedPosts.add(posts.get(i));
            }

            return orderedPosts;
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
    public Post editPost(
            final Usuario user,
            final Post post
    ) throws BusinessException {
        try {

            Usuario creator = post.getCreador();

            boolean usersExist
                    = creator.getId() != null
                    && user.getId() != null;
            if (!usersExist) {
                String errorMsg = "Users does not exist.";
                throw new BusinessException(errorMsg);

            }

            boolean isCreator = creator.getId().equals(user.getId());
            if (!isCreator) {
                String errorMsg = "User is not the creator.";
                throw new BusinessException(errorMsg);
            }

            return this.persistence.actualizarPost(post);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ edit post: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    @Override
    public Post deletePost(
            final String id,
            final Usuario user
    ) throws BusinessException {
        try {
            Post post = this.persistence.buscarPostPorId(id);
            if (post == null) {
                String errorMsg = "Error @ delete post: post does not exist.";
                throw new BusinessException(errorMsg);
            }

            if (!user.getTipoUsuario().equals(TipoUsuario.ADMIN)) {
                String errorMsg = "Error @ delete post: User is not Admin.";
                throw new BusinessException(errorMsg);
            }

            return this.persistence.eliminarPost(post);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ get post: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    @Override
    public List<Comentario> getPostComments(
            final Post post
    ) throws BusinessException {
        try {
            return this.persistence.getPostComments(post);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ get comments: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

}
