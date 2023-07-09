package interfaces;

import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import edu.itson.dominio.Usuario;
import exceptions.PersistenciaException;
import java.util.List;

/**
 *
 */
public interface IPersistencia {

    /**
     * Agrega un comentario a la base de datos y lo regresa con su id.
     *
     * @param comentario
     * @return Comentario con el id.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Comentario agregarComentario(Comentario comentario)
            throws PersistenciaException;

    /**
     * Eliminar un comentario de la base de datos y lo regresa si se borró.
     *
     * @param comentario
     * @return Comentario borrado.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Comentario eliminarComentario(Comentario comentario)
            throws PersistenciaException;

    /**
     * Actualiza el comentario en base al id registrado en el objeto.
     *
     * @param comentario
     * @return Comentario actualizado.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Comentario actualizarComentario(Comentario comentario)
            throws PersistenciaException;

    /**
     * Busca un comentario en base a un id.
     *
     * @param id
     * @return Comentario, si existe.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Comentario buscarComentarioPorId(String id) throws PersistenciaException;

    /**
     * Consulta todos los comentarios de la base de datos.
     *
     * @return Una lista con todos los comentarios.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    List<Comentario> buscarTodosLosComentarios() throws PersistenciaException;

    /**
     * Agrega un usuario a la base de datos y lo regresa con su id.
     *
     * @param usuario
     * @return Usuario con el id.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Usuario agregarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Eliminar un usuario de la base de datos y lo regresa si se borró.
     *
     * @param usuario
     * @return Usuario borrado.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Usuario eliminarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Actualiza el usuario en base al id registrado en el objeto.
     *
     * @param usuario
     * @return Usuario actualizado.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Usuario actualizarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Busca un usuario en base a un id.
     *
     * @param id
     * @return Usuario, si existe.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Usuario buscarUsuarioPorId(String id) throws PersistenciaException;

    /**
     * Busca un usuario en base a un email.
     *
     * @param email
     * @return Usuario, si existe.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Usuario buscarUsuarioPorEmail(String email) throws PersistenciaException;

    /**
     * Consulta todos los usuarios de la base de datos.
     *
     * @return Una lista con todos los comentarios.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    List<Usuario> buscarTodosLosUsuarios() throws PersistenciaException;

    /**
     * Agrega un post a la base de datos y lo regresa con su id.
     *
     * @param post
     * @return Post con el id.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Post agregarPost(Post post) throws PersistenciaException;

    /**
     * Eliminar un post de la base de datos y lo regresa si se borró.
     *
     * @param post
     * @return Post borrado.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Post eliminarPost(Post post) throws PersistenciaException;

    /**
     * Actualiza el post en base al id registrado en el objeto.
     *
     * @param post
     * @return Post actualizado.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Post actualizarPost(Post post) throws PersistenciaException;

    /**
     * Busca un post en base a un id.
     *
     * @param id
     * @return Post, si existe.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    Post buscarPostPorId(String id) throws PersistenciaException;

    /**
     * Consulta todos los posts de la base de datos.
     *
     * @return Una lista con todos los Posts.
     * @throws PersistenciaException Si ocurre un error en capa persistencia.
     */
    List<Post> buscarTodosLosPosts() throws PersistenciaException;

    /**
     * Obtiene todos los comentarios de un post.
     *
     * @param post
     * @return lista con los comentarios de un post.
     * @throws exceptions.PersistenciaException
     */
    List<Comentario> getPostComments(Post post)
            throws PersistenciaException;
}
