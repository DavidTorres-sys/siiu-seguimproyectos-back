package com.udea.siiuseguimproyectosback.utils;

public class ValidateParams {

    /**
     * Validates the pagination parameters.
     *
     * @param skip  number of records to skip
     * @param limit maximum number of records to return
     * @throws IllegalArgumentException if the parameters are invalid
     */
    public static void validatePaginationParams(Integer skip, Integer limit) {
        if (skip < 0 || limit <= 0) {
            throw new IllegalArgumentException("Los valores de 'skip' y 'limit' deben ser mayores a cero.");
        }
    }
}
