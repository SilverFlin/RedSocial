package implementations.facade;

import implementations.db.DAOFactory;
import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import edu.itson.dominio.Usuario;
import exceptions.PersistenciaException;
import interfaces.IPersistencia;
import java.util.List;
import interfaces.IComentariosDAO;
import interfaces.IPostsDAO;
import interfaces.IUsuariosDAO;

/**
 *
 */
public class FachadaPersistencia implements IPersistencia {

    IComentariosDAO comentariosDAO;
    IUsuariosDAO usuariosDAO;
    IPostsDAO postsDAO;

    /**
     * Constructor por defecto, inicializa los DAO.
     */
    public FachadaPersistencia() {
        this.comentariosDAO = DAOFactory.getComentariosDAO();
        this.usuariosDAO = DAOFactory.getUsuariosDAO();
        this.postsDAO = DAOFactory.getPostsDAO();
    }

    @Override
    public Comentario agregarComentario(
            final Comentario comentario
    ) throws PersistenciaException {

        try {
            return this.comentariosDAO.agregar(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) throws PersistenciaException {
        try {
            return this.comentariosDAO.eliminar(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comentario actualizarComentario(
            final Comentario comentario
    ) throws PersistenciaException {

        try {
            return this.comentariosDAO.actualizar(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comentario buscarComentarioPorId(
            final String id
    ) throws PersistenciaException {
        try {
            return this.comentariosDAO.buscarPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Comentario> buscarTodosLosComentarios()
            throws PersistenciaException {
        try {
            return this.comentariosDAO.buscarTodos();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario agregarUsuario(
            final Usuario usuario
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.agregar(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario eliminarUsuario(
            final Usuario usuario
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.eliminar(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario actualizarUsuario(
            final Usuario usuario
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.actualizar(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(
            final String id
    ) throws PersistenciaException {
        try {
            return this.usuariosDAO.buscarPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> buscarTodosLosUsuarios() throws PersistenciaException {
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
