package com.spring.boot.spriNG.model;

import com.spring.boot.spriNG.entity.Category;

public class ModelPhone {

    private String idphone;
    private String name;
    private int quantity;
    private String description;
    private int price;
    private Category category;

    public String getIdphone(){
        return idphone;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getDescription(){
        return description;
    }

    public int getPrice(){
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
