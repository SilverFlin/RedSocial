package edu.itson.webapp.utils.interfaces;

/**
 * Esta interfaz define las operaciones de validación de formularios.
 */
public interface IFormValidation {
    /**
     * Realiza la validación de espacios en blanco en un texto.
     *
     * @param text el texto a validar
     * @return true si está en blanco, false en caso contrario
     */
    boolean isBlankSpaces(String text);

    /**
     * Realiza la validación de un formato de correo electrónico válido.
     *
     * @param email el correo electrónico a validar
     * @return true si es válido, false en caso contrario
     */
    boolean isValidEmail(String email);

    /**
     * Realiza la validación del número de caracteres máximo en un texto.
     *
     * @param text el texto a comprobar
     * @param limit el número de caracteres máximo
     * @return true si está excedido, false en caso contrario
     */
    boolean hasExceededLengthLimit(String text, int limit);

    /**
     * Realiza la validación de una contraseña.
     *
     * @param password la contraseña a validar
     * @return true si es válida, false en caso contrario
     */
    boolean isPasswordValid(String password);
}
