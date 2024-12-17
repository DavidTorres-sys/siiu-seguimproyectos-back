package com.udea.siiuseguimproyectosback.core.exception;

/**
 * Exception for database-related errors in the application.
 * <p>
 * This exception is thrown when there is a problem with database operations,
 * such as connection issues, query errors, or integrity constraint violations.
 * </p>
 */
public class DataBaseException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for DataBaseException with a message.
     * <p>
     * This constructor is used to create an instance of the exception with a specific message
     * describing the database-related error.
     * </p>
     *
     * @param message the message describing the database error.
     */
    public DataBaseException(String message) {
        super(message);
    }

    /**
     * Constructor for DataBaseException with a message and a translation key.
     * <p>
     * This constructor is used to create an instance of the exception with a specific message
     * and a translation key for retrieving the localized error message.
     * </p>
     *
     * @param message the message describing the database error.
     * @param translationKey the key for message translation, used for localization.
     */
    public DataBaseException(String message, String translationKey) {
        super(message, translationKey);
    }
}
