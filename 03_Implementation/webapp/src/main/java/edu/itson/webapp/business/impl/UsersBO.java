package edu.itson.webapp.business.impl;

import edu.itson.dominio.Usuario;
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
    public Usuario register(final Usuario usuario) throws BusinessException {
        try {
            return persistence.agregarUsuario(usuario);
        } catch (PersistenciaException ex) {
            throw new BusinessException(
                    "Error @ Create Email: " + ex.getMessage()
            );

        }
    }

}
