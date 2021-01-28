package com.example.almazon.validations;

import com.example.almazon.exceptions.StringIsEmptyException;

/**
 * Clase que contiene distintas validaciones de campos.
 */
public class GenericValidations {

    public GenericValidations() {

    }

    public Float checkIfValueIsFloat(String value) throws NumberFormatException {
        return Float.parseFloat(value);
    }

    public void checkIfStringIsEmpty(String value) throws StringIsEmptyException {
        if (value.trim().equalsIgnoreCase("")) {
            throw new StringIsEmptyException();
        }
    }

}
