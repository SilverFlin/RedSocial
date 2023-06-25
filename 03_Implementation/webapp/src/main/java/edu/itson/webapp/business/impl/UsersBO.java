package edu.itson.webapp.business.impl;

import edu.itson.dominio.Usuario;
import edu.itson.webapp.auth.impl.BcryptEncryptor;
import edu.itson.webapp.auth.interfaces.IEncryptor;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import exceptions.PersistenciaException;
import implementations.facade.FachadaPersistencia;
import interfaces.IPersistencia;

/**
 *
 */
public final class UsersBO implements IUsersBO {

    /**
     * Fachada de persistencia.
     */
    private final IPersistencia persistence;

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
            return this.persistence.agregarUsuario(user);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ Create Account: " + ex.getMessage();
            throw new BusinessException(errorMsg);

        }
    }

    @Override
    public Usuario login(
            final String email,
            final String password
    ) throws BusinessException {
        try {
            Usuario user = this.persistence.buscarUsuarioPorEmail(email);

            if (user == null) {
                return null;
            }
            if (!this.validateUserPassword(password, user.getPassword())) {
                return null;
            }

            return user;
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ login: " + ex.getMessage();
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

    private boolean validateUserPassword(
            final String password,
            final String hashedPassword
    ) {
        IEncryptor encriptor = new BcryptEncryptor();
        return encriptor.verifyPassword(password, hashedPassword);
    }

}
