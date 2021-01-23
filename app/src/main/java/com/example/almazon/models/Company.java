package com.example.almazon.models;

import java.io.Serializable;

public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identification field of the Company.
     */
    private long id;

    /**
     * Name of the Company.
     */
    private String name;

    /**
     * Type of the Company.
     */
    private CompanyType type;

    /**
     * Localization of the Company.
     */
    private String localization;

    /**
     * The constructor without parameters for the Company model.
     */
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
