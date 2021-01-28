package com.example.almazon.utils.database;

/**
 * Clase usuario del que se hace uso en SQLite. Contiene los atributos username y password.
 */
public class Users {
    private String username;
    private String password;

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
