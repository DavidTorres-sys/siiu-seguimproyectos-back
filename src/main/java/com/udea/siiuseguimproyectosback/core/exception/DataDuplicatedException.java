package com.udea.siiuseguimproyectosback.core.exception;

/**
 * Exception for duplicated data in the application.
 * <p>
 * This exception is thrown when an operation tries to insert or update data that already exists
 * in the system, ensuring that no duplicate records are created or updated.
 * </p>
 */
public class DataDuplicatedException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for DataDuplicatedException with a message.
     * <p>
     * This constructor is used to create an instance of the exception with a specific message
     * describing the error.
     * </p>
     *
     * @param message the message describing the duplication error.
     */
    public DataDuplicatedException(String message) {
        super(message);
    }
}
