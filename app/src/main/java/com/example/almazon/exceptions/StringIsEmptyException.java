package com.example.almazon.exceptions;

/**
 * Excepción propia en caso de una variable string esté vacia.
 */
public class StringIsEmptyException extends Exception {
    public StringIsEmptyException() {
        super("The string can't be empty.");
    }
}
