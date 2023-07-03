package implementations.facade;

import implementations.db.DAOFactory;
import edu.itson.dominio.Comment;
import edu.itson.dominio.Post;
import edu.itson.dominio.User;
import exceptions.PersistenciaException;
import interfaces.IPersistencia;
import java.util.List;
import interfaces.IComentariosDAO;
import interfaces.IPostsDAO;
import interfaces.IUsuariosDAO;

/**
 *
 */
public final class FachadaPersistencia implements IPersistencia {

    /**
     * Instancia de ComentariosDAO.
     */
    private final IComentariosDAO comentariosDAO;
    /**
     * Instancia de UsuariosDAO.
     */
    private final IUsuariosDAO usuariosDAO;
    /**
     * Instancia de PostsDAO.
     */
    private final IPostsDAO postsDAO;

    /**
     * Constructor por defecto, inicializa los DAO.
     */
    public FachadaPersistencia() {
        this.comentariosDAO = DAOFactory.getComentariosDAO();
        this.usuariosDAO = DAOFactory.getUsuariosDAO();
        this.postsDAO = DAOFactory.getPostsDAO();
    }

    @Override
    public Comment agregarComentario(
            final Comment comentario
    ) throws PersistenciaException {

        try {
            return this.comentariosDAO.agregar(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comment eliminarComentario(
            final Comment comentario
    ) throws PersistenciaException {
        try {
            return this.comentariosDAO.eliminar(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comment actualizarComentario(
            final Comment comentario
    ) throws PersistenciaException {

        try {
            return this.comentariosDAO.actualizar(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comment buscarComentarioPorId(
            final String id
    ) throws PersistenciaException {
        try {
            return this.comentariosDAO.buscarPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Comment> buscarTodosLosComentarios()
            throws PersistenciaException {
        try {
            return this.comentariosDAO.buscarTodos();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public User agregarUsuario(
            final User usuario
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.agregar(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public User eliminarUsuario(
            final User usuario
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.eliminar(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public User actualizarUsuario(
            final User usuario
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.actualizar(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public User buscarUsuarioPorId(
            final String id
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.buscarPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public User buscarUsuarioPorEmail(
            final String email
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.buscarPorEmail(email);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<User> buscarTodosLosUsuarios() throws PersistenciaException {
        try {
            return this.usuariosDAO.buscarTodos();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post agregarPost(final Post post) throws PersistenciaException {
        try {
            return this.postsDAO.agregar(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post eliminarPost(final Post post) throws PersistenciaException {
        try {
            return this.postsDAO.eliminar(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post actualizarPost(final Post post) throws PersistenciaException {
        try {
            return this.postsDAO.actualizar(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post buscarPostPorId(final String id) throws PersistenciaException {
        try {
            return this.postsDAO.buscarPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Post> buscarTodosLosPosts() throws PersistenciaException {
        try {
            return this.postsDAO.buscarTodos();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

}
