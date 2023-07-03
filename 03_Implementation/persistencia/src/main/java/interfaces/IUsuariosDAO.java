package interfaces;

import edu.itson.dominio.User;
import exceptions.PersistenciaException;

/**
 *
 */
public interface IUsuariosDAO extends IBaseDAO<User> {

    /**
     * Busca al usuario por email.
     *
     * @param email
     * @return La entidad, si se encuentra.
     * @throws PersistenciaException
     */
    User buscarPorEmail(String email) throws PersistenciaException;
}
