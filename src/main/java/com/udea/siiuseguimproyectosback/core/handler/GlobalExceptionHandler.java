package com.udea.siiuseguimproyectosback.core.handler;

import com.udea.siiuseguimproyectosback.core.common.StandardResponse;
import com.udea.siiuseguimproyectosback.core.exception.BusinessException;
import com.udea.siiuseguimproyectosback.core.exception.DataDuplicatedException;
import com.udea.siiuseguimproyectosback.core.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles BusinessException globally.
     *
     * @param ex the BusinessException to handle.
     * @return a ResponseEntity with a StandardResponse indicating the error.
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<StandardResponse<String>> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    /**
     * Handles DataNotFoundException globally.
     *
     * @param ex the DataNotFoundException to handle.
     * @return a ResponseEntity with a StandardResponse indicating the error.
     */
    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<StandardResponse<String>> handleDataNotFoundException(DataNotFoundException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    /**
     * Handles DataDuplicatedException globally.
     *
     * @param ex the DataDuplicatedException to handle.
     * @return a ResponseEntity with a StandardResponse indicating the error.
     */
    @ExceptionHandler(DataDuplicatedException.class)
    protected ResponseEntity<StandardResponse<String>> handleDataDuplicatedException(DataDuplicatedException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    /**
     * Handles IllegalArgumentException globally.
     *
     * @param ex the IllegalArgumentException to handle.
     * @return a ResponseEntity with a StandardResponse indicating the error.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<StandardResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    /**
     * Handles any other Throwable globally.
     * This acts as a fallback for any unexpected errors.
     *
     * @param ex the Throwable to handle.
     * @return a ResponseEntity with a StandardResponse indicating a generic error.
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

