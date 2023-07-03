package edu.itson.webapp.business.interfaces;

import edu.itson.dominio.Image;
import edu.itson.dominio.User;
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
    User register(User usuario) throws BusinessException;

    /**
     * Intenta logear al ususario con las credenciales, regresa al ususario si
     * son validas o null de caso contrario.
     *
     * @param email
     * @param password
     * @return el usuario, si existe.
     * @throws BusinessException
     */
    User login(String email, String password) throws BusinessException;

    /**
     * Edita los campos del ususario.
     *
     * @param user
     * @return el usuario actualizado.
     * @throws BusinessException
     */
    User editUser(User user) throws BusinessException;

    /**
     * Obtiene el avatar de un usuario segun su ID.
     *
     * @param id
     * @return el avatar del usuario.
     * @throws BusinessException
     */
    Image getUserAvatar(String id) throws BusinessException;

}
