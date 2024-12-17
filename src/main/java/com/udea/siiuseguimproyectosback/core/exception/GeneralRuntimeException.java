package com.udea.siiuseguimproyectosback.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Generic exception class for runtime exceptions in the application.
 * <p>
 * This is a custom exception class that extends {@link RuntimeException} to provide more specific error handling.
 * It includes an optional translation key for internationalization and a message for error reporting.
 * </p>
 */
@Getter
@Setter
public class GeneralRuntimeException extends RuntimeException {

    /** Ensures serialization compatibility */
    private static final long serialVersionUID = 1L;

    /** The message describing the exception */
    private final String message;

    /** The translation key for localized error messages */
    private final String translationKey;

    /**
     * Constructor for creating a GeneralRuntimeException with a message.
     * <p>
     * This constructor initializes the exception with a message that describes the error.
     * The translation key will be set to {@code null}.
     * </p>
     *
     * @param message the exception message describing the error
     */
    public GeneralRuntimeException(String message) {
        super(message);  // Call the constructor of RuntimeException
        this.message = message;
        this.translationKey = null;
    }

    /**
     * Constructor for creating a GeneralRuntimeException with a message and a throwable cause.
     * <p>
     * This constructor is useful when you want to propagate another exception (cause) along with your own message.
     * </p>
     *
     * @param message the exception message describing the error
     * @param throwable the cause of the exception (can be another exception)
     */
    public GeneralRuntimeException(String message, Throwable throwable) {
        super(message, throwable);  // Call the constructor of RuntimeException with the message and cause
        this.message = message;
        this.translationKey = null;
    }

    /**
     * Constructor for creating a GeneralRuntimeException with a message and a translation key.
     * <p>
     * This constructor allows specifying a message and a translation key to be used in internationalized error messages.
     * </p>
     *
     * @param message the exception message describing the error
     * @param translationKey the key for localized error messages
     */
    public GeneralRuntimeException(String message, String translationKey) {
        super(message);  // Call the constructor of RuntimeException
        this.message = message;
        this.translationKey = translationKey;
    }
}
