package interfaces;

import edu.itson.dominio.Comentario;
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
     */
    List<Comentario> buscarComentariosPost(Comentable objetivo)
            throws PersistenciaException;
}
