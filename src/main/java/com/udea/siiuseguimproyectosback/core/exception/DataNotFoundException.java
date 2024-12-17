package com.udea.siiuseguimproyectosback.core.exception;

/**
 * Exception thrown when a resource or data is not found.
 * <p>
 * This exception is used to signal that a requested resource or data does not exist
 * in the context where it is being queried or accessed.
 * </p>
 */
public class DataNotFoundException extends GeneralRuntimeException {

    // Ensuring serialization compatibility
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for DataNotFoundException with a custom message.
     *
     * @param message the exception message explaining the reason for the error
     */
    public DataNotFoundException(String message) {
        super(message);  // Call the constructor of the parent class with the message
    }

}
