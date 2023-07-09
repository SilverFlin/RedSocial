package edu.itson.webapp.utils.impl;

import junit.framework.TestCase;

/**
 * Pruebas unitarias para la clase FormValidation.
 */
public class FormValidationTest extends TestCase {

    /**
     * Aquí se hace el constructor del test.
     *
     * @param testName el nombre a probar
     */
    public FormValidationTest(final String testName) {
        super(testName);
    }

    /**
     * Test of isBlankSpaces method, of class FormValidation.
     */
    public void testIsBlankSpaces() {
        System.out.println("isBlankSpaces");
        final FormValidator instance = new FormValidator();

        final String attempt1 = "";
        final boolean result1 = instance.hasBlankSpaces(attempt1);
        final boolean expResult1 = true;
        assertEquals("Debe contener al menos 1 caracter",
                expResult1, result1);

        final String attempt2 = "     ";
        final boolean result2 = instance.hasBlankSpaces(attempt2);
        final boolean expResult2 = true;
        assertEquals("No debe tener espacios en blanco",
                expResult2, result2);

        final String attempt3 = "aa   ";
        final boolean result3 = instance.hasBlankSpaces(attempt3);
        final boolean expResult3 = true;
        assertEquals("Los caracteres no deben tener espacios alrededor",
                expResult3, result3);

        final String attempt4 = "     bb   ";
        final boolean result4 = instance.hasBlankSpaces(attempt4);
        final boolean expResult4 = true;
        assertEquals("Los caracteres no deben tener espacios alrededor",
                expResult4, result4);

        final String attempt5 = "aa";
        final boolean result5 = instance.hasBlankSpaces(attempt5);
        final boolean expResult5 = false;
        assertEquals("Correcto",
                expResult5, result5);

        final String attempt6 = null;
        final boolean expResult6 = true;
        final boolean result6 = instance.hasBlankSpaces(attempt6);
        assertEquals("No debe ser nulo",
                expResult6, result6);
    }

    /**
     * Test of isValidEmail method, of class FormValidation.
     */
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        final String email = "@hotmail.com";
        final FormValidator instance = new FormValidator();
        final boolean expResult = false;
        final boolean result = instance.isValidEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasExceededLengthLimit method, of class FormValidation.
     */
    public void testHasExceededLengthLimit() {
        System.out.println("hasExceededLengthLimit");
        final String text = "HOLa xd";
        final int limit = 2;
        final FormValidator instance = new FormValidator();
        final boolean expResult = true;
        final boolean result = instance.hasExceededLengthLimit(text, limit);
        assertEquals(expResult, result);
    }

    /**
     * Test of testHasEspecialCharacters method, of class FormValidation.
     */
    public void testHasEspecialCharacters() {
        System.out.println("HasEspecialCharacters");
        final String text = "Hola";
        final FormValidator instance = new FormValidator();
        final boolean expResult = false;
        final boolean result = instance.hasEspecialCharacters(text);
        assertEquals(expResult, result);
    }

}
