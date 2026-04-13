package com.epam.array.exception;

/**
 * Custom exception for array validation errors.
 */
public class ArrayValidationException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message
     */
    public ArrayValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause
     */
    public ArrayValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
