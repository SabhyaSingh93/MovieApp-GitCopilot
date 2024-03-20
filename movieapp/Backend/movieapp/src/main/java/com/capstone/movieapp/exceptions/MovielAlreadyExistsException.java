package com.capstone.movieapp.exceptions;

/**
 * This exception is thrown when an movie already exists in the system.
 */
public class MovielAlreadyExistsException extends Exception {
    public MovielAlreadyExistsException(String message) {
        super(message);
    }
}
