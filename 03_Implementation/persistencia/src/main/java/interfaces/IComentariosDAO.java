package interfaces;

import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import exceptions.PersistenciaException;
import java.util.List;

/**
 *
 */
public interface IComentariosDAO extends IBaseDAO<Comentario> {

    /**
     * Método que permite obtener comentarios de un post.
     *
     * @param objetivo
     * @return una lista de comentarios
     * @throws exceptions.PersistenciaException
     */
    List<Comentario> buscarComentariosPost(Post objetivo)
            throws PersistenciaException;
}
