package com.udea.siiuseguimproyectosback.core.handler;

import com.udea.siiuseguimproyectosback.core.common.StandardResponse;
import com.udea.siiuseguimproyectosback.core.exception.AuthenticationException;
import com.udea.siiuseguimproyectosback.core.exception.BusinessException;
import com.udea.siiuseguimproyectosback.core.exception.DataDuplicatedException;
import com.udea.siiuseguimproyectosback.core.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * GlobalExceptionHandler handles exceptions globally across the application.
 * <p>
 * This class uses Spring's {@link RestControllerAdvice} to manage exceptions and
 * return consistent error responses in a {@link StandardResponse} format. It provides
 * handlers for specific exceptions and a generic fallback for all other unexpected errors.
 * </p>
 *
 * <p><strong>Handled Exceptions:</strong></p>
 * <ul>
 *     <li>{@link BusinessException} - Handles business logic-related errors.</li>
 *     <li>{@link DataNotFoundException} - Handles cases where requested data is not found.</li>
 *     <li>{@link DataDuplicatedException} - Handles cases of data duplication errors.</li>
 *     <li>{@link AuthenticationException} - Handles authentication-related errors.</li>
 *     <li>{@link IllegalArgumentException} - Handles invalid method arguments or input.</li>
 *     <li>{@link Throwable} - Handles any other unanticipated errors.</li>
 * </ul>
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles {@link BusinessException} globally.
     *
     * @param ex the BusinessException to handle.
     * @return a {@link ResponseEntity} with a {@link StandardResponse} containing the error message.
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<StandardResponse<String>> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    /**
     * Handles {@link DataNotFoundException} globally.
     *
     * @param ex the DataNotFoundException to handle.
     * @return a {@link ResponseEntity} with a {@link StandardResponse} containing the error message.
     */
    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<StandardResponse<String>> handleDataNotFoundException(DataNotFoundException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    /**
     * Handles {@link DataDuplicatedException} globally.
     *
     * @param ex the DataDuplicatedException to handle.
     * @return a {@link ResponseEntity} with a {@link StandardResponse} containing the error message.
     */
    @ExceptionHandler(DataDuplicatedException.class)
    protected ResponseEntity<StandardResponse<String>> handleDataDuplicatedException(DataDuplicatedException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    /**
     * Handles {@link AuthenticationException} globally.
     * <p>
     * This handles errors related to authentication failures, returning an
     * HTTP 401 Unauthorized status.
     * </p>
     *
     * @param ex the AuthenticationException to handle.
     * @return a {@link ResponseEntity} with a {@link StandardResponse} containing the error message.
     */
    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<StandardResponse<String>> handleAuthenticationException(AuthenticationException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }

    /**
     * Handles {@link IllegalArgumentException} globally.
     *
     * @param ex the IllegalArgumentException to handle.
     * @return a {@link ResponseEntity} with a {@link StandardResponse} containing the error message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<StandardResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    /**
     * Handles all other {@link Throwable} exceptions globally as a fallback.
     * <p>
     * This method ensures that unexpected errors return a generic message and an
     * HTTP 500 status code.
     * </p>
     *
     * @param ex the Throwable to handle.
     * @return a {@link ResponseEntity} with a {@link StandardResponse} containing a generic error message.
     */
    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<StandardResponse<String>> handleThrowable(Throwable ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR,
                        "No se ha podido procesar su solicitud. Contacte al administrador."),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
