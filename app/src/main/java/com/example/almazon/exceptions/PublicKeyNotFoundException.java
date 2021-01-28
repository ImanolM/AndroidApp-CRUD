package com.example.almazon.exceptions;

public class PublicKeyNotFoundException extends Exception {
    public PublicKeyNotFoundException() {
        super("The public key does not exist.");
    }
}
