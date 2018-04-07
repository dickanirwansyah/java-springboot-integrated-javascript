package com.spring.ajax.springbootajax.model;

import com.spring.ajax.springbootajax.entity.Category;

public class BookModel {

    private String idbuku;
    private String title;
    private String author;
    private int quantity;
    private int price;
    private Category category;
    private boolean disabled;


    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getIdbuku(){
        return idbuku;
    }

    public void setIdbuku(String idbuku){
        this.idbuku = idbuku;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public boolean isDisabled(){
        return disabled;
    }

    public void setDisabled(boolean disabled){
        this.disabled = disabled;
    }
}
