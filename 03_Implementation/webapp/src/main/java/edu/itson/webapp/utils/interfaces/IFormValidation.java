package edu.itson.webapp.utils.interfaces;

/**
 * Esta clase define las interfaces.
 */
public interface IFormValidation {
    /**
     * Aquí se hacen las validaciones de espacios en blanco.
     *
     * @param text el texto a validar
     * @return si está en blanco
     */
    boolean isBlankSpaces(String text);

    /**
     * Aquí se hace la validación del E-mail.
     *
     * @param email el email a validar
     * @return si es válido
     */
    boolean isValidEmail(String email);

    /**
     * Aquí se hace la validación del número de caracteres.
     *
     * @param text el texto a comprobar
     * @param limit el número de caracteres máximo
     * @return si está excedido
     */
    boolean hasExceededLengthLimit(String text, int limit);
}
