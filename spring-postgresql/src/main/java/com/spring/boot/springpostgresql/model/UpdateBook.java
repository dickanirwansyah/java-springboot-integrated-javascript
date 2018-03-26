package com.spring.boot.springpostgresql.model;

import com.spring.boot.springpostgresql.entity.Category;

public class UpdateBook {

    private String idbuku;
    private String title;
    private String author;
    private int quantity;
    private Category category;
    private int price;
    private boolean disabled;

    public String getIdbuku(){
        return idbuku;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getQuantity(){
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice(){
        return price;
    }

    public boolean isDisabled(){
        return disabled;
    }
}
