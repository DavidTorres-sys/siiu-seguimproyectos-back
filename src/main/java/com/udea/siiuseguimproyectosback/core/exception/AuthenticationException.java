package com.udea.siiuseguimproyectosback.core.exception;

/**
 * Custom exception class for handling authentication-related errors.
 * <p>
 * This exception extends {@link GeneralRuntimeException} and is used to indicate
 * issues that occur during authentication processes, such as invalid credentials
 * or access denial. It provides a way to convey meaningful error messages when
 * authentication failures occur in the application.
 * </p>
 *
 * <p><strong>Usage:</strong></p>
 * <pre>
 *   if (!isValidUser) {
 *       throw new AuthenticationException("Invalid username or password");
 *   }
 * </pre>
 */
public class AuthenticationException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new {@code AuthenticationException} with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public AuthenticationException(String message) {
        super(message);
    }
}
