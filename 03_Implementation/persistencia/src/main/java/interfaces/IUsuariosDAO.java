package interfaces;

import edu.itson.dominio.Usuario;
import exceptions.PersistenciaException;

/**
 *
 */
public interface IUsuariosDAO extends IBaseDAO<Usuario> {

    /**
     * Busca al usuario por email.
     *
     * @param email
     * @return La entidad, si se encuentra.
     * @throws PersistenciaException
     */
    Usuario buscarPorEmail(String email) throws PersistenciaException;
}
