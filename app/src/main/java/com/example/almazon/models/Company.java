package com.example.almazon.models;

import java.io.Serializable;

/**
 * Clase que contiene los atributos de compañía: id, name, type, localization.
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la compañia.
     */
    private long id;

    /**
     * Nombre de la compañia.
     */
    private String name;

    /**
     * Tipo de la compañia.
     */
    private CompanyType type;

    /**
     * Localización de la compañia.
     */
    private String localization;

    public Company() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }
}
