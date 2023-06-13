package interfaces;

import exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @param <T>
 */
public interface IBaseDAO<T> {

    /**
     * Persiste el parámetro en la base de datos.
     *
     * @param t la entidad guardada.
     * @return
     * @throws PersistenciaException
     */
    T agregar(T t) throws PersistenciaException;

    /**
     * Elimina la entidad de la base de datos.
     *
     * @param t
     * @return la entidad eliminada.
     * @throws PersistenciaException
     */
    T eliminar(T t) throws PersistenciaException;

    /**
     * Actualiza una entidad.
     *
     * @param t
     * @return la entidad actualizada.
     * @throws PersistenciaException
     */
    T actualizar(T t) throws PersistenciaException;

    /**
     * Busca por ID una entidad.
     *
     * @param id
     * @return La entidad, si se encuentra.
     * @throws PersistenciaException
     */
    T buscarPorId(String id) throws PersistenciaException;

    /**
     * Regresa una lista con todas las entidades.
     *
     * @return Lista con todas las entidades.
     * @throws PersistenciaException
     */
    List<T> buscarTodos() throws PersistenciaException;

}
