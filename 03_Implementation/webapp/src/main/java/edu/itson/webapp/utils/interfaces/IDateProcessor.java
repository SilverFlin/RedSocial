package edu.itson.webapp.utils.interfaces;

/**
 *
 * @param <T>
 */
public interface IDateProcessor<T> {

    /**
     * Convierte un string a una fecha.
     *
     * @param date
     * @return La fecha, o null si no es valida.
     */
    T convertStringToDate(String date);

    /**
     * Convierte una fecha a string.
     *
     * @param date
     * @return La fecha formateada.
     */
    String convertDateToString(T date);

}
