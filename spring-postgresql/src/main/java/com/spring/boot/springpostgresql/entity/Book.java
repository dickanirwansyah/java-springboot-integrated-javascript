package com.spring.boot.springpostgresql.entity;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "book",
        catalog = "springboot")
public class Book implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idbuku;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "disabled", nullable = false)
    private boolean disabled;

    public Book(Category category, String title, String author, int quantity, int price){
        this.category = category;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

   public Book(){

   }


    public String getIdbuku() {
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

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
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
