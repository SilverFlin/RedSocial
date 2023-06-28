package edu.itson.webapp.utils.impl;

import edu.itson.webapp.utils.interfaces.IFormValidation;
import java.util.regex.Pattern;

/**
 * Esta clase implementa la interfaz IFormValidation y proporciona métodos para
 * validar formularios.
 */
public final class FormValidation implements IFormValidation {

    /**
     * Este método se encarga de verificar los espacios en blanco de un campo.
     *
     * @param text el texto a validar
     * @return true si está en blanco, false en caso contrario
     */
    @Override
    public boolean isBlankSpaces(final String text) {
        if (text == null || text.trim().isEmpty()) {
            return true;
        }

        if (!text.equals(text.trim())) {
            return true;
        }
        return false;
    }

    /**
     * Este método se encarga de verificar un formato válido para el email.
     *
     * @param email el email a validar
     * @return true si es válido, false en caso contrario
     */
    @Override
    public boolean isValidEmail(final String email) {
        String emailRegex = "^(?=.{1,254}$)"
                + "([A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /**
     * Este método se encarga de asignarle un número máximo de caracteres a un
     * campo.
     *
     * @param text el texto a comprobar
     * @param limit el número de caracteres máximo
     * @return true si está excedido, false en caso contrario
     */
    @Override
    public boolean hasExceededLengthLimit(final String text, final int limit) {
        if (text == null) {
            return false;
        }

        return text.length() > limit;
    }

    /**
     * Este método se encarga de validar la contraseña.
     *
     * La contraseña debe de llevar por lo menos un numero un caracter,una
     * minuscula,una mayuscula menos 8
     *
     * @param password la contraseña a validar
     * @return true si es válida, false en caso contrario
     */
    @Override
    public boolean isPasswordValid(final String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }
}
