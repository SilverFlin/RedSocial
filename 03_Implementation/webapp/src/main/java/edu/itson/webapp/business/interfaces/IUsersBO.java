package edu.itson.webapp.business.interfaces;

import edu.itson.dominio.Usuario;
import edu.itson.webapp.exceptions.BusinessException;

/**
 *
 */
public interface IUsersBO {

    /**
     * Persiste el usuario registrado en la base de datos.
     *
     * @param usuario
     * @return el ususario registrado.
     * @throws BusinessException
     */
    Usuario register(Usuario usuario) throws BusinessException;

}
