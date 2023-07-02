package edu.itson.webapp.utils.impl;

import edu.itson.webapp.utils.interfaces.IDateProcessor;
import edu.itson.webapp.utils.interfaces.IFormValidator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public final class LocalDateTimeProcessor
        implements IDateProcessor<LocalDateTime> {

    @Override
    public LocalDateTime convertStringToDate(final String date) {
        IFormValidator validator = new FormValidator();
        if (!validator.isValidDate(date)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.atStartOfDay();

    }

    @Override
    public String convertDateToString(final LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

}
