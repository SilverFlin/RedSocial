package edu.itson.webapp.business.impl;

import edu.itson.dominio.ContenidoPost;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import exceptions.PersistenciaException;
import implementations.facade.FachadaPersistencia;
import interfaces.IPersistencia;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public final class PostsBO implements IPostBO {

    /**
     * Fachada de persistencia.
     */
    private final IPersistencia persistence;

    /**
     * Unico constructor, que instancía la fachada de persistencia.
     */
    public PostsBO() {
        this.persistence = new FachadaPersistencia();
    }

    @Override
    public List<Post> getPosts(final int amount) throws BusinessException {
        try {
            // TODO limitar / pagination

//            Post post = new Post(TipoPost.NORMAL);
//            post.setFechaHoraCreacion(LocalDateTime.now());
//            ContenidoPost contenido = new ContenidoPost();
//            contenido.setTexto("Asdads");
//            post.setContenido(contenido);
//            Usuario user = new Usuario();
//            user.setEmail("asdsadsad");
//            post.setCreador(user);
//            post.setTitulo("ASDAS");
//            this.persistence.agregarPost(post);

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

}
