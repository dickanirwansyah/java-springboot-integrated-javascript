package com.spring.boot.springpostgresql.model.models;

import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModels {

    //BookModels di ambil dari entity Book

    private String idbuku;
    private String title;
    private String author;
    private int quantity;
    private Category category;
    private int price;
    private boolean disabled;

    //constructor book dari entity book
    public BookModels(Book book){
        this.idbuku = book.getIdbuku();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.quantity = book.getQuantity();
        this.category = book.getCategory();
        this.disabled = book.isDisabled();
        this.price = book.getPrice();
    }

    //constructor book dari class book models
    public BookModels(String idbuku, String title, String author, int quantity, Category category, int price, boolean disabled){
        this.idbuku = idbuku;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        this.disabled = disabled;
    }
}
