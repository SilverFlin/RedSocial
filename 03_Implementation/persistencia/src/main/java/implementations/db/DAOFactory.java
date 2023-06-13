package implementations.db;

import implementations.daos.ComentariosDAO;
import implementations.daos.PostsDAO;
import implementations.daos.UsuariosDAO;
import interfaces.IComentariosDAO;
import interfaces.IPostsDAO;
import interfaces.IUsuariosDAO;

/**
 *
 */
public class DAOFactory {

    private DAOFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Método que regresa una instancia de ComentariosDAO.
     *
     * @return instancia de ComentariosDAO.
     */
    public static IComentariosDAO getComentariosDAO() {
        return ComentariosDAO.getInstance();
    }

    /**
     * Método que regresa una instancia de PostsDAO.
     *
     * @return instancia de PostsDAO.
     */
    public static IPostsDAO getPostsDAO() {
        return PostsDAO.getInstance();
    }

    /**
     * Método que regresa una instancia de UsuariosDAO.
     *
     * @return instancia de UsuariosDAO.
     */
    public static IUsuariosDAO getUsuariosDAO() {
        return UsuariosDAO.getInstance();
    }

}
