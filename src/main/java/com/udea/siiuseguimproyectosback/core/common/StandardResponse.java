package com.udea.siiuseguimproyectosback.core.common;

import lombok.Getter;
import lombok.Setter;

/**
 * A generic class to standardize API responses.
 * <p>
 * This class is used to standardize the response format for all API responses. It encapsulates
 * information such as status, message, developer message, and the body of the response. The
 * body can be of any type, making this class flexible for various use cases.
 * </p>
 *
 * @param <T> the type of the body of the response
 */
@Getter
@Setter
public class StandardResponse<T> {

    /** The status of the response (e.g., OK or ERROR) */
    private Integer status;

    /** A user-facing message describing the result of the operation */
    private String message;

    /** A developer-facing message providing more details, useful for debugging */
    private String devMessage;

    /** The body of the response containing the actual data */
    private T body;

    /**
     * Default constructor for StandardResponse.
     * <p>
     * Initializes an empty response object with no status, message, or body.
     * </p>
     */
    public StandardResponse() {
    }

    /**
     * Constructor to create a response with a status and body.
     * <p>
     * This constructor sets the response's status and body.
     * </p>
     *
     * @param status the status of the response (OK or ERROR)
     * @param body the body of the response containing the data
     */
    public StandardResponse(StatusStandardResponse status, T body) {
        this.status = status.getStatus();
        this.body = body;
    }

    /**
     * Constructor to create a response with a status, message, and body.
     * <p>
     * This constructor sets the response's status, message, and body.
     * </p>
     *
     * @param status the status of the response (OK or ERROR)
     * @param message a user-facing message describing the result
     * @param body the body of the response containing the data
     */
    public StandardResponse(StatusStandardResponse status, String message, T body) {
        this.status = status.getStatus();
        this.message = message;
        this.body = body;
    }

    /**
     * Constructor to create a response with a status.
     * <p>
     * This constructor sets only the response's status.
     * </p>
     *
     * @param status the status of the response (OK or ERROR)
     */
    public StandardResponse(StatusStandardResponse status) {
        this.status = status.getStatus();
    }

    /**
     * Constructor to create a response with a message and a status.
     * <p>
     * This constructor sets the response's status and a message for the user.
     * </p>
     *
     * @param message a user-facing message describing the result
     * @param status the status of the response (OK or ERROR)
     */
    public StandardResponse(String message, StatusStandardResponse status) {
        this.status = status.getStatus();
        this.message = message;
    }

    /**
     * Constructor to create a response with a status and message.
     * <p>
     * This constructor sets the response's status and a message for the user.
     * </p>
     *
     * @param status the status of the response (OK or ERROR)
     * @param message a user-facing message describing the result
     */
    public StandardResponse(StatusStandardResponse status, String message) {
        this.status = status.getStatus();
        this.message = message;
    }

    /**
     * Constructor to create a response with a status, message, and body.
     * <p>
     * This constructor sets the response's status, message, and body.
     * </p>
     *
     * @param status the status of the response (OK or ERROR)
     * @param message a user-facing message describing the result
     * @param body the body of the response containing the data
     */
    public StandardResponse(Integer status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    /**
     * Constructor to create a response with a status, message, developer message, and body.
     * <p>
     * This constructor sets the response's status, message, developer message, and body.
     * </p>
     *
     * @param status the status of the response (OK or ERROR)
     * @param message a user-facing message describing the result
     * @param devMessage a developer-facing message with more detailed information
     * @param body the body of the response containing the data
     */
    public StandardResponse(Integer status, String message, String devMessage, T body) {
        this.status = status;
        this.message = message;
        this.devMessage = devMessage;
        this.body = body;
    }

    /**
     * Enum to represent the status of the response.
     * It contains two possible values: OK and ERROR.
     * <p>
     * The status is represented by an integer, where 0 indicates success (OK) and 1 indicates failure (ERROR).
     * </p>
     */
    public enum StatusStandardResponse {
        OK(0),  // Indicates a successful operation
        ERROR(1);  // Indicates an error occurred

        private final Integer status;

        /**
         * Constructor to set the status code.
         *
         * @param status the status code (0 for OK, 1 for ERROR)
         */
        StatusStandardResponse(Integer status) {
            this.status = status;
        }

        /**
         * Gets the integer status code.
         *
         * @return the status code (0 for OK, 1 for ERROR)
         */
        public int getStatus() {
            return status;
        }
    }
}
