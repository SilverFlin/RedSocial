package edu.itson.webapp.utils.interfaces;

/**
 * Esta interfaz define las operaciones de validación de formularios.
 */
public interface IFormValidator {

    /**
     * Realiza la validación de espacios en blanco en un texto.
     *
     * @param text el texto a validar
     * @return true si está en blanco, false en caso contrario
     */
    boolean hasBlankSpaces(String text);

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
    boolean isValidPassword(String password);

    /**
     * Realiza la validación de un número telefónico.
     *
     * @param phoneNumber
     * @return true si es válido, false en caso contrario.
     */
    boolean isValidPhoneNumber(String phoneNumber);

    /**
     * Realiza la validación de una fecha.
     *
     * @param date
     * @return true si es válido, false en caso contrario.
     */
    boolean isValidDate(String date);

    /**
     * Realiza una validacion de que no contenga caracteres especiales.
     *
     * @param text el texto a validar
     * @return el texto validado
     */
    boolean hasEspecialCharacters(String text);

    /**
     * Realiza una validacion de que es mayor de 18 años.
     *
     * @param date la fecha a comprobar
     * @return la fecha pasado ya 18 años
     */
    boolean isValidAge(String date);
}
