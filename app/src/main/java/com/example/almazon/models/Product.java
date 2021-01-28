package com.example.almazon.models;

/**
 * Clase que contiene los atributos del producto: id, weight, price, name y user.
 */
public class Product {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del producto.
     */
    private Integer id;
    /**
     * Peso del producto.
     */
    private float weight;
    /**
     * Precio del producto.
     */
    private float price;
    /**
     * Nombre del producto.
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Usuario que creó el producto.
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
