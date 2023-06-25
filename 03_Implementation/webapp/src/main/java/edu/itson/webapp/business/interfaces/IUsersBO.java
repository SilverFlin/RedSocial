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
    Usuario register(Usuario usuario)
            throws BusinessException;

    /**
     * Intenta logear al ususario con las credenciales, regresa al ususario si
     * son validas o null de caso contrario.
     *
     * @param email
     * @param password
     * @return el usuario, si existe.
     * @throws BusinessException
     */
    Usuario login(String email, String password)
            throws BusinessException;

}
