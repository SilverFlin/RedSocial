package edu.itson.webapp.utils.impl;

import java.util.regex.Pattern;
import edu.itson.webapp.utils.interfaces.IFormValidator;

/**
 * Esta clase implementa la interfaz IFormValidation y proporciona métodos para
 * validar formularios.
 */
public final class FormValidator implements IFormValidator {

    /**
     * Este método se encarga de verificar los espacios en blanco de un campo.
     *
     * @param text el texto a validar
     * @return true si está en blanco, false en caso contrario
     */
    @Override
    public boolean hasBlankSpaces(final String text) {
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
        if (email == null) {
            return false;
        }
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
     * La contraseña debe de llevar por lo menos un numero un caracter, una
     * minuscula, una mayuscula, un caracter especial y contener entre 8 y 20
     * caracteres.
     *
     * @param password la contraseña a validar
     * @return true si es válida, false en caso contrario
     */
    @Override
    public boolean isValidPassword(final String password) {
        if (password == null) {
            return false;
        }
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }

    /**
     * Valida que el número telefónico sean puros dígitos con longitud de 10.
     *
     * @param phoneNumber
     * @return true, si el número es válido.
     */
    @Override
    public boolean isValidPhoneNumber(final String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        String phoneNumberRegex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        return pattern.matcher(phoneNumber).matches();
    }

    @Override
    public boolean isValidDate(final String date) {
        if (date == null) {
            return false;
        }
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(dateRegex);
        return pattern.matcher(date).matches();

    }
}
