package com.example.almazon.exceptions;

public class StringIsEmptyException extends Exception {
    public StringIsEmptyException() {
        super("The string can't be empty.");
    }
}
