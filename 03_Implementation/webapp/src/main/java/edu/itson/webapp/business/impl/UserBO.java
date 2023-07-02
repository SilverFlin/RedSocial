package edu.itson.webapp.business.impl;

import edu.itson.dominio.Imagen;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.auth.impl.BcryptEncryptor;
import edu.itson.webapp.auth.interfaces.IEncryptor;
import edu.itson.webapp.exceptions.BusinessException;
import exceptions.PersistenciaException;
import implementations.facade.FachadaPersistencia;
import interfaces.IPersistencia;
import edu.itson.webapp.business.interfaces.IUserBO;

/**
 *
 */
public final class UserBO implements IUserBO {

    /**
     * Fachada de persistencia.
     */
    private final IPersistencia persistence;

    /**
     * Unico constructor, que instancía la fachada de persistencia.
     */
    public UserBO() {
        this.persistence = new FachadaPersistencia();
    }

    @Override
    public Usuario register(final Usuario user) throws BusinessException {
        try {
            if (this.validateUserEmail(user)) {
                throw new BusinessException("Email has already used");
            }
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

    @Override
    public Usuario editUser(final Usuario user) throws BusinessException {
        if (user == null) {
            String errorMsg = "Error @ edit User, user is null";
            throw new BusinessException(errorMsg);
        }

        if (user.getId() == null) {
            String errorMsg = "Error @ edit User, id not found";
            throw new BusinessException(errorMsg);
        }

        try {
            return this.persistence.actualizarUsuario(user);
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ editUser: " + ex.getMessage();
            throw new BusinessException(errorMsg);
        }
    }

    @Override
    public Imagen getUserAvatar(final String id) throws BusinessException {
        if (id == null) {
            String errorMsg = "Error @ get user avatar, id is null";
            throw new BusinessException(errorMsg);
        }
        try {
            return this.persistence.buscarUsuarioPorId(id).getAvatar();
        } catch (PersistenciaException ex) {
            String errorMsg = "Error @ get user avatar, user not found";
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

    private boolean validateUserEmail(final Usuario user)
            throws BusinessException {
        try {
            Usuario userObtained = this.persistence
                    .buscarUsuarioPorEmail(user.getEmail());
            return userObtained != null;
        } catch (PersistenciaException e) {
            throw new BusinessException("Error @ validate user email");
        }
    }
}
