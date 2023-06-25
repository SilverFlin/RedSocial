package edu.itson.webapp.business.impl;

import edu.itson.dominio.Usuario;
import edu.itson.webapp.auth.impl.BcryptEncryptor;
import edu.itson.webapp.auth.interfaces.IEncryptor;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import exceptions.PersistenciaException;
import implementations.facade.FachadaPersistencia;

/**
 *
 */
public final class UsersBO implements IUsersBO {

    /**
     * Fachada de persistencia.
     */
    private final FachadaPersistencia persistence;

    /**
     * Unico constructor, que instancía la fachada de persistencia.
     */
    public UsersBO() {
        this.persistence = new FachadaPersistencia();
    }

    @Override
    public Usuario register(final Usuario user) throws BusinessException {
        try {
            this.encryptUserPassword(user);
            return persistence.agregarUsuario(user);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ Create Email: " + ex.getMessage();
            throw new BusinessException(errorMsg);

        }
    }

    /**
     * Encripta la password del usuario y se la asigna.
     *
     * @param user
     */
    private void encryptUserPassword(final Usuario user) {
        IEncryptor encriptor = new BcryptEncryptor();
        String hashedPassword = encriptor.encryptPassword(user.getPassword());
        user.setPassword(hashedPassword);
    }

}
