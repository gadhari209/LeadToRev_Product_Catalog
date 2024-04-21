package com.example.demo.model;


import jakarta.persistence.*;

@Embeddable
public class Availability {

    private boolean inStock;
    private int quantity;

    // Constructors
    public Availability() {}

    public Availability(boolean inStock, int quantity) {
        this.inStock = inStock;
        this.quantity = quantity;
    }

    // Getters and Setters
    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

