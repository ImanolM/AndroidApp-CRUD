package com.example.almazon.exceptions;

/**
 * Excepción propia que se ejecuta cuando la clave pública no ha sido recogida por el cliente desde
 * servidor.
 */
public class PublicKeyNotFoundException extends Exception {
    public PublicKeyNotFoundException() {
        super("The public key does not exist.");
    }
}
