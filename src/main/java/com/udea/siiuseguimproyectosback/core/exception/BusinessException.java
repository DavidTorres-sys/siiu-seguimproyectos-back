package com.udea.siiuseguimproyectosback.core.exception;

/**
 * Exception for business logic errors in the application.
 * <p>
 * This exception is thrown when a business rule is violated, such as when an operation
 * is attempted that is not allowed due to business constraints. It is typically used
 * for handling validation errors or rule violations that are part of the business logic.
 * </p>
 */
public class BusinessException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for BusinessException with a message.
     * <p>
     * This constructor is used to create an instance of the exception with a specific message
     * describing the business rule violation.
     * </p>
     *
     * @param message the message describing the business logic error.
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Constructor for BusinessException with a message and a translation key.
     * <p>
     * This constructor is used to create an instance of the exception with a specific message
     * and a translation key for retrieving the localized error message.
     * </p>
     *
     * @param message the message describing the business logic error.
     * @param translationKey the key for message translation, used for localization.
     */
    public BusinessException(String message, String translationKey) {
        super(message, translationKey);
    }
}
