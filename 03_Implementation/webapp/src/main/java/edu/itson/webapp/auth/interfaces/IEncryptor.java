package edu.itson.webapp.auth.interfaces;

/**
 *
 */
public interface IEncryptor {

    /**
     * Encripta la password y regresa el hash.
     *
     * @param password
     * @return el hash generado.
     */
    String encryptPassword(String password);

    /**
     * Verifica una password con un hash.
     *
     * @param password
     * @param hashedPassword
     * @return true, si coinciden.
     */
    boolean verifyPassword(String password, String hashedPassword);
}
