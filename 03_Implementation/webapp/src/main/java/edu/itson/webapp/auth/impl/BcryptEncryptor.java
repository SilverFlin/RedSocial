package edu.itson.webapp.auth.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;
import edu.itson.webapp.auth.interfaces.IEncryptor;

/**
 *
 */
public final class BcryptEncryptor implements IEncryptor {

    /**
     * Costo de encriptación.
     */
    private final int bcryptRounds;

    /**
     * Constructor por default, pone el costo al recomendado por Bcrypt.
     */
    public BcryptEncryptor() {
        final int defaultCost = 12;
        this.bcryptRounds = defaultCost;
    }

    /**
     * Constructor que establece el costo de encriptación.
     *
     * @param bcryptRounds
     */
    public BcryptEncryptor(final int bcryptRounds) {
        this.bcryptRounds = bcryptRounds;
    }

    @Override
    public String encryptPassword(final String password) {

        return BCrypt
                .withDefaults()
                .hashToString(this.bcryptRounds, password.toCharArray());
    }

    /**
     * Encripta una contraseña dada como array de caracteres y regresa el hashs.
     *
     * @param password
     * @return el hash generado.
     */
    public String encryptPassword(final char[] password) {
        return BCrypt
                .withDefaults()
                .hashToString(this.bcryptRounds, password);
    }

    @Override
    public boolean verifyPassword(
            final String password,
            final String hashedPassword
    ) {

        Result result = BCrypt
                .verifyer()
                .verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }

    /**
     * Obtiene el costo establecido de hashing.
     *
     * @return el costo de hashing.
     */
    public int getBcryptRounds() {
        return bcryptRounds;
    }

}
