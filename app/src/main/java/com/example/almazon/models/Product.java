package com.example.almazon.models;

public class Product {

    private static final long serialVersionUID = 1L;
    /**
     * Identification field for the product.
     */
    private Integer id;
    /**
     * The weight of the product.
     */
    private float weight;
    /**
     * The price of the product.
     */
    private float price;
    /**
     * The name of the product.
     */
    private String name;

    /**
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id the id to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     *
     * @param weight the weight to be set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     *
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price the price to be set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * User for the product.
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
