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
        final FormValidation instance = new FormValidation();

        final String attempt1 = "";
        final boolean result1 = instance.isBlankSpaces(attempt1);
        final boolean expResult1 = true;
        assertEquals("Debe contener al menos 1 caracter",
                expResult1, result1);

        final String attempt2 = "     ";
        final boolean result2 = instance.isBlankSpaces(attempt2);
        final boolean expResult2 = true;
        assertEquals("No debe tener espacios en blanco",
                expResult2, result2);

        final String attempt3 = "aa   ";
        final boolean result3 = instance.isBlankSpaces(attempt3);
        final boolean expResult3 = true;
        assertEquals("Los caracteres no deben tener espacios alrededor",
                expResult3, result3);

        final String attempt4 = "     bb   ";
        final boolean result4 = instance.isBlankSpaces(attempt4);
        final boolean expResult4 = true;
        assertEquals("Los caracteres no deben tener espacios alrededor",
                expResult4, result4);

        final String attempt5 = "aa";
        final boolean result5 = instance.isBlankSpaces(attempt5);
        final boolean expResult5 = false;
        assertEquals("Correcto",
                expResult5, result5);

        final String attempt6 = null;
        final boolean expResult6 = true;
        final boolean result6 = instance.isBlankSpaces(attempt6);
        assertEquals("No debe ser nulo",
                expResult6, result6);
    }

    /**
     * Test of isValidEmail method, of class FormValidation.
     */
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        final String email = "@hotmail.com";
        final FormValidation instance = new FormValidation();
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
        final FormValidation instance = new FormValidation();
        final boolean expResult = true;
        final boolean result = instance.hasExceededLengthLimit(text, limit);
        assertEquals(expResult, result);
    }
}
